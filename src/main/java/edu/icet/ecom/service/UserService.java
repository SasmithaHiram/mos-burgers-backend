package edu.icet.ecom.service;

import edu.icet.ecom.dto.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> searchUserByEmail(String email);

}
