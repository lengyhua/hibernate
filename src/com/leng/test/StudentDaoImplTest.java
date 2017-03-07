package com.leng.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.leng.dao.GradeDao;
import com.leng.dao.StudentDao;
import com.leng.dao.impl.GradeDaoImpl;
import com.leng.dao.impl.StudentDaoImpl;
import com.leng.model.Grade;
import com.leng.model.Student;
import com.leng.util.HibernateSessionFactory;

public class StudentDaoImplTest {
	
	private StudentDao dao = new StudentDaoImpl();
	private GradeDao gDao = new GradeDaoImpl();
	
	@Test
	public void testSave() {
		Grade g1 = gDao.get(1);
		Grade g2 = gDao.get(2);
		Grade g3 = gDao.get(3);
		Student stu1 = new Student("aa",10);
		Student stu2 = new Student("bb",11);
		Student stu3 = new Student("cc",12);
		Student stu4 = new Student("dd",13);
		Student stu5 = new Student("ee",13);
		Student stu6 = new Student("ff",11);
		Student stu7 = new Student("gg",10);
		Student stu8 = new Student("hh",12);
		stu1.setGrade(g1);
		stu2.setGrade(g3);
		stu3.setGrade(g2);
		stu4.setGrade(g1);
		stu5.setGrade(g2);
		stu6.setGrade(g3);
		stu7.setGrade(g1);
		stu8.setGrade(g3);
		dao.save(stu8);
		dao.save(stu7);
		dao.save(stu6);
		dao.save(stu5);
		dao.save(stu4);
		dao.save(stu3);
		dao.save(stu2);
		dao.save(stu1);
	}

	@Test
	public void testGet() {
		System.out.println(dao.get(4));
	}

	@Test
	public void testDelete() {
		dao.delete(3);
	}

	@Test
	public void testQuery() {
		for(Student stu : dao.query()){
			System.out.print(stu);
			System.out.println("  班级为：" + stu.getGrade());
		}
	}

	@Test
	public void testUpdate() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Student s = dao.get(7);
		s.setGrade(gDao.get(2));
		tx.commit();
	}

}
