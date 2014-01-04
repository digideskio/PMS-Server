package com.media2359.euphoria.service.allocation;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.view.server.allocation.ApproveManpowerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApproveManpowerServiceTest {
	
	@Autowired
	ApproveManpowerService approveManpowerService;
	
	@Test
	public void test2ApproveWeeklyRequest(){
		
	}
	
	@Test
	
	public void test1GetWeeklyManpowerRequest(){
		
	}
	

}
