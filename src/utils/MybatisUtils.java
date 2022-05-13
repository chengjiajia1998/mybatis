package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    public static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    public static InputStream inputStream;
    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession sqlSession;

    //静态代码块：类加载的时候执行，能给name赋值吗？不能，静态的成员优先于 对象存在
    static {
        // 创建 SqlSessionFactoryBuilder
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 加载 SqlMapConfig.xml 配置文件
        try {
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");


        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static SqlSession getSqlSession() {
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        return sqlSessionFactory.openSession();
    }
}
