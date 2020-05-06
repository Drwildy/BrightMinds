package com.brightminds.repository;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brightminds.model.Course;
import com.brightminds.model.Instructor;
import com.brightminds.util.HibernateConfiguration;

@Repository(value = "courseRepository")
@Transactional
public class CourseRepositoryImp implements CourseRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public CourseRepositoryImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Course a) {
		// TODO Auto-generated method stub
		try {
			Session s = null;
			Transaction tx = null;
			try {
				// s = HibernateConfiguration.getSession();
				s = sessionFactory.openSession();
				tx = s.beginTransaction();
				s.save(a);
				tx.commit();
			} catch (HibernateException e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				s.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Course a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int a) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Course> getAll() {
		List<Course> course = new ArrayList<>();
		Session s = null;
		Transaction tx = null;

		try {
//			s = HibernateConfiguration.getSession();
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			course = s.createNativeQuery("select * from course", Course.class).list();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		return course;
	}

	@Override
	public Course getById(int id) {
		Course p = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Course> cq = cb.createQuery(Course.class);
			Root<Course> root = cq.from(Course.class);
			cq.select(root).where(cb.equal(root.get("courseId"), id));
			Query<Course> q = s.createQuery(cq);
			p = q.getSingleResult();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}

		return p;
	}

	@Override
	public Course getByName(String name) {
		Course p = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Course> cq = cb.createQuery(Course.class);
			Root<Course> root = cq.from(Course.class);
			cq.select(root).where(cb.equal(root.get("coursename"), name));
			Query<Course> q = s.createQuery(cq);
			p = q.getSingleResult();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}

		return p;
	}

	@Override
	public List<Course> getMyCoursesById(Instructor i) {
		List<Course> courses = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			
			String HQL = "FROM Course c WHERE instructor_id = :instructorid AND status = 2";
			Query<Course> q = s.createQuery(HQL, Course.class);
			q.setParameter("instructorid", i);
			courses = q.getResultList();

			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return courses;
	}

}
