package com.example.railway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@Controller
public class RailwayReservationSystemApplication {
	
	@Value("${railway.admin}")
	private String admin;
	
	@Value("${railway.admin.password}")
	private String pword;
	
	@GetMapping("/")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu.html";
	}
	
	@GetMapping("/booking")
	public String booking() {
		return "boook.html";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "cancel.html";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list.html";
	}
	
	@GetMapping("/failure")
	public String failure(){
		return "failure.html";
	}
	
	@GetMapping("/added")
	public String added() {
		return "added.html";
	}
	
	@PostMapping("/")
	public String verify(@RequestParam String username, @RequestParam String password) {
		if (username.equals(admin) && password.equals(pword)) {
			return "redirect:/menu";
		}
		return "redirect:/failure";
	}
	
	@PostMapping("/booking")
	public String additionSuccess(@RequestParam String train_name, @RequestParam String from) {
		return "redirect:/added";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RailwayReservationSystemApplication.class, args);
	}

}
