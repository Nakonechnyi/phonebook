package org.nakonechnyi.repository;

import org.nakonechnyi.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

public interface IUserRepository extends CrudRepository<User, Long>{

    User findByLogin(String s);
}
