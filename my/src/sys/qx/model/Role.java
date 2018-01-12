package sys.qx.model;

public class Role {

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}

	private String id;

    private String rolename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

	public Role(String id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}

	public Role() {
		super();
	}
    
}