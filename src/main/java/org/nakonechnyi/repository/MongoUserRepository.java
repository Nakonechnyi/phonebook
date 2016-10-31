package org.nakonechnyi.repository;

import org.nakonechnyi.domain.mongo_db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @autor A_Nakonechnyi
 * @date 30.10.2016.
 */
@RepositoryRestResource(exported = false)
public interface MongoUserRepository extends MongoRepository<User, Long> {
    User findByLogin(String login);

}
