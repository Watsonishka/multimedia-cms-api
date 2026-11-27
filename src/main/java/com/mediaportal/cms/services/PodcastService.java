package com.mediaportal.cms.services;

import com.mediaportal.cms.models.Episode;
import com.mediaportal.cms.models.Podcast;
import com.mediaportal.cms.repositories.EpisodeRepository;
import com.mediaportal.cms.repositories.PodcastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PodcastService {

    private final PodcastRepository podcastRepository;

    public Podcast create(Podcast podcast) {
        return  podcastRepository.save(podcast);
    }

    public List<Podcast> getAll() {
        return podcastRepository.findAll();
    }

    public Podcast getById(UUID id) {
        return podcastRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Подкаст не найден: " + id));
    }

    public Podcast update(UUID id, Podcast updatedData) {
        Podcast existing = getById(id);
        existing.setHeader(updatedData.getHeader());
        return podcastRepository.save(existing);
    }

    public void delete(UUID id) {
        if (!podcastRepository.existsById(id)) {
            throw new RuntimeException("Подкаст не найден: " + id);
        }
        podcastRepository.deleteById(id);
    }
}
