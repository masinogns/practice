import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public class UserDao {

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    JdbcContext jdbcContext;


    public User get(final String id) throws ClassNotFoundException, SQLException {
        return jdbcContext.jdbcContextWithStatementStratdgyForGet(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");

                preparedStatement.setString(1, id);

                return preparedStatement;
            }
        });
    }

    public void add(final User user) throws ClassNotFoundException, SQLException {
        final String sql = "insert into userinfo (id, name, password) VALUE (?,?,?)";
        final String[] params = new String[] {user.getId(), user.getName(), user.getPassword()};

        jdbcContext.update(sql, params);
    }

    public void delete(final String id) {
        final String sql = "delete from userinfo where id = ?";
        final String[] params = new String[] {id};

        jdbcContext.update(sql, params);
    }





}
