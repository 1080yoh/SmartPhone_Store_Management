package giaodienchuan.model.BackEnd.spring.services;

import giaodienchuan.model.BackEnd.QuanLySanPham.SanPham;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoFactory {

    private static MongoTemplate mongoTemplate;


    @Autowired
    void setMongoTemplate(MongoTemplate mongoTemplate) {
        SanPham sanPham = SanPham.builder()
                .MaSP("SP0001")
                .TenSP("ten san pham")
                .build();
        mongoTemplate.save(sanPham, "test");
        MongoFactory.mongoTemplate = mongoTemplate;
    }

    public static MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

}
