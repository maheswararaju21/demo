package com.hcl.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.demo.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
   
	public List<UserDetails> findByFirstnameContainsOrderByFirstnameDesc(String firstname);
	
	public List<UserDetails> findByMobilenumberContainsOrderByMobilenumberDesc(Long mobilenumber);
	
	 @Query("select u.lastname, count(u) from UserDetails u group by u.lastname")
     List<?> fetchbylastname(String firstname);
	 
	 @Query(value="select * from user_details", nativeQuery=true)
     List<?> getUserDetailsNativeQuery();
    


}
