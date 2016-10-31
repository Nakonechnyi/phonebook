package org.nakonechnyi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.nakonechnyi.domain.validator.Phone;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @autor A_Nakonechnyi
 * @date 31.10.2016.
 */

@Getter
@Setter
@ToString
public class BaseContact implements Serializable {

    public static final String TABLE_NAME = "contacts";

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
}
