package com.riwi.library.infraestructure.abstract_service;

import com.riwi.library.api.dto.request.UserRequest;
import com.riwi.library.api.dto.response.UserAllInfoResponse;
import com.riwi.library.api.dto.response.UserResponse;

public interface IUserService extends CrudServices<UserRequest, UserResponse, Long>{ 

    UserAllInfoResponse findById(Long id);
}
