package com.hcl.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.demo.entity.UserDetails;
import com.hcl.demo.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDetailsRepository udetailsrepo;

	@Override
	public List<UserDetails> getAllUsersDetails() {
		return udetailsrepo.findAll();
	}

	@Override
	public UserDetails insertUserDetails(UserDetails userdetails) {
		return udetailsrepo.save(userdetails);
	}

	@Override
	public void updateDetails(UserDetails userdetails, Long userdetailsId) {
		udetailsrepo.findById(userdetailsId);
		userdetails.setId(userdetailsId);
		udetailsrepo.save(userdetails);
	}

	@Override
	public void deleteUserDetails(Long userdetailsId) {
		UserDetails userid = udetailsrepo.getOne(userdetailsId);
		udetailsrepo.delete(userid);
	}

	@Override
	public void deleteAllUsersDetails(UserDetails userdetails) {
		udetailsrepo.deleteAll();
	}

	@Override
	public List<UserDetails> findByFirstnameContainsOrderByFirstnameDesc(
			String firstname) {
		return udetailsrepo
				.findByFirstnameContainsOrderByFirstnameDesc(firstname);
	}

	@Override
	public List<UserDetails> findByMobilenumberContainsOrderByMobilenumberDesc(
			Long mobilenumber) {
		return udetailsrepo
				.findByMobilenumberContainsOrderByMobilenumberDesc(mobilenumber);
	}

	@Override
	public List<?> fetchbylastname(String lastname) {
		return udetailsrepo.fetchbylastname(lastname);
	}

	@Override
	public List<?> getUserDetailsNativeQuery() {
		return udetailsrepo.getUserDetailsNativeQuery();
	}

	@Override
	public List<UserDetails> getAllbypageble() {
	       Pageable pageable = PageRequest.of(0, 2, new Sort(Sort.Direction.DESC, "firstname"));
           return udetailsrepo.findAll(pageable).getContent();
	}

	public String getById(Long id){
		Optional<UserDetails> user = udetailsrepo.findById(id);
		
		UserDetails user1 = user.get();
		if(user1.getId() % 2 == 0){
			return "Even";
		}else{
			return "Odd";
		}
	}

}
