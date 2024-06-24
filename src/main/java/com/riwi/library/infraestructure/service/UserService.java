package com.riwi.library.infraestructure.service;

import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserAllInfoResponse;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.User;
import com.riwi.library.domain.repositories.UserRepository;
import com.riwi.library.infraestructure.abstract_service.IUserService;
import com.riwi.library.infraestructure.mappers.UserMapper;
import com.riwi.library.utils.exception.BadRequestException;
import com.riwi.library.utils.message.ErrorMessages;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;


    @Override
    public UserResponse create(UserRequest request) {
        User user = this.userMapper.userRequestToUser(request);

        return userMapper.userToUserResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse get(Long id) {

        User userGet = this.userRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.IdNotFound("User")));

        return userMapper.userToUserResponse(userGet);

    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {

        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination)
                .map(userMapper::userToUserResponse);

    }

    @Override
    public UserResponse update(UserRequest request, Long id) {

        User user = this.userRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.IdNotFound("User")));

        User userRequest = userMapper.userRequestToUser(request);
        userRequest.setId(user.getId());

        return this.userMapper.userToUserResponse(this.userRepository.save(userRequest));
    }

    @Override
    public void delete(Long id) {

        User user = this.userRepository.findById(id)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.IdNotFound("User")));

        this.userRepository.deleteById(id);
    }

    @Override
    public UserAllInfoResponse findById(Long id){
        return this.userRepository.findById(id)
                .map(userMapper::userToUserAllInfoResponse)
                .orElseThrow(()-> new BadRequestException(ErrorMessages.IdNotFound("User")));
    }
}