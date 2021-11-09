package user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dal.UserDao;
import data.AuthoritieEntity;
import data.UserEntity;
import errors.BadRequestException;

@Service
public class SignupServiceJpa implements SignupService{
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserConvertor convertor;
	
	AuthoritieEntity e = new AuthoritieEntity();
	
	public SignupServiceJpa() {
		e.setAuthority("ROLE_USER"); 
	}
	
	
	public void signUp(UserBoundary user_b) {
		//Check fields
		checkUsername(user_b);checkPassword(user_b);
		
		Optional<UserEntity> optional = userDao.findById(user_b.getUsername());
		if(optional.isPresent())
			throw new BadRequestException("User already exists.");//UserExistsException();
		else {
			UserEntity user_e = convertor.toEntity(user_b);
			userDao.save(user_e);
		}
	}
	
	private void checkUsername(UserBoundary b) {
		if(b.getUsername()==null || b.getUsername()=="")
			throw new BadRequestException("Invalid username.");
	}
	
	private void checkPassword(UserBoundary b) {
		if(b.getPassword()==null || b.getPassword()=="")
			throw new BadRequestException("Invalid password.");
	}
	
	
}
