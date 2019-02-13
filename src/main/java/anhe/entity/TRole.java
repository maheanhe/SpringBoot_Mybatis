package anhe.entity;

public class TRole {
    private Integer id;

    private String rolename;

    private String permissionlist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getPermissionlist() {
        return permissionlist;
    }

    public void setPermissionlist(String permissionlist) {
        this.permissionlist = permissionlist == null ? null : permissionlist.trim();
    }
}