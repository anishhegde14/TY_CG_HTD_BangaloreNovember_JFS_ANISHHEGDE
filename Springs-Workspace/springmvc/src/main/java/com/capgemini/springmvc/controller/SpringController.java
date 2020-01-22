package com.capgemini.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.springmvc.beans.User;

@Controller
public class SpringController {
	@Autowired
	private ServletContext context;
	
	User u=new User();
	@RequestMapping("/hello")
	public String hello(ModelMap map) {


		map.addAttribute("msg", "Hello World!!!!!!!!!!");
		return "index";
	}
	//@RequestMapping(path="/query",method = RequestMethod.GET)
	@GetMapping("/query")
	public String query(@RequestParam(name="name",required=false)String name,@RequestParam(name="age",required=false)Integer age,
			ModelMap map)
	{


		map.addAttribute("name",name);
		map.addAttribute("age", age);

		return "query";
	}

	@GetMapping("/form")
	public String form() {

		return "form";
	}
	@PostMapping("/form")
	public String form(User user,ModelMap map)
	{
		map.addAttribute("name",u.getName());
		map.addAttribute("email",u.getEmail());
		map.addAttribute("password",u.getPassword());
		map.addAttribute("gender", u.getGender());

		return "form";
	}
	@GetMapping("/createcookie")
	public String createCookie(HttpServletResponse resp) {
		Cookie cookie=new Cookie("name", "Anish");
		resp.addCookie(cookie);
		return "createcookie";
	}
	@GetMapping("/getcookie")
	public String getCookie(@CookieValue(name="name", required=false)String name,ModelMap map)/*In Servlet and Jsp (HttpServletRequest req) */
	{
		if(name!=null) {
			map.addAttribute("name",name);}
		else {
			map.addAttribute("name","Anish1");
		}



		/* In Servlets and Jsp
		 * Cookie[] cookie=req.getCookies(); for (Cookie cookie2 : cookie) {
		 * if(cookie2.getName().equals("name")) { String value=cookie2.getValue(); } }
		 */

		return "getcookie";

	}
	@GetMapping("/path/{movie}/{hero}")
	public String path(@PathVariable("movie")String movie,@PathVariable("hero")String hero,ModelMap map)
	{
		/*IF WE HAVE TO GIVE SPACE BETWEEN TWO WORDS THEN TYPE %20 BETWEEN THEM IN THE URL*/
		map.addAttribute("movie",movie);
		map.addAttribute("hero",hero);
		return "pathvalue";
	}

	
	/*With servlet
	 * public String forwardreq(HttpServletRequest req,HttpServletResponse response)
	 * throws ServletException, IOException {
	 * 
	 * req.getRequestDispatcher("/hello").forward(req, response); return
	 * "forwardreq"; }
	 */
	@GetMapping("/forward")
	public String forward()
	{
		return "forward:path";
	}

	/*
	 * public String redirect(HttpServletRequest req,HttpServletResponse resp)
	 * throws IOException
	 * 
	 * { resp.sendRedirect("https:\\www.google.com");
	 * 
	 * return ""; }
	 */
	@GetMapping("/redirect")
	public String redirect()
	{
		return "redirect:https://www.google.com";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@PostMapping("/login")
	public String login(String username,String password,HttpServletRequest req,ModelMap map)
	{
		if(username.equals("Anish") && password.equals("admin"))
		{
			User user=new User();
			user.setEmail("anishhegde14@gmail.com");
			user.setGender("M");
			user.setPassword(password);
			user.setName(username);
			HttpSession session=req.getSession();
			session.setAttribute("user",user);
			map.addAttribute("msg","user logged in");
			
			
			return "home";
		}
		else
		{
			map.addAttribute("msg","Credentials invalid!!!");
			return "login";
		}
	}
	
	/*Another way of creating but less efficient than the first one
	 * @PostMapping("/login") public String login(String username,String
	 * password,ModelMap map,HttpSession session) { if(username.equals("admin") &&
	 * password.equals("admin")) { map.addAttribute("msg","user logged in"); return
	 * "home"; } else { session.invalidate();
	 * map.addAttribute("msg","Credentials invalid!!!"); return "login"; }
	 * 
	 * }
	 */
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="user",required=false)User user)
	{
		if(user!=null)
		{
			return "home";
		}
		else
		{
			return "login";
		}
	}
	@GetMapping("setappattribute")
	public String setAppAttribute()
	{
		context.setAttribute("msg", new Object());
		return "setcontext";
	}
	@GetMapping("getappattribute")
	public String getAppAttribute()
	{
		context.getAttribute("msg");
		return "getcontext";
	}
	}
	

