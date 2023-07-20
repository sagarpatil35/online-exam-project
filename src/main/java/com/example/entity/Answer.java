package com.example.entity;

public class Answer {

	int qno;
	String question,submittedAnswer,Answer;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int qno, String question, String submittedAnswer, String Answer) {
		super();
		this.qno = qno;
		this.question = question;
		this.submittedAnswer = submittedAnswer;
		this.Answer = Answer;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSubmittedAnswer() {
		return submittedAnswer;
	}

	public void setSubmittedAnswer(String submittedAnswer) {
		this.submittedAnswer = submittedAnswer;
	}
	
	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String Answer) {
		this.Answer = Answer;
	}

	@Override
	public String toString() {
		return "Answer [qno=" + qno + ", question=" + question + ", submittedAnswer=" + submittedAnswer + ", Answer="
				+ Answer + "]";
	}
	
}
