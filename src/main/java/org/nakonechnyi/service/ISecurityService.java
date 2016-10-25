package org.nakonechnyi.service;

/**
 * @autor A_Nakonechnyi
 * @date 24.10.2016.
 */
public interface ISecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
