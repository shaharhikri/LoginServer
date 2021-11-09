package user;

import org.springframework.stereotype.Service;

import data.UserEntity;

@Service
public class UserConvertor {
	public UserBoundary toBoundary(UserEntity e) {
		UserBoundary b = new UserBoundary();
		b.setUsername(e.getUsername());
		b.setPassword(e.getPassword());
		return b;
	}
	
	public UserEntity toEntity(UserBoundary b) {
		UserEntity e = new UserEntity();
		e.setUsername(b.getUsername());
		e.setPassword(b.getPassword());
		return e;
	}
}
