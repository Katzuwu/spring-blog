package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RollDiceController {

	@GetMapping("/roll-dice")
	public String rollDice(){
		return "/roll-dice";
	}

	@GetMapping("/roll-dice/{n}")
	@ResponseBody
	public String checkForCorrectNumber(@PathVariable int n){
		int random = (int)(Math.random() * 6);

		if(n == random){
			return "You guessed the right number!";
		} else {
			return "That was incorrect, try again.";
		}
	}
}
