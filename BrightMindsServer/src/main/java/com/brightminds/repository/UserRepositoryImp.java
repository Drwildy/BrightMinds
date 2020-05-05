package com.brightminds.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
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

import com.brightminds.model.User;

@Repository(value ="userRepository")
@Transactional
public class UserRepositoryImp implements UserRepository {

	private SessionFactory sessionFactory;
	
	@Autowired
	public UserRepositoryImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insert(User a) {
		Session s = null;
		Transaction tx = null;
		try {
			s = sessionFactory.openSession();
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
	public void update(User a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		List<User> user = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			user = s.createNativeQuery("select * from user", User.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return user;
	}

	@Override
	public User getById(int id) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			user = (User) s.get(User.class, id);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return user;
	}

	@Override
	public User getByName(String name) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class); 
			cq.select(root).where(cb.equal(root.get("firstName"), name));
			Query<User> q = s.createQuery(cq);
			user = q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return user;
	}
	
	@Override
	public User getByUsername(String username) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class); 
			cq.select(root).where(cb.equal(root.get("username"), username));
			Query<User> q = s.createQuery(cq);
			user = q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return user;
	}
	
	@Override
	public User login(String username, String password) {
		User user = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			
			String HQL = "FROM User u WHERE username = :username AND password = :password";
			Query<User> q = s.createQuery(HQL, User.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			user = q.getSingleResult();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}catch(NoResultException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return user;
	}

}
