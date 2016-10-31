package org.nakonechnyi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @autor A_Nakonechnyi
 * @date 31.10.2016.
 */
@Getter
@Setter
@ToString(exclude = "basePassword")
public class BaseUser implements Serializable {

    public static final String TABLE_NAME = "users";

    @NotEmpty
    @Size(min = 5)
    private String pib;

    @NotEmpty
    @Size(min = 3)
    @Pattern(regexp = "^[a-z]*$")
    private String login;

    @NotEmpty
    @Size (min = 5)
    @JsonIgnore
    private String password;
}
