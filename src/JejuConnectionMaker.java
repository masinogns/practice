import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 16..
 */
class JejuConnectionMaker implements ConnectionMaker{
    String className ;
    String password ;
    String id;
    String url;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName(className);
        return DriverManager.getConnection(url, id, password);
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
