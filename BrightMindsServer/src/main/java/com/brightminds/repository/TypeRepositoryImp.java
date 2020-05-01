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

import com.brightminds.model.Type;
import com.brightminds.util.HibernateConfiguration;

public class TypeRepositoryImp implements TypeRepository{

	@Override
	public void insert(Type a) {
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
	public void update(Type a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Type> getAll() {
		List<Type> type = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			type = s.createNativeQuery("select * from type", Type.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return type;
	}

	@Override
	public Type getById(int id) {
		Type p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Type> cq = cb.createQuery(Type.class); 
			Root<Type> root = cq.from(Type.class); 
			cq.select(root).where(cb.equal(root.get("typeId"), id));
			Query<Type> q = s.createQuery(cq);
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
	public Type getByName(String name) {
		Type p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Type> cq = cb.createQuery(Type.class); 
			Root<Type> root = cq.from(Type.class); 
			cq.select(root).where(cb.equal(root.get("type"), name));
			Query<Type> q = s.createQuery(cq);
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
