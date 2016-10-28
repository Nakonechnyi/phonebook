package org.nakonechnyi.repository;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
public interface IContactRepository extends PagingAndSortingRepository<Contact, Long> {

//    @Query("select contact from Contact contact where contact.owner.login = ?#{principal.username}")
//    @RestResource( path = "my")
    List<Contact> findByOwner(User user);

    Contact getById(Long id);
}
