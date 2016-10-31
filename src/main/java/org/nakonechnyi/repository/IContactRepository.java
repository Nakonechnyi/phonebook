package org.nakonechnyi.repository;

import org.nakonechnyi.domain.my_sql.Contact;
import org.nakonechnyi.domain.my_sql.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@RepositoryRestResource(exported = false)
public interface IContactRepository extends PagingAndSortingRepository<Contact, Long> {
    List<Contact> findByOwner(User user);

    List<Contact> findByFirstName(String name);

    List<Contact> findByLastName(String lastName);

    List<Contact> findByPhone(String phone);

    Object getById(Long id);
}
