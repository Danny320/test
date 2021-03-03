import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/29 11:13
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         String defaultDatabaseName = "";//数据库名称
         String password = "";
         String user = "root";
         String url = "jdbc:mysql://127.0.0.1:3306/"
                 + defaultDatabaseName
                 + "?useSSL=false&characterEncoding=utf8";
        DriverManager.getConnection(url,user,password);
    }

}
