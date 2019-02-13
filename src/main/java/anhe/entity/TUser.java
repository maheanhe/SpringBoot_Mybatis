package anhe.entity;

import java.io.Serializable;

public class TUser implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String password;

    private String rolelist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRolelist() {
        return rolelist;
    }

    public void setRolelist(String rolelist) {
        this.rolelist = rolelist == null ? null : rolelist.trim();
    }
}