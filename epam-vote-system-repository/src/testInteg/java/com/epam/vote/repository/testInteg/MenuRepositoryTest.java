package com.epam.vote.repository.testInteg;

import com.epam.vote.domain.Menu;
import com.epam.vote.repository.IMenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
public class MenuRepositoryTest {

    @Autowired
    private IMenuRepository repository;

    @Test
    public void testFindMenuOfRestaurant() {
        List<Menu> menuList = repository.findMenuOfRestaurant("KFC");
        assertEquals(1, menuList.size());
        Menu menu = menuList.get(0);
        assertEquals("550b17ef-389a-47a1-af76-1fb53373da68", menu.getId());
        assertEquals("pizza", menu.getName());
        assertEquals(new BigDecimal("5.55"), menu.getPrice());
    }
}
