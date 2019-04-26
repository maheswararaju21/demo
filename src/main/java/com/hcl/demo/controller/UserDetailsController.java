package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.UserDetails;
import com.hcl.demo.service.UserDetailsService;

@RestController
@RequestMapping(value = "/userdetailscontroller")
public class UserDetailsController {
	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping(value = "/allusersdetails")
	public List<UserDetails> getAllUsersDetails() {
		return userDetailsService.getAllUsersDetails();
	}
	@GetMapping(value = "/allorderdusersdetailsfirstnames")
	public List<UserDetails> getAllOrderdUsersDetails(String firstName) {
		return userDetailsService.findByFirstnameContainsOrderByFirstnameDesc(firstName);
	}
	
	@GetMapping(value = "/allorderdusersdetailsmobilenumbers")
	public List<UserDetails> findByMobilenumberContainsOrderByMobilenumberDesc(Long mobilenumber) {
		return userDetailsService.findByMobilenumberContainsOrderByMobilenumberDesc(mobilenumber);
	}
	
	@GetMapping(value = "/allorderdusersdetailslaststnames")
	public List<?> fetchbylastname(String lastname) {
		return userDetailsService.fetchbylastname(lastname);
	}
	@GetMapping(value = "/alluserdetailsnativequery")
	public List<?> getUserDetailsNativeQuery()
	{
		return userDetailsService.getUserDetailsNativeQuery();
	}
	@GetMapping(value = "/alluserdetailsbypageble")
	public List<UserDetails> getAllbypageble() {
		return userDetailsService.getAllbypageble();
	}
	@PostMapping(value = "/insertusersdetails")
	public ResponseEntity<UserDetails> insertUsersDetails(@RequestBody UserDetails userdetails) {
		userDetailsService.insertUserDetails(userdetails);
		return new ResponseEntity<UserDetails>(HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateusersdetails/{id}")
	public ResponseEntity<UserDetails> updateUserDetails(@PathVariable("id") long id,
			@RequestBody UserDetails userdetails) {
		userDetailsService.updateDetails(userdetails, id);
		return new ResponseEntity<UserDetails>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteusersdetails/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UserDetails> deleteUsers(@PathVariable Long id) {
		userDetailsService.deleteUserDetails(id);
		return new ResponseEntity<UserDetails>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteallusersdetails")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAllUsers(UserDetails userdetails) {
		userDetailsService.deleteAllUsersDetails(userdetails);

	}
	
	 public static int findMax(int arr[]){  
	        int max=arr[0];//arr[0] instead of 0  
	        for(int i=1;i<arr.length;i++){  
	            if(max<arr[i])  
	                max=arr[i];  
	        }  
	        return max;  
	    }  
	
	  /*public static int findMax(int arr[]){  
	        int max=0;  
	        for(int i=1;i<arr.length;i++){  
	            if(max<arr[i])  
	                max=arr[i];  
	        }  
	        return max;  
	    }            
*/	
}
