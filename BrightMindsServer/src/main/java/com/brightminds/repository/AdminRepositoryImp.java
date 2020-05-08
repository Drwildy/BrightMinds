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

import com.brightminds.model.Admin;
import com.brightminds.model.User;
import com.brightminds.util.HibernateConfiguration;

@Repository(value ="adminRepository")
@Transactional
public class AdminRepositoryImp implements AdminRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public AdminRepositoryImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Admin a) {
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
	public void update(Admin a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> admin = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			admin = s.createNativeQuery("select * from admin", Admin.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return admin;
	}

	@Override
	public Admin getById(int id) {
		Admin p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Admin> cq = cb.createQuery(Admin.class); 
			Root<Admin> root = cq.from(Admin.class); 
			cq.select(root).where(cb.equal(root.get("adminId"), id));
			Query<Admin> q = s.createQuery(cq);
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
	public Admin getByName(String name) {
		Admin p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Admin> cq = cb.createQuery(Admin.class); 
			Root<Admin> root = cq.from(Admin.class); 
			cq.select(root).where(cb.equal(root.get("firstname"), name));
			Query<Admin> q = s.createQuery(cq);
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
	public Admin getByUserId(User userId) {
		Admin admin = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			
			String HQL = "FROM Admin s WHERE userid = :userId";
			Query<Admin> q = s.createQuery(HQL, Admin.class);
			q.setParameter("userId", userId);
			admin = q.getSingleResult();

			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return admin;
	}

}
