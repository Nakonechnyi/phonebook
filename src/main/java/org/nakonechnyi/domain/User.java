package org.nakonechnyi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    private Long id;

    @NotEmpty
    @Size (min = 5)
    private String pib;

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "^[a-z]*$")
    private String login;

    @NotEmpty
    @Size (min = 5)
    private String password;

}
