package example.privatemethod.demo;

/**
 * Created by wangxun on 2016/5/6.
 */
public class Coach {
    private Dao dao;

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    private boolean isMessi(Player player) {
        if ("messi".equals(player.getName())) {
            dao.save();
            return true;
        }
        return false;
    }

    public void exercise(Player player) {
        if (isMessi(player)) {
            System.out.println("跑一圈");
        } else {
            System.out.println("跑两圈");
        }
    }

    public void exercise(int num) {

    }
}
