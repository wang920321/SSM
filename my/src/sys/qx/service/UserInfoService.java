package sys.qx.service;

import java.util.List;

import sys.qx.model.User;
import sys.qx.model.UserInfo;

public interface UserInfoService {
	
	public UserInfo getUserInfo(User user);

	public List<UserInfo> getUserInfos(List<User> users);
	
}
