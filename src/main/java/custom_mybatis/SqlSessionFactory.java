package custom_mybatis;

/**
 * @author hailang.zhang
 * @since 2024-03-31
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}