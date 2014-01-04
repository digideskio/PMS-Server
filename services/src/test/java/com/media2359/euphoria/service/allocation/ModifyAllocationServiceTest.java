package com.media2359.euphoria.service.allocation;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.view.server.allocation.ModifyAllocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-services-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModifyAllocationServiceTest {
	
	@Autowired
	ModifyAllocationService modifyAllocService ;
	
	@Test
	public void test1GetWeeklyManpowerAllocation(){
		
	}
	
	@Test
	public void test2UpdateWeeklyManpowerAllocation(){
		
	}
	
	

}
