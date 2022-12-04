package giaodienchuan.model.BackEnd.common;

import giaodienchuan.model.BackEnd.spring.services.MongoFactory;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class CommonDAO<T> {

    private final Class<T> type;

    public CommonDAO(Class<T> type) {
        this.type = type;
    }

    private Query queryEq(Map<String, Object> dieuKien) {
        return queryEq(new Query(), dieuKien);
    }

    private Query queryEq(Query query, Map<String, Object> dieuKien) {
        if (ObjectUtils.isEmpty(dieuKien)) {
            return query;
        }
        for (Map.Entry<String, Object> tc : dieuKien.entrySet()) {
            query.addCriteria(Criteria.where(tc.getKey()).is(tc.getValue()));
        }
        return query;
    }

    private Query queryLike(Map<String, Object> dieuKien) {
        return queryLike(new Query(), dieuKien);
    }

    private Query queryLike(Query query, Map<String, Object> dieuKien) {
        if (ObjectUtils.isEmpty(dieuKien)) {
            return query;
        }
        for (Map.Entry<String, Object> tc : dieuKien.entrySet()) {
            query.addCriteria(Criteria.where(tc.getKey()).regex(".*" + tc.getValue() + ".*", "i"));
        }
        return query;
    }

    protected Map<String, Object> toMap(Object[][] objects) {
        if (ObjectUtils.isEmpty(objects)) {
            return new HashMap<>();
        }
        return Stream.of(objects)
                .collect(Collectors.toMap(data -> (String) data[0], data -> data[1]));
    }

    protected ArrayList<T> readDB() {
        return new ArrayList<>(MongoFactory.getMongoTemplate().findAll(type));
    }

    protected ArrayList<T> searchLike(String columnName, String value) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {columnName, value}
        });
        return search(null, dieuKien);
    }

    protected ArrayList<T> search(Map<String, Object> dieuKienBang, Map<String, Object> dieuKienLike) {
        Query query = new Query();
        queryEq(query, dieuKienBang);
        queryLike(query, dieuKienLike);
        return new ArrayList<>(MongoFactory.getMongoTemplate().find(query, type));
    }

    protected Boolean add(T dto) {
        MongoFactory.getMongoTemplate().save(dto);
        return true;
    }

    public Boolean update(Map<String, Object> dieuKien, T dto) {
        Query query = queryEq(dieuKien);
        MongoFactory.getMongoTemplate().findAndReplace(query, dto);
        return true;
    }

    public Boolean update(Map<String, Object> dieuKien, Map<String, Object> truong) {
        Query query = queryEq(dieuKien);
        if (ObjectUtils.isEmpty(truong)) {
            return true;
        }
        Update update = new Update();
        for (Map.Entry<String, Object> entry : truong.entrySet()) {
            update.set(entry.getKey(), entry.getValue());
        }
        MongoFactory.getMongoTemplate().updateMulti(query, update, type);
        return true;
    }

    protected Boolean delete(Map<String, Object> dieuKien) {
        MongoFactory.getMongoTemplate().findAllAndRemove(queryEq(dieuKien), type);
        return true;
    }

}
