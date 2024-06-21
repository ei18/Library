package com.riwi.library.infraestructure.mappers;

import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserAllInfoResponse;
import com.riwi.library.api.dto.response.UserResponse;
import com.riwi.library.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    User userRequestToUser(UserRequest request);

    UserAllInfoResponse userToUserAllInfoResponse(User response);

    UserResponse userToUserResponse(User user);
}

