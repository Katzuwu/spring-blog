package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

	private final PostRepository postDao;

	public PostController(PostRepository postDao){
		this.postDao = postDao;
	}

	@GetMapping("/posts")
	public String showAllPosts(Model model){
		model.addAttribute("allPosts", postDao.findAll());
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


	@PostMapping("/posts/delete")
	public String deletePost(@PathVariable @RequestParam(name = "id") long id) {

		Post post = postDao.getById(id);
		postDao.delete(post);
		return "redirect:/posts";
	}

	@GetMapping("/posts/{id}/edit")
	public String returnEditView(@PathVariable long id, Model viewModel){
		viewModel.addAttribute("post", postDao.getById(id));
		return "/posts/edit";
	}

	@PostMapping("/posts/{id}/edit")
	public String updatePost(@RequestParam String title, @RequestParam String body, @PathVariable long id){
		postDao.updateTitleAndBody(title, body, id);
		return "redirect:/posts";
	}
}
