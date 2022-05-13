package vo;

import entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserVo {

    //vo: view object
    public User user;
    public Integer[] ids = new Integer[3];
    public List idss = new ArrayList();

    /*
     *
     *   userVoMap.put("user",user)
     *   userVoMap.put("ids",ids)
     *   userVoMap.put("idss",idss)
     *
     *
     * */
    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public List getIdss() {
        return idss;
    }

    public void setIdss(List idss) {
        this.idss = idss;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
