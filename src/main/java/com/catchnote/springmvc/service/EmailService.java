package com.catchnote.springmvc.service;

import com.catchnote.springmvc.model.User;

public interface EmailService {
    void sendValidationEmail(User user);
    void validateEmail(User user);
}
