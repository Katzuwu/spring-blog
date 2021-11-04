package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
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

	private final PostRepository postRepository;

	public PostController(PostRepository postRepository){
		this.postRepository = postRepository;
	}


	@GetMapping("/posts")
	public String showAllPosts(Model model){
		model.addAttribute("allPosts", postRepository.findAll());
		return "/posts/index";
	}

	@GetMapping("/posts/{id}")
	public String returnPostWithID(Model model){
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

	@GetMapping("/posts/delete/{id}")
	@ResponseBody
	public String postDeletion(@PathVariable long id){
		postRepository.deleteById(id);
		return "Deleted post with that id!";
	}

	@GetMapping("/posts/edit/{id}")
	@ResponseBody
	public String postEditing(@PathVariable long id){
		String title = "Selling my PS4";
		String body = "Old PS4, want to sell to make some cash. $200";
		postRepository.updateTitleAndBody(title, body, id);
		return "Edited post with that id!";
	}
}
