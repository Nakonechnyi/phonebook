package org.nakonechnyi.domain.my_sql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.nakonechnyi.domain.BaseUser;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Entity
@Table(name = BaseUser.TABLE_NAME)
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User /*extends BaseUser*/ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

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

    public User() {
    }

    public User(BaseUser user) {
        this.setPassword(user.getPassword());
        setPib(user.getPib());
        setLogin(user.getLogin());
    }
}
