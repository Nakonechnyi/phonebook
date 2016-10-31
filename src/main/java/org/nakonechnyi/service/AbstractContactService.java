package org.nakonechnyi.service;

import org.nakonechnyi.domain.BaseContact;
import org.nakonechnyi.domain.DbQualifier;
import org.nakonechnyi.domain.my_sql.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

/**
 * @autor A_Nakonechnyi
 * @date 31.10.2016.
 */
@Service
public class AbstractContactService {

    @Value("${db_type}")
    DbQualifier.DbSource dbType;

    @Autowired
    private MySqlContactService mySqlContactServise;
    @Autowired
    private MongoDbContactService mongoDbContactServise;

    public Resources<PersistentEntityResource> listEntities(PersistentEntityResourceAssembler assembler) {
        return dbType == DbQualifier.DbSource.MY_SQL ?
                mySqlContactServise.listEntities(assembler) :
                mongoDbContactServise.listEntities(assembler);
    }

    public Resource create(BaseContact contact, PersistentEntityResourceAssembler assembler) {
        return dbType == DbQualifier.DbSource.MY_SQL ?
                mySqlContactServise.create(new Contact(contact), assembler) :
                mongoDbContactServise.create( new org.nakonechnyi.domain.mongo_db.Contact(contact), assembler);
    }

    public Resources<PersistentEntityResource> findByName(String name, PersistentEntityResourceAssembler assembler) {
        return dbType == DbQualifier.DbSource.MY_SQL ?
                mySqlContactServise.findByName(name, assembler) :
                mongoDbContactServise.findByName(name, assembler);
    }

    public Resources<PersistentEntityResource> findByLastName(String lastName, PersistentEntityResourceAssembler assembler) {
        return dbType == DbQualifier.DbSource.MY_SQL ?
                mySqlContactServise.findByLastName(lastName, assembler) :
                mongoDbContactServise.findByLastName(lastName, assembler);
    }

    public Resources<PersistentEntityResource> findByPhone(String phone, PersistentEntityResourceAssembler assembler) {
        return dbType == DbQualifier.DbSource.MY_SQL ?
                mySqlContactServise.findByPhone(phone, assembler) :
                mongoDbContactServise.findByPhone(phone, assembler);
    }
}
