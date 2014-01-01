package com.media2359.euphoria.service.allocation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.view.server.allocation.ModifyAllocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
public class ModifyAllocationServiceTest {
	
	@Autowired
	ModifyAllocationService modifyAllocService ;
	
	@Test
	public void testGetWeeklyManpowerAllocation(){
		
	}
	
	@Test
	public void testUpdateWeeklyManpowerAllocation(){
		
	}
	
	

}
