package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.object.Person;
import com.example.demo.service.FirebaseServices;

@RestController
public class UserController {
	
	@RequestMapping("/hello")
	public String helloSpring(){
		System.out.println("hello");
		return "Hello Spring Boot : Intializer";
	
	}
	@Autowired
	private FirebaseServices firebaseServices;
	
	@GetMapping("/getUserDetails")
	public Person getUserDetails(@RequestHeader String name) throws InterruptedException, ExecutionException {
		return firebaseServices.getUserDetails(name);
	}
	
	@PostMapping("/createUser")
	public String createNewUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return firebaseServices.saveUserDetails(person);
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return firebaseServices.updateUser(person);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestHeader String name) throws InterruptedException, ExecutionException {
		return firebaseServices.deleteUser(name);
	}

}
