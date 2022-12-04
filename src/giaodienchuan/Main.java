package giaodienchuan;

import giaodienchuan.model.BackEnd.spring.config.SystemEnvConfig;
import giaodienchuan.model.FrontEnd.GiaoDienChuan.LoginForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
        SystemEnvConfig.config();
        SpringApplication.run(Main.class, args);
        new LoginForm().setVisible(true);
    }
}
