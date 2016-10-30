package org.nakonechnyi.repository;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
public interface IContactRepository extends PagingAndSortingRepository<Contact, Long> {

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
