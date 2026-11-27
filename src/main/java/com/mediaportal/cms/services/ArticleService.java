package com.mediaportal.cms.services;

import com.mediaportal.cms.models.Article;
import com.mediaportal.cms.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article create(Article article) {
        return articleRepository.save(article);
    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article getById(UUID id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Статья не найдена: " + id));
    }

    public Article update(UUID id, Article updatedData) {
        Article existing = getById(id);
        existing.setHeader(updatedData.getHeader());
        existing.setText(updatedData.getText());
        existing.setAuthors(updatedData.getAuthors());
        existing.setPublicationDate(updatedData.getPublicationDate());
        return articleRepository.save(existing);
    }

    public void delete(UUID id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Статья не найдена: " + id);
        }
        articleRepository.deleteById(id);
    }
}
