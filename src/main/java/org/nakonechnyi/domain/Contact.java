package org.nakonechnyi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.nakonechnyi.domain.validator.Phone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Entity
@Table(name = "contacts")
@Getter @Setter
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private User owner;

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
