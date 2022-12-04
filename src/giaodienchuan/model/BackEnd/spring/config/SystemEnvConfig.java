package giaodienchuan.model.BackEnd.spring.config;

public class SystemEnvConfig {
    public static void config() {
        System.setProperty(
                "spring.data.mongodb.uri",
                "mongodb://mongo:mongo@localhost:27017/quanlysieuthidienthoai"
        );
    }
}
