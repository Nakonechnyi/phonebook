package org.nakonechnyi.service;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Service
@Transactional
public class ContactService {

    @Autowired
    private IContactRepository contactRepository;

}
