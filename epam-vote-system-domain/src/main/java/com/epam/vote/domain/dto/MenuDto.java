package com.epam.vote.domain.dto;

import com.epam.vote.domain.Menu;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Menu dto.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 15, 2021
 * @author Sapar
 */
public class MenuDto {

    private String id;

    @NotBlank
    @Size(min = 2, max = 255)
    private String name;

    @DecimalMax("500")
    @DecimalMin("1")
    private BigDecimal price;

    public MenuDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.price = menu.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MenuDto)) {
            return false;
        }
        MenuDto menuDto = (MenuDto) o;
        return id.equals(menuDto.id) && name.equals(menuDto.name) && price.equals(menuDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "MenuDto{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
