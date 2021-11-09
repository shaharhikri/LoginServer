package user;

public class AuthoritieBoundary {
	private String username;
	private String authority;
	
	public AuthoritieBoundary() { }

	public String getUsername() {
		return username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
