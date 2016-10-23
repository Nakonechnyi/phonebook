package org.nakonechnyi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.nakonechnyi.domain.validator.Phone;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Entity
@Table(name = "contacts")
@Getter @Setter
@ToString (exclude = "password")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size (min = 3)
    @Pattern(regexp = "^[a-z]*$")
    private String login;

    //TODO hash
//    @JsonIgnore
    @NotEmpty
    @Size (min = 5)
    private String password;
    @NotEmpty
    @Size (min = 5)
    private String pib;
    @NotEmpty
    private String info;
    @NotEmpty
    @Size (min = 4)
    private String lastName;
    @NotEmpty
    @Size (min = 4)
    private String firstName;
    @NotEmpty
    @Size (min = 4)
    private String surname;

    @Phone
    @NotEmpty
    private String phone;

    @Phone
    private String homePhone;

    private String address;

    @Email
    private String email;

}
