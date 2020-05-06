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

import com.brightminds.model.Instructor;
import com.brightminds.model.User;
import com.brightminds.util.HibernateConfiguration;

@Repository(value ="instructorRepository")
@Transactional
public class InstructorRepositoryImp implements InstructorRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public InstructorRepositoryImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Instructor a) {
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
	public void update(Instructor a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Instructor> getAll() {
		List<Instructor> instructor = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			instructor = s.createNativeQuery("select * from instructor", Instructor.class).list();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		return instructor;
	}

	@Override
	public Instructor getById(int id) {
		Instructor instructor = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			
			String HQL = "FROM Instructor i WHERE id = :id";
			Query<Instructor> q = s.createQuery(HQL, Instructor.class);
			q.setParameter("id", id);
			instructor = q.getSingleResult();
			
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return instructor;
	}

	@Override
	public Instructor getByName(String name) {
		Instructor p = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder(); 
			CriteriaQuery<Instructor> cq = cb.createQuery(Instructor.class); 
			Root<Instructor> root = cq.from(Instructor.class); 
			cq.select(root).where(cb.equal(root.get("firstname"), name));
			Query<Instructor> q = s.createQuery(cq);
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
	public Instructor getByUserId(User userId) {
		Instructor instructor = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			
			String HQL = "FROM Instructor i WHERE userid = :userId";
			Query<Instructor> q = s.createQuery(HQL, Instructor.class);
			q.setParameter("userId", userId);
			instructor = q.getSingleResult();

			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return instructor;
	}

	@Override
	public void editInfo(Instructor i) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = sessionFactory.openSession();
			tx = s.beginTransaction();
			
			String HQL = "UPDATE Instructor i SET "
					+ "firstname = :firstname, "
					+ "lastname = :lastname, "
					+ "phonenumber = :phonenumber, "
					+ "address = :address, "
					+ "dateofbirth = :dateofbirth, "
					+ "degree = :degree "
					+ "WHERE id = :id";
			Query<Instructor> q = s.createQuery(HQL);
			
			q.setParameter("firstname", i.getFirstName());
			q.setParameter("lastname", i.getLastName());
			q.setParameter("phonenumber", i.getPhoneNumber());
			q.setParameter("address", i.getAddress());
			q.setParameter("dateofbirth", i.getDateOfBirth());
			q.setParameter("degree", i.getDegree());
			q.setParameter("id", i.getId());
			
			q.executeUpdate();

			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}		
	}

}
