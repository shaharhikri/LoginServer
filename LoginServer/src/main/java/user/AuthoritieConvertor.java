package user;

import org.springframework.stereotype.Service;

import data.AuthoritieEntity;

@Service
public class AuthoritieConvertor {
	public AuthoritieBoundary toBoundary(AuthoritieEntity e) {
		AuthoritieBoundary b = new AuthoritieBoundary();
		b.setAuthority(e.getAuthority());
		b.setUsername(e.getUsername());
		return b;
	}
	
	public AuthoritieEntity toEntity(AuthoritieBoundary b) {
		AuthoritieEntity e = new AuthoritieEntity();
		e.setAuthority(b.getAuthority());
		e.setUsername(b.getUsername());
		return e;
	}
}
