import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public class UserDaoTest{



    @Test
    public void get() throws SQLException, ClassNotFoundException {

        String id = "1";
        String name = "masinogns";
        String password = "masinogns";

        UserDao userDao = new DaoFactory().getUserDao();
        User user = userDao.get(id);

        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        String id = String.valueOf(new Random().nextInt());
        user.setId(id);
        String name = "rlgnsqor";
        user.setName(name);
        String password = "rlgnsqor";
        user.setPassword(password);

        UserDao userDao = new DaoFactory().getUserDao();
        userDao.add(user);

        User addedUser = userDao.get(id);
        assertThat(id, is(addedUser.getId()));
        assertThat(name, is(addedUser.getName()));
        assertThat(password, is(addedUser.getPassword()));
    }


}
