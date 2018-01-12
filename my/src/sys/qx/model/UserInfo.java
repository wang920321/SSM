package sys.qx.model;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
	
	private User user;
	private List<Role> roles = new ArrayList<Role>();
	@Override
	public String toString() {
		return "UserInfo [user=" + user + ", roles=" + roles + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public UserInfo(User user) {
		super();
		this.user = user;
	}
	public UserInfo() {
		super();
	}
}
