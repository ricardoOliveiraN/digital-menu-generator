package com.digital.menu_generator.application.usecase;

import com.digital.menu_generator.application.port.out.menu.CreateMenuRepository;
import com.digital.menu_generator.application.port.out.user.GetUserDetailsRepository;
import com.digital.menu_generator.application.port.out.user.SaveUserDetailsRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateMenuImpTest {

    @InjectMocks
    private CreateMenuImpl createMenuImp;

    @Mock
    private CreateMenuRepository createMenuRepository;
    @Mock
    private GetUserDetailsRepository getUserDetailsRepository;
    @Mock
    private SaveUserDetailsRepository saveUserDetailsRepository;

    /*CENÁRIOS:
        - Usuário tem permissão para criar menu e o menu é criado com sucesso
        - Usuário não tem permissão para criar menu e recebe erro (ja tem 3 eventos criados)
        - Ocorre um erro ao buscar os detalhes do usuário e o processo é interrompido
        - Ocorre um erro ao salvar o menu e o processo é interrompido
        - Ocorre um erro ao salvar os detalhes do usuário e o processo é interrompido
     */


}
