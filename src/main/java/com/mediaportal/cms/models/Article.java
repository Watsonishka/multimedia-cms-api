package com.mediaportal.cms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String header;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @ElementCollection
    @CollectionTable(name = "article_authors", joinColumns = @JoinColumn(name = "article_id"))
    @Column(name = "author_name")
    private Set<String> authors = new HashSet<>();

    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;
}
