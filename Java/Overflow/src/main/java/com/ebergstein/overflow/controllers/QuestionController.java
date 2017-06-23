package com.ebergstein.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.overflow.models.Answer;
import com.ebergstein.overflow.models.Question;
import com.ebergstein.overflow.models.Tag;
import com.ebergstein.overflow.services.AnswerService;
import com.ebergstein.overflow.services.QuestionService;
import com.ebergstein.overflow.services.TagService;

@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;
	
	public QuestionController(QuestionService questionService, AnswerService answerService, TagService tagService){
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/questions")
	public String welcome(Model model){
		model.addAttribute("questions", questionService.findAllQuestions());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question){
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@RequestParam(value = "question") String input, 
			@RequestParam(value = "tags") String tags,
			Model model){
		//System.out.println(input);
		String errors = "";
		System.out.println(tags);
		if(tags.length() == 0){
			errors = errors.concat("You must input at least one tag.  ");
		}
		String[] split = tags.split(",");
		if(split.length > 3){
			errors = errors.concat("Too Many Tags.  ");
		}
		if(input.length() == 0){
			errors = errors.concat("No question inputted.  ");
		}
		System.out.println(errors);
		if(errors.length() > 0){
			//System.out.println("Came in the if check of the errors");
			model.addAttribute("errors", errors);
			return "newQuestion.jsp";
		}
		else{
			Question generated = new Question(input);
			//questionService.addQuestion(generated);
			List<Tag> temptags = new ArrayList<Tag>();
			for(String tag: split){
				System.out.println(tag);
				Tag temp = tagService.findTagBySubject(tag);
				if(temp == null){
					temp = new Tag(tag);
				}
				System.out.println(temp.getSubject());
				temptags.add(temp);
				tagService.addTag(temp);
			}
			generated.setTags(temptags);
			questionService.addQuestion(generated);
			return "redirect:/questions" ;
		}
	}
	
	@RequestMapping("/questions/{id}")
	public String question(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model){
		model.addAttribute("question", questionService.findQuestionById(id));
		return "Question.jsp";
	}
	
	@PostMapping("/questions/{id}")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer,
            BindingResult result, 
            Model model,
            @PathVariable("id") Long id){
		System.out.println("Hi");
		Question question = questionService.findQuestionById(id);
		if (result.hasErrors()) {
			model.addAttribute("question", question);
			return "Question.jsp";
		}else{
			System.out.println("CAME TO THE ELSE");
			//question.getAnswers().add(answer);
			answer.setQuestion(question);
			answerService.addAnswer(answer);
			questionService.addQuestion(question);
			return "redirect:/questions/" + question.getId();
		}
	}

}
