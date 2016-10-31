package org.nakonechnyi.service;

import org.nakonechnyi.domain.my_sql.User;

/**
 * @autor A_Nakonechnyi
 * @date 25.10.2016.
 */
public interface IUserService {

    User register(User registration);

    User findByLogin(String s);
}
