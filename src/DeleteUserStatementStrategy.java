import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public class DeleteUserStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from userinfo where id = ?");
        preparedStatement.setString(1, (String)object);
        return preparedStatement;
    }
}
