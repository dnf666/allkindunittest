package example.privatemethod.demo;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by wangxun on 2016/5/6.
 */
public class PrivateMethodTest {

    @Test
    public void test(){
        Coach coach = new Coach();
//        Dao dao = new Dao();
        Dao dao = mock(Dao.class);
        coach.setDao(dao);
        Class<?>[] paramsClass = new Class[] {
                Player.class
        };

        Player player = new Player();
        String name = "messi";
        player.setName(name);
        Object[] paramsValue = new Object[] {
                player
        };
        try {
            Util.invoke(coach, "isMessi", paramsClass, paramsValue);
        } catch (Exception e){

        }
        verify(dao, times(1)).save();
    }

}
