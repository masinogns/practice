/**
 * Created by masinogns on 2017. 4. 16..
 */
public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(new JejuConnectionMaker());
    }
}
