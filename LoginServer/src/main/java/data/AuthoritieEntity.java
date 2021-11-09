package data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class AuthoritieEntity {
	private String username;
	private String authority;
	
	public AuthoritieEntity() { }

	@Id
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
	
//	@Query("ALTER TABLE authorities ADD constraint fk_authorities_users foreign key(username) references users(username)")
//	public void fix1() {}
	
}
