package com.hcl.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hcl.demo.controller.UserDetailsController;

public class UserDetailsControllerTest {
@Test
public void testFindMax(){  
    assertEquals(4,UserDetailsController.findMax(new int[]{1,3,4,2}));  
    assertEquals(-1,UserDetailsController.findMax(new int[]{-12,-1,-3,-4,-2})); 
}
}