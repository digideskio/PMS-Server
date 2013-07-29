package com.media2359.euphoria.service.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.media2359.euphoria.dao.demo.EchoDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-model-test.xml"})
public class EchoDaoTest {
	@Autowired
	private EchoDao echoDao;
	
	@Test
	public void testGetMessage() {
		String result = echoDao.getMessage("John");
		Assert.assertNotNull(result);
		Assert.assertEquals("Hello John", result);
	}
}
