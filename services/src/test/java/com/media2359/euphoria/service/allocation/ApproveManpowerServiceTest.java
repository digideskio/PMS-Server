package com.media2359.euphoria.service.allocation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.view.server.allocation.ApproveManpowerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
public class ApproveManpowerServiceTest {
	
	@Autowired
	ApproveManpowerService approveManpowerService;
	
	@Test
	public void testApproveWeeklyRequest(){
		
	}
	
	@Test
	
	public void testGetWeeklyManpowerRequest(){
		
	}
	

}
