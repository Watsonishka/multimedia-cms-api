package com.mediaportal.cms.model;

import jakarta.annotation.Nullable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
    @Nullable
    private String patronymic;
    private Set<Article> articles = new HashSet<>();
}
