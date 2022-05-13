package dao;

import entity.User;
import vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> findAllUser();

    List<User> findUserByNameAndAddress(User user);


    //userMap.put("username",username).put("address",address)
    List<User> findUserByNameAddress(Map userMap);

    //通过vo查询
    List<User> findUserByVo(UserVo vo);

    List<User> findUserByNameOrAddressOrSex(User user);

    int updateUser(User user);

    List<User> findUserByName(User user);

    //List<User> findUserByIds (Integer [] ids);

    List<User> findUserByIds(List<Integer> ids);

    List<User> findUserByVo1(UserVo vo);


    List<User> findUserByIdsMap(Map map);


}
