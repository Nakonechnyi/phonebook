package org.nakonechnyi.repository;

import org.nakonechnyi.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

public interface IUserRepository extends CrudRepository<User, Long>{

    User findByLogin(String s);

    User getById(long id);

    @RestResource(exported = false)
    @Override
    User findOne(Long aLong);

    @RestResource(exported = false)
    @Override
    boolean exists(Long aLong);

    @RestResource(exported = false)
    @Override
    Iterable<User> findAll();

    @RestResource(exported = false)
    @Override
    Iterable<User> findAll(Iterable<Long> iterable);

    @RestResource(exported = false)
    @Override
    long count();

    @RestResource(exported = false)
    @Override
    void delete(Long aLong);

    @RestResource(exported = false)
    @Override
    void delete(User user);

    @RestResource(exported = false)
    @Override
    void delete(Iterable<? extends User> iterable);

    @RestResource(exported = false)
    @Override
    void deleteAll();
}
