package com.digital.menu_generator.application.port.out.menu;

import com.digital.menu_generator.domain.Menu;

public interface SaveMenuRepository {

        void saveMenu(Menu menu);

}
