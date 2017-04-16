import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public class AddUserStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("insert into userinfo (id, name, password) VALUE (?,?,?)");
        User user = (User)object;
        preparedStatement.setString(1,user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        return preparedStatement;
    }
}
