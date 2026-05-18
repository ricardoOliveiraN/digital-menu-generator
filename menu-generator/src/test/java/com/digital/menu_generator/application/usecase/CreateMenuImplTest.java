package com.digital.menu_generator.application.usecase;

import com.digital.menu_generator.application.command.CreateMenuCommand;
import com.digital.menu_generator.application.port.out.menu.CreateMenuRepository;
import com.digital.menu_generator.application.port.out.user.GetUserDetailsRepository;
import com.digital.menu_generator.application.port.out.user.SaveUserDetailsRepository;
import com.digital.menu_generator.domain.Menu;
import com.digital.menu_generator.domain.User;
import com.digital.menu_generator.domain.exceptions.MenuCreationLimitExceedException;
import com.digital.menu_generator.domain.exceptions.MenuPersistenceException;
import com.digital.menu_generator.domain.exceptions.UserNotFounException;
import com.digital.menu_generator.domain.exceptions.UserPersistenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;



@ExtendWith(MockitoExtension.class)
public class CreateMenuImplTest {

    @InjectMocks
    private CreateMenuImpl createMenuImp;

    @Mock
    private CreateMenuRepository createMenuRepository;
    @Mock
    private GetUserDetailsRepository getUserDetailsRepository;
    @Mock
    private SaveUserDetailsRepository saveUserDetailsRepository;

    private final UUID userId = UUID.randomUUID();

    @Test
    @DisplayName("quando usuário válido cria menu -> incrementa quantidade e salva menu e user")
    public void deveCriarMenu_eAtualizarUser() {

        // arrange
        User user = new User(userId, "João", "x@x.com", "123", 2, "logo", "marca");
        CreateMenuCommand command = new CreateMenuCommand(userId, "Menu Teste");

        when(getUserDetailsRepository.findUser(userId)).thenReturn(user);

        ArgumentCaptor<Menu> menuCaptor = ArgumentCaptor.forClass(Menu.class);

        // act
        createMenuImp.execute(command);

        // assert estado do user
        assertEquals(3, user.getQuantidadeMenus());

        // assert interações e conteúdo salvo
        verify(createMenuRepository).saveMenu(menuCaptor.capture());
        Menu saved = menuCaptor.getValue();
        assertEquals("Menu Teste", saved.getNomeMenu());
        assertEquals(userId, saved.getIdUser());

        verify(saveUserDetailsRepository).saveUserDetails(user);
        verifyNoMoreInteractions(createMenuRepository, saveUserDetailsRepository, getUserDetailsRepository);

    }

    @Test
    @DisplayName("quando usuário excedeu limite de menus (3) -> lança erro e não salva menu ou user")
    public void deveLancerErro_QuandoUsuarioExecedeuLimite(){

        //arrange

        User user = new User(userId, "João", "x@gmail.com", "123", 3, "logo", "marca");
        CreateMenuCommand command = new CreateMenuCommand(userId, "Menu Teste");

        when(getUserDetailsRepository.findUser(userId)).thenReturn(user);

        //act &    assert

        assertThrows(MenuCreationLimitExceedException.class, () -> createMenuImp.execute(command));

        verifyNoMoreInteractions(createMenuRepository, saveUserDetailsRepository);

    }

    @Test
    @DisplayName("quando ocorre erro ao buscar detalhes do usuário (id inválido) -> lança erro e não salva menu ou user")
    public void deveLancerErro_QuandoOcorreErroAoBuscarUserDetails(){

        //arrange
        CreateMenuCommand command = new CreateMenuCommand(userId, "Menu Teste");
        when(getUserDetailsRepository.findUser(userId)).thenThrow(new UserNotFounException("User not found with id: " + userId));
        //act & assert
        assertThrows(UserNotFounException.class, () -> createMenuImp.execute(command));
        verifyNoMoreInteractions(createMenuRepository, saveUserDetailsRepository);
    }

    @Test
    @DisplayName("quando ocorre erro ao salvar menu (erro interno) -> lança erro e não salva user")
    public void deveLancarErro_QuandoOcorreErroAoSalvarMenu(){

        //arrange
        User user = new User(userId, "João", "txt@gmail.com", "123", 2, "logo", "marca");
        CreateMenuCommand command = new CreateMenuCommand(userId, "Menu Teste");
        when(getUserDetailsRepository.findUser(userId)).thenReturn(user);
        doThrow(new MenuPersistenceException("Database error", new RuntimeException("DB connection failed")))
                .when(createMenuRepository).saveMenu(any(Menu.class));

        //act & assert
        assertThrows(MenuPersistenceException.class, () -> createMenuImp.execute(command));
        verify(getUserDetailsRepository).findUser(userId);
        verify(createMenuRepository).saveMenu(any(Menu.class));

        verifyNoMoreInteractions(getUserDetailsRepository, createMenuRepository, saveUserDetailsRepository);

    }

    /*CENÁRIOS:


        - Ocorre um erro ao salvar o menu e o processo é interrompido
        - Ocorre um erro ao salvar os detalhes do usuário e o processo é interrompido
     */


}
