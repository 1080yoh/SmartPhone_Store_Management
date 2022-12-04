package giaodienchuan.model.BackEnd.ConnectionDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ConnectionDB {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionDB.class);

    static int countConection = 0;
    static int countQuery = 0;
    static int countUpdate = 0;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    String DB_Name = null;
    String user_Name = null;
    String pass = null;

    String ipAddress = "localhost:3306";

    public ConnectionDB() {
        checkDriver();
        DB_Name = "quanlysieuthidienthoai";
        user_Name = "root";
        pass = "1234";
        setupConnect();
    }

    public ConnectionDB(String DB_Name) {
        checkDriver();
        this.DB_Name = DB_Name;
    }

    public ConnectionDB(String DB_Name, String user_Name, String pass) {
        checkDriver();
        this.DB_Name = DB_Name;
        this.user_Name = user_Name;
        this.pass = pass;
        setupConnect();
    }

    // Kết nối tới DB
    private void setupConnect() {
        try {
            String url = "jdbc:mysql://" + ipAddress + "/" + DB_Name + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, user_Name, pass);
            stmt = conn.createStatement();
            countConection++;
        } catch (SQLException e) {
            logger.error("Loi khi ket noi csdl", e);
            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể kết nối tới '" + DB_Name + "'");
        }
    }

    // đăng nhập
    public void logIn(String user_Name, String pass) {
        this.user_Name = user_Name;
        this.pass = pass;
        setupConnect();
    }

    // lấy data theo câu query
    public ResultSet sqlQuery(String qry) {
        if (checkConnect()) {
            try {
                rset = stmt.executeQuery(qry);
                countQuery++;
                return rset;

            } catch (SQLException ex) {
                logger.error("ERROR! Không thể lấy dữ liệu từ DB", ex);
                JOptionPane.showMessageDialog(null, "-- ERROR! Không thể lấy dữ liệu từ " + DB_Name + "\n" + ex.getLocalizedMessage());
                return null;
            }
        }
        return null;
    }

    // ghi data theo câu update
    public Boolean sqlUpdate(String qry) {
        if (checkConnect()) {
            try {
                stmt.executeUpdate(qry);
                countUpdate++;
                return true;
            } catch (SQLException ex) {
                logger.error("ERROR! Không thể ghi dữ liệu xuống DB", ex);
                JOptionPane.showMessageDialog(null, "-- ERROR! Không thể ghi dữ liệu xuống " + DB_Name + "\n" + ex.getLocalizedMessage());
                return false;
            }
        }
        return false;
    }

    // đóng connection
    public void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            logger.error("ERROR! Không thể đóng kết nối tới DB", ex);
            JOptionPane.showMessageDialog(null, "-- ERROR! Không thể đóng kết nối tới " + DB_Name + "\n" + ex.getLocalizedMessage());
        }
    }

    // check logIn, connect
    public Boolean checkConnect() {
        if (conn == null || stmt == null) {
            logger.error("ERROR! Chưa thiết lập kết nối tới " + DB_Name + ". Vui lòng đăng nhập để thiết lập kết nối!");
            JOptionPane.showMessageDialog(null, "-- ERROR! Chưa thiết lập kết nối tới '" + DB_Name + "'. Vui lòng đăng nhập để thiết lập kết nối!");
            return false;
        }
        return true;
    }

    // check driver
    private void checkDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("ERROR! Không tìm thấy Driver mySql ", e);
            JOptionPane.showMessageDialog(null, "-- ERROR! Không tìm thấy Driver mySql");
        }
    }

    // lấy headers của table tên tableName trong db này - đã có cách khác, không dùng hàm này nữa
    public ArrayList<String> getHeaders(String tableName) {
        ArrayList<String> headers = new ArrayList<>();
        if (checkConnect()) {
            try {
                ResultSetMetaData rsMetaData = sqlQuery("SELECT * FROM " + tableName).getMetaData();
                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                    headers.add(rsMetaData.getColumnName(i));
                }
            } catch (SQLException e) {
                logger.error("ERROR! Không thể lấy headers của " + tableName, e);
                JOptionPane.showMessageDialog(null, "-- ERROR! Không thể lấy headers của " + tableName + " trong " + DB_Name);
            }
        }
        return headers;
    }
}
