package com.digital.menu_generator.application.port.out.user;

import com.digital.menu_generator.domain.User;
import java.util.UUID;

public interface GetUserDetailsRepository {

    User findUser(UUID userId);

}
