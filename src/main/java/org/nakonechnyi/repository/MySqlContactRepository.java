package org.nakonechnyi.repository;

import org.nakonechnyi.domain.DbQualifier;
import org.nakonechnyi.domain.my_sql.Contact;
import org.nakonechnyi.domain.my_sql.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 30.10.2016.
 */
@RepositoryRestResource(exported = false)
@Component
//@Primary
@DbQualifier(DbQualifier.DbSource.MY_SQL)
public interface MySqlContactRepository extends IContactRepository {

    //    @Query("select contact from Contact contact where contact.owner.login = ?#{principal.username}")
//    @RestResource( path = "my")
    List<Contact> findByOwner(User user);

    List<Contact> findByFirstName(String name);

    List<Contact> findByLastName(String lastName);

    @Query("SELECT contact FROM Contact contact WHERE contact.phone LIKE CONCAT('%',:phone,'%')")
    List<Contact> findByPhone(@Param("phone")String phone);

    Contact getById(Long id);

    Contact save(Contact contact);

    @RestResource(exported = false)
    @Override
    Iterable<Contact> findAll(Sort sort);

    @RestResource(exported = false)
    @Override
    Page<Contact> findAll(Pageable pageable);

    @RestResource(exported = false)
    @Override
    void deleteAll();

}