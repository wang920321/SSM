package sys.qx.model;

import sys.qx.util.StringUtils;

public class UserRole {
    
	private String id;

    private String userid;

    private String roleid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }
    
    public UserRole() {
		super();
	}

	public UserRole(String id, String userid, String roleid) {
		super();
		this.id = id;
		this.userid = userid;
		this.roleid = roleid;
	}
	
	public UserRole(String userid, String roleid) {
		super();
		this.id = StringUtils.getUUID();
		this.userid = userid;
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userid=" + userid + ", roleid="
				+ roleid + "]";
	}

}