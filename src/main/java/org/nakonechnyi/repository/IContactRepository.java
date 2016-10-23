package org.nakonechnyi.repository;

import org.nakonechnyi.domain.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
public interface IContactRepository extends CrudRepository<Contact, Long> {
//    Contact save(Contact registration);
}
