package mobi.zhanglv.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Author cuizhengwei
 * Date   2018/3/6
 * Description 不基于spring的mybatis session （未使用）
 */
public class SqlSessionUtil {

	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sqlSessionFactory;

	/*
	 * 禁止外部new来调用
	 */
	private SqlSessionUtil(){

	}

	/*
	 * 获取SqlSession
	 */
	public static SqlSession getSqlSession(){

		//从当前线程中获取SqlSession对象
		SqlSession sqlSession = threadLocal.get();

		//如果SqlSession为空
		if (sqlSession == null) {

			//在SqlSessionFactory非空的情况下，获取SqlSession对象
			sqlSession = sqlSessionFactory.openSession();
			//将SqlSession对象与当前线程绑定在一起
			threadLocal.set(sqlSession);
		}

		//返回SqlSession对象
		return sqlSession;
	}

	/*
	 * 关闭SqlSession与当前线程分开
	 */
	public static void closeSqlSession(){

		//从当前线程中获取SqlSession对象
		SqlSession sqlSession = threadLocal.get();

		//如果SqlSession对象非空
		if (sqlSession != null) {
			//关闭
			sqlSession.close();
			//放开当前线程与SqlSession对象的关系，让GC尽快回收
			threadLocal.remove();

		}

	}

}