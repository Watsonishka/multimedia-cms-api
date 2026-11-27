package com.mediaportal.cms.repositories;

import com.mediaportal.cms.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
}
