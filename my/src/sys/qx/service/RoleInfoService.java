package sys.qx.service;


import java.util.List;

import sys.qx.model.Role;
import sys.qx.model.RoleInfo;

public interface RoleInfoService {
	
	public RoleInfo getRoleInfo(Role role);

	public List<RoleInfo> getRoleInfos(List<Role> roles);
	
}
