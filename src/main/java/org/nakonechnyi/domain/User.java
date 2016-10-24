package org.nakonechnyi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "password")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size (min = 5)
    private String pib;

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "^[a-z]*$")
    private String login;

    //TODO hash
//    @JsonIgnore
    @NotEmpty
    @Size (min = 5)
    private String password;


    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST/*, mappedBy = "user"*/)
    private Collection<Contact> contacts;



}
