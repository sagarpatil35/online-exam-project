package com.example.myproject;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.entity.questions;
import com.example.entity.users;
import com.example.entity.Answer;

@Controller
public class Home {

	@Autowired
	SessionFactory factory;

	@RequestMapping("/")
	String login() {
		return "login";
	}

	@RequestMapping("register")
	String register() {
		return "register";
	}

	@RequestMapping("registerdata")
	ModelAndView registerdata(users users) {
		Session session = factory.openSession();
		Transaction tt = session.beginTransaction();
		session.save(users);
		tt.commit();
		ModelAndView andView = new ModelAndView();
		andView.setViewName("login");
		andView.addObject("Message", "register successful");
		return andView;
	}

	@RequestMapping("selectsub")
	ModelAndView welcome(users users,HttpServletRequest request) {
		ModelAndView andView = new ModelAndView();
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("session_username","welcome " + users.getUsername());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		users users2 = session.load(users.class, users.getUsername());

		if(users.getUsername().equals("admin")&&users.getPassword().equals("a")) {
			andView.setViewName("questionsmanagement");
			
		} else if(users2.getUsername().equals(users.getUsername()) && users2.getPassword().equals(users.getPassword())) {
			andView.setViewName("selectsub");
			andView.addObject("Message","best luck");
			
		} else {
			andView.setViewName("login");
			andView.addObject("Message","wrong password");
		}
		transaction.commit();
		return andView;
	}

	@RequestMapping("startexam")
	ModelAndView startexam(String selectsub, HttpServletRequest request) {
		ModelAndView andView = new ModelAndView();
		
		HttpSession httpSession=request.getSession();
		httpSession.getAttribute("session_username");
		httpSession.setAttribute("session_sub",selectsub);
		httpSession.setAttribute("Session_questions_num",0);
		httpSession.setAttribute("session_score",0);
		httpSession.setAttribute("timeremaining",150);									// time is sec
		HashMap<Integer,Answer> hashMap = new HashMap<>();
		httpSession.setAttribute("session_submitted_details",hashMap);
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(questions.class);
		criteria.add(Restrictions.eq("subject",selectsub));
//		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
//		criteria.setMaxResults(5);
		List questions_list = criteria.list();
		
//		Query query = session.createQuery("from Questions where subject=:subject");
//		query.setParameter("subject",selectsub);
//		List questions_list = query.list();
		
		httpSession.setAttribute("session_questions_list",questions_list);								//
		andView.setViewName("question");
		andView.addObject("questions", questions_list.get(0));
		transaction.commit();
		return andView;
	}
	
	@RequestMapping("saveresponse")
	void saveresponse(Answer answer,HttpSession httpSession) {
		List<questions> list=(List<questions>) httpSession.getAttribute("session_questions_list");
		
		for (questions questions : list) {
			if(questions.getQno()==answer.getQno()) {
				String ans=questions.getAnswer();
				answer.setAnswer(ans);
				break;
			}
		}
		HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpSession.getAttribute("session_submitted_details");
		hashMap.put(answer.getQno(), answer);
		System.out.println(hashMap);
		httpSession.setAttribute("session_submitted_details",hashMap);
	}
}
