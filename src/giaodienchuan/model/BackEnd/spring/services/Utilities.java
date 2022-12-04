package giaodienchuan.model.BackEnd.spring.services;

import giaodienchuan.model.BackEnd.QuanLyTaiKhoan.TaiKhoan;
import one.util.streamex.StreamEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Component
public class Utilities {

    private static final Logger logger = LoggerFactory.getLogger(Utilities.class);

    @Autowired
    private MongoTemplate mongoTemplate;


    @PostConstruct
    public void printAllAccounts() {
        Collection<TaiKhoan> taiKhoans = mongoTemplate.findAll(TaiKhoan.class);
        StreamEx.of(taiKhoans).forEach(tk -> logger.info(tk.toString()));
    }

}
