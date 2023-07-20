package com.example.myproject;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Answer;
import com.example.entity.questions;

@Controller
public class next_previous_endexam {

	@RequestMapping("next")
	ModelAndView next(HttpSession httpSession) {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("question");
		
		int i = (int) httpSession.getAttribute("Session_questions_num");
		int next_questions = i+1;
		List<questions> q_list = (List<questions>) httpSession.getAttribute("session_questions_list");
		
		if (next_questions < q_list.size()) {
			questions questions = q_list.get(next_questions);
			andView.addObject("questions", questions);
			httpSession.setAttribute("Session_questions_num", next_questions);
			
			HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpSession.getAttribute("session_submitted_details");
			Answer answer =hashMap.get(questions.getQno());
			
			if(answer!=null) {
				String next_q_submitted_ans=answer.getSubmittedAnswer();
				andView.addObject("ans", next_q_submitted_ans);
			}
		} else {
			int ii = (int) httpSession.getAttribute("Session_questions_num");
			andView.addObject("questions",q_list.get(ii));
			andView.addObject("Message", "click previous b");
		}
		return andView;
	}

	@RequestMapping("previous")
	ModelAndView previous(HttpSession httpSession) {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("question");
		
		List<questions> q_list =(List<questions>) httpSession.getAttribute("session_questions_list");
		int i = (int) httpSession.getAttribute("Session_questions_num");
		int previous_questions_no = i-1;
		
		if(previous_questions_no>=0) {
			questions questions = q_list.get(previous_questions_no);
			andView.addObject("questions",questions);
			httpSession.setAttribute("Session_questions_num",previous_questions_no);
			
			HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpSession.getAttribute("session_submitted_details");
			Answer answer =hashMap.get(questions.getQno());
			if(answer!=null) {
				String previous_q_submitted_ans=answer.getSubmittedAnswer();
				andView.addObject("ans", previous_q_submitted_ans);
			}
		}else {
			int ii = (int) httpSession.getAttribute("Session_questions_num");
			andView.addObject("questions",q_list.get(ii));
			andView.addObject("Message","click next b");
		}
		return andView;
	}

	@RequestMapping("endexam")
	ModelAndView endexam(HttpSession httpSession) {
		ModelAndView andView = new ModelAndView();
		httpSession.getAttribute("session_username");
		httpSession.getAttribute("session_sub");
		httpSession.getAttribute("session_submitted_details");
		
		HashMap<Integer,Answer> hashMap=(HashMap<Integer, Answer>) httpSession.getAttribute("session_submitted_details");
		System.out.println("***1***:- "+hashMap);
		Collection<Answer> allanswers= hashMap.values();
		System.out.println("***2***:- "+hashMap);
		
		for(Answer answer: allanswers) {
			if(answer.getSubmittedAnswer().equals(answer.getAnswer())) {
				int i= (int) httpSession.getAttribute("session_score");
				httpSession.setAttribute("session_score",i+1);
				int marks =(int) httpSession.getAttribute("session_score");
				andView.addObject("marks",marks);
			}
		}
		httpSession.invalidate();
		andView.setViewName("score");
		andView.addObject("allAnswers", allanswers);
		return andView;
	}
}

/*
 * session_questions_list = all seleted Q list
 * Session_questions_num = 0
 * session_username = username
 * session_sub = slected sub name
 * session_score = score
 * session_submitted_details = orijan ans submitted ans save
 * timeremaining = time
 * 
 * 
 */