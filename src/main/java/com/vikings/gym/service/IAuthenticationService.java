package com.vikings.gym.service;

import com.vikings.gym.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
