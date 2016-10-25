package org.nakonechnyi.repository;

import org.nakonechnyi.domain.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
public interface IContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
