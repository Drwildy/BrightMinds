package com.brightminds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(generator ="payment_id_seq_", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="payment_id_seq", allocationSize=1)
	@Column
	private int id;
	@ManyToOne
	@JoinColumn(name="student_id")
	private int studentId;
	@OneToOne
	@JoinColumn(name="course_id")
	private int courseId;
	@Column
	private int status; //0- to be deleted 1- created 9 - cancel
	@Column
	private Date CreatedAt;
	@Column
	private Date UpdatedAt;
	
	public Payment() {
		super();
	}

	public Payment(int paymentId, int studentId, int courseId, int status, Date createdAt, Date updatedAt) {
		super();
		this.id = paymentId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.status = status;
		CreatedAt = createdAt;
		UpdatedAt = updatedAt;
	}

	public int getPaymentId() {
		return id;
	}

	public void setPaymentId(int paymentId) {
		this.id = paymentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Date getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CreatedAt == null) ? 0 : CreatedAt.hashCode());
		result = prime * result + ((UpdatedAt == null) ? 0 : UpdatedAt.hashCode());
		result = prime * result + courseId;
		result = prime * result + id;
		result = prime * result + status;
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (CreatedAt == null) {
			if (other.CreatedAt != null)
				return false;
		} else if (!CreatedAt.equals(other.CreatedAt))
			return false;
		if (UpdatedAt == null) {
			if (other.UpdatedAt != null)
				return false;
		} else if (!UpdatedAt.equals(other.UpdatedAt))
			return false;
		if (courseId != other.courseId)
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", status="
				+ status + ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + "]";
	}
}
