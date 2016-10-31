package org.nakonechnyi.service;

/**
 * @autor A_Nakonechnyi
 * @date 24.10.2016.
 */
public interface ISecurityService {

    void autoLogin(String username, String password);

    String findLoggedInUsername();
}
