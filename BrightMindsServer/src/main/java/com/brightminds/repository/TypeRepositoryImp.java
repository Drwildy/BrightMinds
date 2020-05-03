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

import com.brightminds.model.Type;
import com.brightminds.util.HibernateConfiguration;

@Repository(value ="typeRepository")
@Transactional
public class TypeRepositoryImp implements TypeRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public TypeRepositoryImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Type a) {
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
			s = sessionFactory.openSession();
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
		Type type = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			type = (Type) s.get(Type.class, id);
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
	public Type getByName(String name) {
		Type type = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			type = (Type) s.get(Type.class, name);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return type;
	}

}
