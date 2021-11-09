package dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import data.UserEntity;

@Repository
public interface UserDao extends CrudRepository<UserEntity, String> {

}
