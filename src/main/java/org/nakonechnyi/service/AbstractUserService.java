package org.nakonechnyi.service;

import org.nakonechnyi.domain.BaseUser;
import org.nakonechnyi.domain.DbQualifier;
import org.nakonechnyi.domain.my_sql.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @autor A_Nakonechnyi
 * @date 31.10.2016.
 */
@Service
public class AbstractUserService {

    @Value("${db_type}")
    DbQualifier.DbSource dbType;

    @Autowired
    private MySqlUserService mySqlUserService;
    @Autowired
    private MongoDbUserService mongoDbUserService;

    public void register(BaseUser user) {
        if (dbType == DbQualifier.DbSource.MY_SQL) {
            mySqlUserService.register(new User(user));
        } else {
            mongoDbUserService.register(new org.nakonechnyi.domain.mongo_db.User (user));
        }
    }
}
