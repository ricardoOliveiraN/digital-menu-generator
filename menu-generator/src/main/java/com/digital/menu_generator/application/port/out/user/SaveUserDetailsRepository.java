package com.digital.menu_generator.application.port.out.user;

import com.digital.menu_generator.domain.User;

public interface SaveUserDetailsRepository {

    void saveUserDetails(User user);

}
