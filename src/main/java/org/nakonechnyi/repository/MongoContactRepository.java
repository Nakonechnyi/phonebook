package org.nakonechnyi.repository;

import org.bson.types.ObjectId;
import org.nakonechnyi.domain.mongo_db.Contact;
import org.nakonechnyi.domain.mongo_db.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 30.10.2016.
 */
@RepositoryRestResource(exported = false)
public interface MongoContactRepository extends MongoRepository<Contact, Long> {

    String FIND_FIELDS = "{ id: 1, owner: 1, lastName: 1, firstName: 1, surname: 1, phone: 1, homePhone: 1, address: 1, email: 1 }";

    List<Contact> findByOwner(User user);

    List<Contact> findByFirstName(String name);

    List<Contact> findByLastName(String lastName);

    @Query (value = "{'phone': {'$regex': '.*?0.*'}}",
    fields = FIND_FIELDS)
    List<Contact> findByPhone(String phone);

    Contact getById(ObjectId id);
}
