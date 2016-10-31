package org.nakonechnyi.domain.mongo_db;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.nakonechnyi.domain.BaseUser;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@ToString
@Document(collection = BaseUser.TABLE_NAME)
@Getter
@Setter
public class User extends BaseUser {

    @Id
    private String id;

    public User() {
    }

    public User(BaseUser user) {
        super();
        setPassword(user.getPassword());
        setLogin(user.getLogin());
        setPib(user.getPib());
    }

}
