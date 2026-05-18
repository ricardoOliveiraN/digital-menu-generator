package com.digital.menu_generator.application.port.out.menu;

import com.digital.menu_generator.domain.Menu;

public interface CreateMenuRepository {

        void saveMenu(Menu menu);

}
