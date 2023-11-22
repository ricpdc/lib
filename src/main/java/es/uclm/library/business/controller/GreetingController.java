package es.uclm.library.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.uclm.library.business.entity.Greeting;
import es.uclm.library.persistence.GreetingDAO;

@Controller
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

	@Autowired
	private GreetingDAO greetingDAO;


	Greeting greeting;
	
	public GreetingController() {
		super();
		this.greeting = new Greeting();
	}

	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		greeting = new Greeting();
		model.addAttribute("greeting", greeting);
		log.info(listGreetings());
		return "greeting";
	}

	private String listGreetings() {
		return greetingDAO.findAll().toString();
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		this.greeting=greeting;
		model.addAttribute("greeting", greeting);
		Greeting savedGreeting = greetingDAO.save(greeting);
		log.info("Saved greeting: " + savedGreeting);
		return "result";
	}

	public GreetingDAO getGreetingDAO() {
		return greetingDAO;
	}
	
	public void setGreetingDAO(GreetingDAO greetingDAO) {
		this.greetingDAO = greetingDAO;
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
}