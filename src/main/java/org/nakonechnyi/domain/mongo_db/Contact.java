package org.nakonechnyi.domain.mongo_db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.nakonechnyi.domain.BaseContact;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Getter
@Setter
@Document(collection = BaseContact.TABLE_NAME)
@ToString
public class Contact extends BaseContact /*implements Serializable*/ {

    @Id
    private ObjectId id;

//    @NotNull Sets by handler
    @DBRef
    private User owner;


//    @NotEmpty
//    @Size(min = 4)
//    private String lastName;
//    @NotEmpty
//    @Size (min = 4)
//    private String firstName;
//    @NotEmpty
//    @Size (min = 4)
//    private String surname;
//
//    @Phone
//    @NotEmpty
//    private String phone;
//
//    private String homePhone;
//
//    private String address;
//
//    @Email
//    private String email;


    public Contact() {
    }

    public Contact(BaseContact contact) {

        setFirstName(contact.getFirstName());
        setLastName(contact.getLastName());
        setSurname(contact.getSurname());
        setPhone(contact.getPhone());
        setAddress(contact.getAddress());
        setHomePhone(contact.getHomePhone());
    }
}
