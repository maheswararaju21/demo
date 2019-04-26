package com.hcl.demo.service;

import java.util.List;

import com.hcl.demo.entity.UserDetails;

public interface UserDetailsService {
	public List<UserDetails> getAllUsersDetails();

	UserDetails insertUserDetails(UserDetails userdetails);

	void updateDetails(UserDetails userdetails, Long userdetailsId);

	void deleteUserDetails(Long userdetailsId);

	void deleteAllUsersDetails(UserDetails userdetails);

	public List<?> fetchbylastname(String lastname);

	public List<?> getUserDetailsNativeQuery();

	public List<UserDetails> getAllbypageble();

	public List<UserDetails> findByFirstnameContainsOrderByFirstnameDesc(
			String firstname);

	public List<UserDetails> findByMobilenumberContainsOrderByMobilenumberDesc(
			Long mobilenumber);
}
