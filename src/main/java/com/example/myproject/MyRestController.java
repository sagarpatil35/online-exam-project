package com.example.myproject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.questions;

@RestController
public class MyRestController {
	
	@Autowired
	SessionFactory factory;

	@RequestMapping("getRemainingTime")
	public int getRemainingTime(HttpServletRequest request)
	{
		HttpSession httpsession=request.getSession();
		httpsession.setAttribute("timeremaining",(Integer)httpsession.getAttribute("timeremaining")-1);
		System.out.println(" remaining time is " + httpsession.getAttribute("timeremaining"));
		return (int) httpsession.getAttribute("timeremaining");
	}
	
	@RequestMapping("getAllSubjects")
	public Set<String> getAllSubjects(){
		Session session= factory.openSession();
		Criteria criteria = session.createCriteria(questions.class);
		criteria.setProjection(Projections.property("subject"));
		
		List<String> list=criteria.list();
		HashSet<String> set=new HashSet<String>();
		set.addAll(list);
		return set;
	}
}
