package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

	private final PostRepository postDao;
	private final UserRepository userDao;

	public PostController(PostRepository postDao, UserRepository userDao){
		this.postDao = postDao;
		this.userDao = userDao;
	}

	@GetMapping("/posts")
	public String showAllPosts(Model model){
		model.addAttribute("allPosts", postDao.findAll());
		return "/posts/index";
	}

	@GetMapping("/posts/show/{id}")
	public String returnPostWithID(@PathVariable long id, Model model){
		Post post = postDao.getById(id);
		User user = post.getUser();

		model.addAttribute("title", post.getTitle());
		model.addAttribute("body", post.getBody());
		model.addAttribute("email", user.getEmail());
		return "/posts/show";
	}

	@GetMapping("/posts/create")
	public String showPostCreateForm(){
		return "/posts/create";
	}

	@PostMapping("/posts/create")
	public String postCreation(@RequestParam String title, @RequestParam String body){
		User user1 = userDao.getById(1L);
		Post post = new Post(title, body, user1);

		postDao.save(post);
		return "redirect:/posts";
	}


	@PostMapping("/posts/delete")
	public String deletePost(@RequestParam(name = "id") long id) {

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
