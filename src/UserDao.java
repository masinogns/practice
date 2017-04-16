import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public class UserDao {


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    JdbcTemplate jdbcTemplate;


    public User get(final String id) throws ClassNotFoundException, SQLException {
        String sql = "select * from userinfo where id = ?";
        Object[] args = new String[] {id};
        User queryForObject = null;

        try {
            queryForObject = getJdbcTemplate().queryForObject(sql, args, new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getString("id"));
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

        return queryForObject;
    }

    public void add(final User user) throws ClassNotFoundException, SQLException {
        final String sql = "insert into userinfo (id, name, password) VALUE (?,?,?)";
        final String[] params = new String[] {user.getId(), user.getName(), user.getPassword()};

        jdbcTemplate.update(sql, params);
    }

    public void delete(final String id) {
        final String sql = "delete from userinfo where id = ?";
        final String[] params = new String[] {id};

        jdbcTemplate.update(sql, params);
    }





}
