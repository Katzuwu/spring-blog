package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
	@GetMapping("/posts")
	@ResponseBody
	public String returnPosts(){
		return "Here are all the posts";
	}

	@GetMapping("/posts/{id}")
	@ResponseBody
	public String returnPostWithID(@PathVariable long id){
		return "Showing post: " + id;
	}

	@GetMapping("/posts/create")
	@ResponseBody
	public String createNewPost(){
		return "Form for creating post";
	}

	@PostMapping("/posts/create")
	@ResponseBody
	public String postCreation(){
		return "New post created";
	}
}
