package com.brightminds.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.brightminds.model.Lesson;
import com.brightminds.util.HibernateConfiguration;

public class LessonRepositoryImp implements LessonRepository{

	@Override
	public void insert(Lesson a) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.save(a);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}		
	}

	@Override
	public void update(Lesson a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Lesson> getAll() {
		List<Lesson> lesson = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			lesson = s.createNativeQuery("select * from lesson", Lesson.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return lesson;
	}

	@Override
	public Lesson getById(int id) {
		Lesson p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Lesson> cq = cb.createQuery(Lesson.class); 
			Root<Lesson> root = cq.from(Lesson.class); 
			cq.select(root).where(cb.equal(root.get("lessonId"), id));
			Query<Lesson> q = s.createQuery(cq);
			p = q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return p;
	}

	@Override
	public Lesson getByName(String name) {
		Lesson p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Lesson> cq = cb.createQuery(Lesson.class); 
			Root<Lesson> root = cq.from(Lesson.class); 
			cq.select(root).where(cb.equal(root.get("lessonname"), name));
			Query<Lesson> q = s.createQuery(cq);
			p = q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return p;
	}

}
