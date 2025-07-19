package edu.icet.ecom.service;

import edu.icet.ecom.dto.User;

import java.util.List;

public interface UserService {
    Boolean isValid(User user);
    Boolean create(User user);
}
