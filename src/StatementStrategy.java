import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public interface StatementStrategy {
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException;
}
