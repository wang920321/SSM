package sys.qx.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sys.qx.model.User;
import sys.qx.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml","classpath:spring/spring-mybatis.xml"})
public class UserTest {
	private static final Logger logger = Logger.getLogger(UserTest.class);
	
	@Autowired
	UserService userService;
	
	@Test
	public void testUser(){
		User user = userService.getUser("1");
		
	}
}
