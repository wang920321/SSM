package sys.qx.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sys.qx.model.User;
import sys.qx.model.UserInfo;
import sys.qx.model.UserRole;
import sys.qx.service.UserInfoService;
import sys.qx.service.UserRoleService;
import sys.qx.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml","classpath:spring/spring-mybatis.xml"})
public class UserRoleTest {
	private static final Logger logger = Logger.getLogger(UserRoleTest.class);
	
	@Autowired
	public UserRoleService userRoleService;
	
	@Autowired
	public UserInfoService userInfoService;
	@Test
	public void testGetUserRoleByUserId(){
		List<UserRole> userRole = userRoleService.getUserRoleByUserId("1");
		System.out.println(userRole.get(0));
	}
}
