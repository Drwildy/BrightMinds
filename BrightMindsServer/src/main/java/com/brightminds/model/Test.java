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

@Table(name="Test")
public class Test {
	
	@Id
	@GeneratedValue(generator="test_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="test_id_seq", allocationSize=1)
	@Column
	private int id;	
	@ManyToOne
	private Course courseId;
	@Column
	private String Question;
	@Column
	private String firstPossibleAnswer;
	@Column
	private String secundPossibleAnswer;
	@Column
	private String thirdPossibleAnswer;
	@Column
	private String rightAnswer;
	@Column
	private int status;
	@Column
	private Date createdAt;
	@Column
	private Date updatedAt;
	
	//Student Lesson JT
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "student_test", 
		joinColumns= {@JoinColumn(name="student_id", referencedColumnName="id")},
		inverseJoinColumns= {@JoinColumn(name="test_id", referencedColumnName="id")})
		private Set<Student> student;

	public Test() {
		super();
	}

	public Test(int id, Course courseId, String question, String firstPossibleAnswer, String secundPossibleAnswer,
			String thirdPossibleAnswer, String rightAnswer, int status, Date createdAt, Date updatedAt,
			Set<Student> student) {
		super();
		this.id = id;
		this.courseId = courseId;
		Question = question;
		this.firstPossibleAnswer = firstPossibleAnswer;
		this.secundPossibleAnswer = secundPossibleAnswer;
		this.thirdPossibleAnswer = thirdPossibleAnswer;
		this.rightAnswer = rightAnswer;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getFirstPossibleAnswer() {
		return firstPossibleAnswer;
	}

	public void setFirstPossibleAnswer(String firstPossibleAnswer) {
		this.firstPossibleAnswer = firstPossibleAnswer;
	}

	public String getSecundPossibleAnswer() {
		return secundPossibleAnswer;
	}

	public void setSecundPossibleAnswer(String secundPossibleAnswer) {
		this.secundPossibleAnswer = secundPossibleAnswer;
	}

	public String getThirdPossibleAnswer() {
		return thirdPossibleAnswer;
	}

	public void setThirdPossibleAnswer(String thirdPossibleAnswer) {
		this.thirdPossibleAnswer = thirdPossibleAnswer;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Question == null) ? 0 : Question.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((firstPossibleAnswer == null) ? 0 : firstPossibleAnswer.hashCode());
		result = prime * result + id;
		result = prime * result + ((rightAnswer == null) ? 0 : rightAnswer.hashCode());
		result = prime * result + ((secundPossibleAnswer == null) ? 0 : secundPossibleAnswer.hashCode());
		result = prime * result + status;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + ((thirdPossibleAnswer == null) ? 0 : thirdPossibleAnswer.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Test other = (Test) obj;
		if (Question == null) {
			if (other.Question != null)
				return false;
		} else if (!Question.equals(other.Question))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (firstPossibleAnswer == null) {
			if (other.firstPossibleAnswer != null)
				return false;
		} else if (!firstPossibleAnswer.equals(other.firstPossibleAnswer))
			return false;
		if (id != other.id)
			return false;
		if (rightAnswer == null) {
			if (other.rightAnswer != null)
				return false;
		} else if (!rightAnswer.equals(other.rightAnswer))
			return false;
		if (secundPossibleAnswer == null) {
			if (other.secundPossibleAnswer != null)
				return false;
		} else if (!secundPossibleAnswer.equals(other.secundPossibleAnswer))
			return false;
		if (status != other.status)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (thirdPossibleAnswer == null) {
			if (other.thirdPossibleAnswer != null)
				return false;
		} else if (!thirdPossibleAnswer.equals(other.thirdPossibleAnswer))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", courseId=" + courseId + ", Question=" + Question + ", firstPossibleAnswer="
				+ firstPossibleAnswer + ", secundPossibleAnswer=" + secundPossibleAnswer + ", thirdPossibleAnswer="
				+ thirdPossibleAnswer + ", rightAnswer=" + rightAnswer + ", status=" + status + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", student=" + student + "]";
	}

}
