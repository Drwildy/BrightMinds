package com.brightminds.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(generator = "course_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_id_seq", allocationSize = 1)
	@Column
	private int id;
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructorId;
	@Column
	private int hours;
	@Column
	private double price;
	// add title here
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private int status; // 0- to be deleted 1- created 9 - cancel
	@Column
	private Date CreatedAt;
	@Column
	private Date UpdatedAt;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", 
	joinColumns= {@JoinColumn(name="student_id", referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="course_id", referencedColumnName="id")})
	private Set<Student> student;


	public Course() {
		super();
	}

	public Course(int id, Instructor instructorId, int hours, double price, String title, String description,
			int status, Date createdAt, Date updatedAt, Set<Student> student) {
		super();
		this.id = id;
		this.instructorId = instructorId;
		this.hours = hours;
		this.price = price;
		this.title = title;
		this.description = description;
		this.status = status;
		CreatedAt = createdAt;
		UpdatedAt = updatedAt;
//		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Instructor getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Instructor instructorId) {
		this.instructorId = instructorId;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

//	public Set<Student> getStudent() {
//		return student;
//	}
//
//	public void setStudent(Set<Student> student) {
//		this.student = student;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CreatedAt == null) ? 0 : CreatedAt.hashCode());
		result = prime * result + ((UpdatedAt == null) ? 0 : UpdatedAt.hashCode());

		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + hours;
		result = prime * result + id;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + status;
//		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Course other = (Course) obj;
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

		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (hours != other.hours)
			return false;
		if (id != other.id)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status != other.status)
			return false;
//		if (student == null) {
//			if (other.student != null)
//				return false;
//		} else if (!student.equals(other.student))
//			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", instructorId=" + instructorId + ", hours=" + hours + ", price=" + price
				+ ", title=" + title + ", description=" + description + ", status=" + status + ", CreatedAt="
				+ CreatedAt + ", UpdatedAt=" + UpdatedAt + ", "
//						+ "student=" + student + "]"
				+ "";
	}

}
