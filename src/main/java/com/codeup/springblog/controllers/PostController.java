package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
	@GetMapping("/posts")
	public String returnPosts(){
		return "/posts/index";
	}

	@GetMapping("/posts/all")
	public String showAllPosts(Model model){
		List<Post> allPosts = new ArrayList<>();
		Post post1 = new Post("Selling my dad", "Dad made me angry so I'm selling him for $1.");
		Post post2 = new Post("Selling my sons Nintendo Switch", "He did not get all A's so I'm selling his switch. $100");
		allPosts.add(post1);
		allPosts.add(post2);
		model.addAttribute("allPosts", allPosts);
		return "/posts/index";
	}

	@GetMapping("/posts/{id}")
	public String returnPostWithID(@PathVariable long id, Model model){
		Post post = new Post("Want to buy RTX 3080", "Please it's been a year I just want one already");
		model.addAttribute("title", post.getTitle());
		model.addAttribute("body", post.getBody());
		return "/posts/show";
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
