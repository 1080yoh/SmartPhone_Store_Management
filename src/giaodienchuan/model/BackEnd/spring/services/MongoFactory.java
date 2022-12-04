package giaodienchuan.model.BackEnd.spring.services;

import giaodienchuan.model.BackEnd.QuanLySanPham.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoFactory {

    private static MongoTemplate mongoTemplate;

    public static MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Autowired
    void setMongoTemplate(MongoTemplate mongoTemplate) {
        MongoFactory.mongoTemplate = mongoTemplate;
    }

}
