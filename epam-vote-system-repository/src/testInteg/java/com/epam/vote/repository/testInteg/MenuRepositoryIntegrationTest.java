package com.epam.vote.repository.testInteg;

import static org.junit.Assert.assertEquals;

import com.epam.vote.domain.Menu;
import com.epam.vote.repository.IMenuRepository;
import com.epam.vote.repository.IRestaurantDishMapRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Test for {@link IMenuRepository}.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 09, 2021
 * @author Sapar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmbeddedPostgresConfig.class)
public class MenuRepositoryIntegrationTest {

    @Autowired
    private IMenuRepository repository;

    @Autowired
    private IRestaurantDishMapRepository mapRepository;

    @Test
    public void testFindMenuOfRestaurant() {
        List<Menu> menuList = repository.findMenuOfRestaurant("12c1abd4-e9dc-43a0-90aa-441be8e9f8e7");
        assertEquals(1, menuList.size());
        Menu menu = menuList.get(0);
        assertEquals("550b17ef-389a-47a1-af76-1fb53373da68", menu.getId());
        assertEquals("pizza", menu.getName());
        assertEquals(new BigDecimal("5.55"), menu.getPrice());
    }

    @Test
    public void testSaveMenu() {
        Menu expectedMenu = new Menu();
        expectedMenu.setId("d91d2123-8ab9-4bcf-84e6-5794e065196c");
        expectedMenu.setName("Hot Dog");
        repository.saveMenu(expectedMenu);
        Menu actualMenu = repository.findById("d91d2123-8ab9-4bcf-84e6-5794e065196c");
        assertEquals("d91d2123-8ab9-4bcf-84e6-5794e065196c", actualMenu.getId());
        assertEquals("Hot Dog", actualMenu.getName());
        assertEquals("system", actualMenu.getCreatedUser());
    }

    @Test
    public void testSaveMenuToRestaurant() {
        Menu expectedMenu = new Menu("2963cbe3-6999-4e29-9c38-4fa30dde485d", "Burger", new BigDecimal("7.55"));
        repository.saveMenu(expectedMenu);
        mapRepository.saveMenuToRestaurant(expectedMenu, "b9c9fd2e-973e-425e-93a0-72cb547b2f66");
        List<Menu> menuList = repository.findMenuOfRestaurant("b9c9fd2e-973e-425e-93a0-72cb547b2f66");
        assertEquals(1, menuList.size());
        Menu menu = menuList.get(0);
        assertEquals("2963cbe3-6999-4e29-9c38-4fa30dde485d", menu.getId());
        assertEquals("Burger", menu.getName());
        assertEquals(new BigDecimal("7.55"), menu.getPrice());
    }
}
