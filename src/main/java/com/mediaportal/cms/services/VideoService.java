package com.mediaportal.cms.services;

import com.mediaportal.cms.models.Video;
import com.mediaportal.cms.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    public Video create(Video video) {
        return videoRepository.save(video);
    }

    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    public Video getById(UUID id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Видео не найдено: " + id));
    }

    public Video update(UUID id, Video updatedData) {
        Video existing = getById(id);
        existing.setHeader(updatedData.getHeader());
        existing.setURL(updatedData.getURL());
        existing.setDuration(updatedData.getDuration());
        return videoRepository.save(existing);
    }

    public void delete(UUID id) {
        if (!videoRepository.existsById(id)) {
            throw new RuntimeException("Видео не найдено: " + id);
        }
        videoRepository.deleteById(id);
    }
}
