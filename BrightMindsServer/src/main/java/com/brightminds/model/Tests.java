package com.brightminds.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name="Test")
public class Tests {
	
	@Id
	@GeneratedValue(generator="test_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name="test_id_seq", allocationSize=1)
	@Column
	private int testId;	
	@ManyToOne
	private Courses courseId;
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
	
	public Tests() {
		super();
	}

	public Tests(int testId, Courses courseId, String question, String firstPossibleAnswer, String secundPossibleAnswer,
			String thirdPossibleAnswer, String rightAnswer, int status, Date createdAt, Date updatedAt) {
		super();
		this.testId = testId;
		this.courseId = courseId;
		Question = question;
		this.firstPossibleAnswer = firstPossibleAnswer;
		this.secundPossibleAnswer = secundPossibleAnswer;
		this.thirdPossibleAnswer = thirdPossibleAnswer;
		this.rightAnswer = rightAnswer;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Courses getCourseId() {
		return courseId;
	}

	public void setCourseId(Courses courseId) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Question == null) ? 0 : Question.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((firstPossibleAnswer == null) ? 0 : firstPossibleAnswer.hashCode());
		result = prime * result + ((rightAnswer == null) ? 0 : rightAnswer.hashCode());
		result = prime * result + ((secundPossibleAnswer == null) ? 0 : secundPossibleAnswer.hashCode());
		result = prime * result + status;
		result = prime * result + testId;
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
		Tests other = (Tests) obj;
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
		if (testId != other.testId)
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
		return "Tests [testId=" + testId + ", courseId=" + courseId + ", Question=" + Question
				+ ", firstPossibleAnswer=" + firstPossibleAnswer + ", secundPossibleAnswer=" + secundPossibleAnswer
				+ ", thirdPossibleAnswer=" + thirdPossibleAnswer + ", rightAnswer=" + rightAnswer + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
