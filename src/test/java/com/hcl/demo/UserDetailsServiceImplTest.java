package com.hcl.demo;

import java.util.Optional;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.demo.entity.UserDetails;
import com.hcl.demo.repository.UserDetailsRepository;
import com.hcl.demo.service.UserDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {
	@Mock
	UserDetailsRepository userDetailsRepository;
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;

	static UserDetails userDetails = null;
	static Optional<UserDetails> user1 = Optional.empty();

	@BeforeClass
	public static void setUp() {
		userDetails = new UserDetails();
		userDetails.setId(2L);
		userDetails.setFirstname("test");
		userDetails.setFirstname("satvik");
		userDetails.setLastname("mm");
		userDetails.setEmailid("satvik@hcl.com");
		userDetails.setMobilenumber(93214567L);
		user1 = Optional.of(userDetails);
	}

	/*
	 * @Ignore
	 * 
	 * @Test public void testIsPrimeForPositiveNum(){ boolean isPrime =
	 * userServiceImpl.isPrime(13); Assert.assertEquals(true, isPrime); }
	 */

	/*
	 * @BeforeClass public static void setUpAllUserDetails() { userDetails = new
	 * UserDetails(); userDetails.setId(1L); userDetails.setFirstname("satvik");
	 * userDetails.setLastname("mm"); userDetails.setEmailid("satvik@hcl.com");
	 * userDetails.setMobilenumber(93214567L); user1 = Optional.of(userDetails);
	 * }
	 */
	@Test
	public void testGetById() {
		Mockito.when(userDetailsRepository.findById(1L)).thenReturn(user1);
		String result = userDetailsServiceImpl.getById(1L);
		Assert.assertEquals("Even", result);
	}
	/*@Test
	public void testtwoGetById() {
		Mockito.when(userDetailsRepository.findById(2L)).thenReturn(user1);
		String result = userDetailsServiceImpl.getById(2L);
		Assert.assertEquals("odd", result);
	}*/
	/*@Test
	public void getAllUsersDetails() {
		Mockito.when(userDetailsServiceImpl.getAllUsersDetails());
	}*/
}

/*
 * @Mock UserDetailsRepository userDetailsRepository;
 * 
 * @InjectMocks UserDetailsServiceImpl userDetailsServiceImpl; static
 * UserDetails userDetails = null; static Optional<User> user1 =
 * Optional.empty();
 */