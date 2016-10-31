package org.nakonechnyi.domain.my_sql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.nakonechnyi.domain.BaseContact;
import org.nakonechnyi.domain.validator.Phone;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Getter
@Setter
@Entity
@Table(name = BaseContact.TABLE_NAME)
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contact /*extends BaseContact */implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @NotNull Sets by handler
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private User owner;

    @NotEmpty
    @Size(min = 4)
    private String lastName;
    @NotEmpty
    @Size(min = 4)
    private String firstName;
    @NotEmpty
    @Size (min = 4)
    private String surname;

    @Phone
    @NotEmpty
    private String phone;

    private String homePhone;

    private String address;

    @Email
    private String email;

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
