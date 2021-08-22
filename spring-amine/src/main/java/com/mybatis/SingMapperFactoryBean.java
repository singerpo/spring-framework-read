package com.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SingMapperFactoryBean implements FactoryBean<Object> {

	private Class<?> mapperClass;
	private SqlSession sqlSession;


	public SingMapperFactoryBean(Class<?> mapperClass){
		this.mapperClass = mapperClass;
	}

	public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
		sqlSessionFactory.getConfiguration().addMapper(mapperClass);
		this.sqlSession = sqlSessionFactory.openSession();
	}

	@Override
	public Object getObject() throws Exception {
//		Object proxyInstance = Proxy.newProxyInstance(SingMapperFactoryBean.class.getClassLoader(), new Class<?>[]{mapperClass}, new InvocationHandler() {
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				return null;
//			}
//		});
//		return proxyInstance;
		return sqlSession.getMapper(mapperClass);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperClass;
	}
}
