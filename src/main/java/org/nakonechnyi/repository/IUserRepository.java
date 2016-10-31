package org.nakonechnyi.repository;

import org.nakonechnyi.domain.my_sql.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@RepositoryRestResource(exported = false)
public interface IUserRepository {
    User findByLogin(String s);


}
