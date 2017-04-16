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
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) VALUE (?,?,?)");
                preparedStatement.setString(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getPassword());

                return preparedStatement;
            }
        });
    }

    public void delete(final String id) {
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("delete from userinfo where id = ?");
                preparedStatement.setString(1, id);
                return preparedStatement;
            }
        });
    }

}
