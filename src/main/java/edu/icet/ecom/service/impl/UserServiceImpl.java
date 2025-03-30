package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.User;
import edu.icet.ecom.entity.UserEntity;
import edu.icet.ecom.repository.UserRepository;
import edu.icet.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public boolean isValid(User user) {
        List<UserEntity> userEntityList = repository.findByUserName(user.getUserName());

        if (userEntityList != null) {
            for (UserEntity userEntity : userEntityList) {
                if (user.getUserName().equals(userEntity.getUserName()) && user.getPassword().equals(userEntity.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
