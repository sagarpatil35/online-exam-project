package com.example.myproject;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.entity.questions;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

@Controller
public class QuestionManagement {
	
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("addQuestion")
	ModelAndView addQuestion(questions questions) {
		ModelAndView andView = new ModelAndView();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(questions);
		transaction.commit();
		andView.addObject("message","add su");
		andView.setViewName("questionsmanagement");
		return andView;
	}
	
	@RequestMapping("viewQuestion")
	ModelAndView viewQuestion(int qno,String subject) {
		System.out.println(qno+" && "+subject);
		ModelAndView andView = new ModelAndView();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(questions.class);
		
		criteria.add(Restrictions.and(Restrictions.eq("subject",subject), Restrictions.eq("qno",qno)));
		
		List<questions> list = criteria.list();
		questions questions = list.get(0);
		System.out.println(questions);
		transaction.commit();
		andView.addObject("questions",questions);
		andView.setViewName("questionsmanagement");
		return andView;
	}

	@RequestMapping("updateQuestion")
	ModelAndView updateQuestion(int qno,String subject,questions questions) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria Criteria = session.createCriteria(questions.class);
		Criteria criteria2 = Criteria.add(Restrictions.eq("subject",subject));
		List<questions> list = criteria2.list();
		questions questions1 = list.get(questions.getQno()-1);
		System.out.println("xyz:- "+questions1);
		
		questions1.setQno(questions.getQno());
		questions1.setQuestion(questions.getQuestion());
		questions1.setOption1(questions.getOption1());
		questions1.setOption2(questions.getOption2());
		questions1.setOption3(questions.getOption3());
		questions1.setOption4(questions.getOption4());
		questions1.setAnswer(questions.getAnswer());
		questions1.setSubject(questions.getSubject());
		System.out.println("updated data:- "+questions1);
		session.saveOrUpdate(questions1);
		
		transaction.commit();
		ModelAndView andView = new ModelAndView();
		andView.addObject("questions",questions);
		andView.addObject("message","update Qus");
		andView.setViewName("questionsmanagement");
		return andView;
	}
	
	@RequestMapping("deleteQuestion")
	ModelAndView deleteQuestion(int qno,String subject,questions questions) {
		ModelAndView andView = new ModelAndView();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria Criteria = session.createCriteria(questions.class);
		Criteria criteria2 = Criteria.add(Restrictions.eq("subject",subject));
		List<questions> list = criteria2.list();
		questions questions1 = list.get(qno-1);
		System.out.println("Delete Data:- "+questions1);
		session.delete(questions1);
		
		transaction.commit();
		andView.addObject("questions",questions);
		andView.addObject("message","Delete Qus");
		andView.setViewName("questionsmanagement");
		return andView;
	}
	
}
