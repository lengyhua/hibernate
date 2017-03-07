package com.leng.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.junit.Test;

import com.leng.dao.GradeDao;
import com.leng.dao.impl.GradeDaoImpl;
import com.leng.model.Grade;
import com.leng.util.HibernateSessionFactory;

public class GradeDaoImplTest {
	
	private GradeDao dao = new GradeDaoImpl();
	
	@Test
	public void testSave() {
		dao.save(new Grade("一年级"));
		dao.save(new Grade("二年级"));
		dao.save(new Grade("三年级"));
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		for(Grade grade : dao.query()){
			System.out.println(grade);
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testQueryWithCondition(){
		
		
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Grade.class);
		List<Grade> grades = criteria.add(Restrictions.between("id", 1, 5)).addOrder(Order.desc("id")).list();
		for(Grade grade : grades){
			System.out.println(grade);
		}
	}
	
}