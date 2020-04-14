package com.waleed.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();
	}
	
	@RequestMapping("/users/name/{name}")
	String getUserName(@PathVariable String name) {
		return service.getUserName(name);
	}
	
	@RequestMapping(method = RequestMethod.POST,value="users/create")
	String createUser(@RequestBody User user) {
		int res=service.createUser(user);
		if(res==1) {
			return "User created successfully with the account id:"+user.getUserId();
		}
		return "User not Created";
	}
	
	@RequestMapping("/users/userid/{id}")
	User getUser(@PathVariable String id) {
		return service.getUser(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value= "/users/update/{userId}")
	String updateUser(@PathVariable String userId,@RequestBody User user) {
			if(service.updateUser(userId, user)==1) {
				return "Account updated";
			}
			return "Account not updated";
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/users/delete/{userId}")
	String deleteUser(@PathVariable String userId) {
		if(service.deleteUser(userId)==1) {
			return "Successfully deleted userId: "+userId;
		}
		return "Not able to delete";
	}
	
	@RequestMapping("/users")
	List<User> listOfUsers(){
		return service.listOfUsers();
	}
}
