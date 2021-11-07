package dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import data.UserEntity;

@Repository
public interface SigninDao extends CrudRepository<UserEntity, String> {
//	@Modifying
//	@Query(value = "ALTER TABLE authorities ADD constraint fk_authorities_users foreign key(username) references users(username); create unique index ix_auth_username on authorities (username,authority);", nativeQuery = true)
//	void fix1();

//	@Modifying
//	@Query(value = "create unique index ix_auth_username on authorities (username,authority)",nativeQuery=false)
//	public void fix2();
}
