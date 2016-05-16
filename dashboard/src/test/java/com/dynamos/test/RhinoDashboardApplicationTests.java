package com.dynamos.test;

import com.dynamos.DynamosApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DynamosApplication.class)
@WebAppConfiguration
public class RhinoDashboardApplicationTests {

	@Test
	public void contextLoads() {
	}

}
