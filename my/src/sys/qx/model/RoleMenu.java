package sys.qx.model;

import sys.qx.util.StringUtils;

public class RoleMenu {
   
	private String id;

    private String menid;

    private String roleid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMenid() {
        return menid;
    }

    public void setMenid(String menid) {
        this.menid = menid == null ? null : menid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }
    
    
    
    public RoleMenu(String menid, String roleid) {
		super();
		this.id = StringUtils.getUUID();
		this.menid = menid;
		this.roleid = roleid;
	}

	public RoleMenu() {
		super();
	}

	public RoleMenu(String id, String menid, String roleid) {
		super();
		this.id = id;
		this.menid = menid;
		this.roleid = roleid;
	}

	@Override
   	public String toString() {
   		return "RoleMenu [id=" + id + ", menid=" + menid + ", roleid=" + roleid
   				+ "]";
   	}

}