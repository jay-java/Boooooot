package com.jsp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.model.User;
import com.jsp.repo.UserRepo;
import com.jsp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private final UserRepo userRepo;

	@Autowired
	private UserService service;

	UserController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@RequestMapping("/")
	@ResponseBody
	public String msg() {
		return "hello user";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/home")
	public String alluseres(Model m) {
		List<User> list = this.service.getAllUsers();
		m.addAttribute("list", list);
		return "home";
	}

	@RequestMapping("/adduser")
	public String addUser(@ModelAttribute User u, Model m) {
		this.service.addNewUser(u);
		List<User> list = this.service.getAllUsers();
		m.addAttribute("list", list);
		return "home";
	}

	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam("id") int id) {
		System.out.println("edit called : " + id);
		Optional<User> u = this.service.findUserById(id);
		System.out.println(u);
		ModelAndView m = new ModelAndView();
		if (u.isPresent()) {
			m.addObject("u", u.get());
			m.setViewName("update");
			return m;
		} else {
			return null;
		}

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id") int id, Model m) {
		this.service.deleteUser(id);
		List<User> list = this.service.getAllUsers();
		m.addAttribute("list", list);
		return "home";
	}

}
