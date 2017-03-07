package com.leng.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;

import com.leng.dao.BaseDao;
import com.leng.util.HibernateSessionFactory;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class<T> clazz;
	
	public BaseDaoImpl(){
		
		ParameterizedType genType = (ParameterizedType)getClass().getGenericSuperclass();
	    Type[] params =  genType.getActualTypeArguments();
	    clazz = (Class<T>) params[0];
		
	}
	
	@Override
	public void save(T t) {
		Session session = getSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	@Override
	public T get(int id) {
		return getSession().get(clazz, id);
	}

	@Override
	public void delete(int id) {
		Session session = getSession();
		session.beginTransaction();
		getSession().createQuery("delete from " + clazz.getSimpleName() +" where id=:id").setInteger("id", id).executeUpdate();
		session.getTransaction().commit();
	}

	@Override
	public List<T> query() {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	@Override
	public void update(T t) {
		Session session = getSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();
		session.close();
	}
	
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
}
