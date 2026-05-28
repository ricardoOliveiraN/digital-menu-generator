package com.digital.menu_generator.application.usecase;

import com.digital.menu_generator.application.command.CreateMenuCommand;
import com.digital.menu_generator.application.port.in.CreateMenuUseCase;
import com.digital.menu_generator.application.port.out.menu.SaveMenuRepository;
import com.digital.menu_generator.application.port.out.user.GetUserDetailsRepository;
import com.digital.menu_generator.application.port.out.user.SaveUserDetailsRepository;
import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.domain.User;

public class CreateMenuImpl implements CreateMenuUseCase {

    private final GetUserDetailsRepository getUserDetailsRepository;
    private final SaveUserDetailsRepository saveUserDetailsRepository;
    private final SaveMenuRepository saveMenuRepository;

    public CreateMenuImpl(GetUserDetailsRepository getUserDetailsRepository, SaveUserDetailsRepository saveUserDetailsRepository, SaveMenuRepository saveMenuRepository) {
        this.getUserDetailsRepository = getUserDetailsRepository;
        this.saveUserDetailsRepository = saveUserDetailsRepository;
        this.saveMenuRepository = saveMenuRepository;
    }

    @Override
    public void execute(CreateMenuCommand command) {

        User userDatails = getUserDetailsRepository.findUser(command.idUser());

        Menu menu = userDatails.createMenu(command.name());

        saveMenuRepository.saveMenu(menu);

        saveUserDetailsRepository.saveUserDetails(userDatails);

    }
}
