package test;

import dao.UserMapper;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MybatisUtils;
import vo.UserVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TestMybatis {

    public static void main(String[] aa) throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        //执行查询
        List<entity.User> users = userMapper.findAllUser();

        for (entity.User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test01() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        User user = new User();


        //user.setUsername("");
        // user.setAddress("蜀");
        user.setAddress("蜀");

        //执行查询
        List<entity.User> users = userMapper.findUserByNameAndAddress(user);

        for (entity.User u : users) {
            System.out.println(u);
        }

        sqlSession.close();
    }


    @Test
    public void test02() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        User user = new User();


        user.setUsername("张");
        //user.setAddress("蜀");
        //user.setSex("男");

        //执行查询
        List<entity.User> users = userMapper.findUserByNameOrAddressOrSex(user);

        for (entity.User u : users) {
            System.out.println(u);
        }

        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        User user = new User();
        user.setId(16);
        user.setUsername("韦小宝");

        //user.setAddress("蜀");
        //user.setSex("男");

        //执行查询
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        User user = new User();

        user.setUsername("张");

        //执行查询
        List<entity.User> users = userMapper.findUserByName(user);

        for (entity.User u : users) {
            System.out.println(u);
        }

        sqlSession.close();
    }


    // 使用foreach 标签
    // 查  询 ID=  10  16 27三个用户
    @Test
    public void test05() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        User user = new User();
        /*Integer [] ids = new Integer[3];
        ids[0]=10;
        ids[1]=16;
        ids[2]=27;*/

        List ids = new ArrayList();
        ids.add(10);
        ids.add(16);
        ids.add(27);

        Map map = new HashMap();

        map.put("ids", ids);

        //执行查询
        //List<entity.User> users = userMapper.findUserByIds(ids);
        List<entity.User> users = userMapper.findUserByIdsMap(map);

        for (entity.User u : users) {
            System.out.println(u);
        }

        sqlSession.close();
    }


    /*
     * 通过vo查询
     * */
    @Test
    public void test06() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);

        UserVo vo = new UserVo();

        User user = new User();

        //user.setUsername("");
        // user.setAddress("蜀");
        user.setAddress("蜀");

        vo.setUser(user);


        //执行查询
        List<entity.User> users = userMapper.findUserByVo(vo);

        for (entity.User u : users) {
            System.out.println(u);
        }
    }

    // 使用通过vo 属性里面放 array或者list
    // 查  询 ID=  10  16 27三个用户
    @Test
    public void test07() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(dao.UserMapper.class);


        //数组
        /* Integer [] ids = new Integer[3];
        ids[0]=10;
        ids[1]=16;
        ids[2]=27;*/

        //集合
        List ids = new ArrayList();
        ids.add(10);
        ids.add(16);
        ids.add(27);

        UserVo vo = new UserVo();
        vo.setIdss(ids);

        //vo.setIds(ids);

        //执行查询
        List<entity.User> users = userMapper.findUserByVo1(vo);

        for (entity.User u : users) {
            System.out.println(u);
        }

        sqlSession.close();
        
    }
}
