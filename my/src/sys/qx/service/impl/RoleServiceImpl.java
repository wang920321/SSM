package sys.qx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.qx.dao.RoleMapper;
import sys.qx.model.Role;
import sys.qx.model.RoleExample;
import sys.qx.service.RoleService;
import sys.qx.util.StringUtils;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	private RoleMapper roleMapper;
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public Role getRole(String roleId) {
		roleMapper.selectByPrimaryKey(roleId);
		return null;
	}

	@Override
	public int addRole(Role role) {	
		return roleMapper.insert(role);
	}

	@Override
	public int delRole(String id) {	
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Role> getAllRole() {
		RoleExample example = new RoleExample();	
		return roleMapper.selectByExample(example);
	}

	@Override
	public int update(Role role) {	
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public boolean getRoleIsExist(String rolename) {
		RoleExample example = new RoleExample();
		example.createCriteria().andRolenameEqualTo(rolename);
		List<Role> roles = roleMapper.selectByExample(example);
		if(StringUtils.isNotNull(roles)){
			return true;
		}
		return false;
	}
	
}
