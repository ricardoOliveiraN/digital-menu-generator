package com.digital.menu_generator.application.usecase;

import com.digital.menu_generator.application.command.CreateMenuCommand;
import com.digital.menu_generator.application.port.in.CreateMenuUseCase;
import com.digital.menu_generator.application.port.out.menu.CreateMenuRepository;
import com.digital.menu_generator.application.port.out.user.GetUserDetailsRepository;
import com.digital.menu_generator.application.port.out.user.SaveUserDetailsRepository;
import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.domain.User;

public class CreateMenuImpl implements CreateMenuUseCase {

    private GetUserDetailsRepository getUserDetailsRepository;
    private SaveUserDetailsRepository saveUserDetailsRepository;
    private CreateMenuRepository createMenuRepository;

    public CreateMenuImpl(GetUserDetailsRepository getUserDetailsRepository, SaveUserDetailsRepository saveUserDetailsRepository, CreateMenuRepository createMenuRepository) {
        this.getUserDetailsRepository = getUserDetailsRepository;
        this.saveUserDetailsRepository = saveUserDetailsRepository;
        this.createMenuRepository = createMenuRepository;
    }

    @Override
    public void execute(CreateMenuCommand command) {

        User userDatails = getUserDetailsRepository.findUser(command.idUser()); //já trata erro

        if(!userDatails.canCreateMenu()){
            //retorna erro
        }

        Menu menu = new Menu(null ,command.idUser(), command.name());

        createMenuRepository.saveMenu();

        userDatails.incrementMenuCount();
        saveUserDetailsRepository.saveUserDetails(); 

    }
}
