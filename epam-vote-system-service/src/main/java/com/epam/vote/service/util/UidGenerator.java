package com.epam.vote.service.util;

import java.util.UUID;

/**
 * Uid generator.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: июнь 29, 2021
 * @author Sapar
 */
public class UidGenerator {

    private UidGenerator() {
        throw new IllegalStateException("This class have only private constructor");
    }

    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
