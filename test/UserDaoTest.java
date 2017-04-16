import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by masinogns on 2017. 4. 16..
 */
public class UserDaoTest{

    private UserDao userDao;

    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = context.getBean("userDao", UserDao.class);

    }


    @Test
    public void get() throws SQLException, ClassNotFoundException {

        String id = "1";
        String name = "masinogns";
        String password = "masinogns";


        User user = userDao.get(id);

        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String id = String.valueOf(new Random().nextInt());
        String name = "rlgnsqor";
        String password = "rlgnsqor";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.add(user);

        User addedUser = userDao.get(id);
        assertThat(id, is(addedUser.getId()));
        assertThat(name, is(addedUser.getName()));
        assertThat(password, is(addedUser.getPassword()));
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {

        String id = String.valueOf(new Random().nextInt());
        String name = "rlgnsqor";
        String password = "rlgnsqor";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.add(user);
        userDao.delete(id);

        User deletedUser = userDao.get(id);
        assertThat(deletedUser, nullValue());
    }




}
