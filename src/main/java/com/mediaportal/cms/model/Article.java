package com.mediaportal.cms.model;

import java.util.*;

public class Article {
    private UUID id;
    private String header;
    private String text;
    private Set<Author> authors = new HashSet<>();
    private Date publicationDate;
}
