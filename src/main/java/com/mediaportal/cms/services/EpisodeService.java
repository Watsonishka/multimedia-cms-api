package com.mediaportal.cms.services;

import com.mediaportal.cms.models.Episode;
import com.mediaportal.cms.repositories.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    public Episode create(Episode episode) {
        return episodeRepository.save(episode);
    }

    public List<Episode> getAll() {
        return episodeRepository.findAll();
    }

    public Episode getById(UUID id) {
        return episodeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Эпизод не найден: " + id));
    }

    public Episode update(UUID id, Episode updatedData) {
        Episode existing = getById(id);
        existing.setNumber(updatedData.getNumber());
        existing.setHeader(updatedData.getHeader());
        existing.setURL(updatedData.getURL());
        existing.setDuration(updatedData.getDuration());
        existing.setPodcast(updatedData.getPodcast());
        return episodeRepository.save(existing);
    }

    public void delete(UUID id) {
        if (!episodeRepository.existsById(id)) {
            throw new RuntimeException("Эпизод не найден: " + id);
        }
        episodeRepository.deleteById(id);
    }
}
