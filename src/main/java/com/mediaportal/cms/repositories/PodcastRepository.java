package com.mediaportal.cms.repositories;

import com.mediaportal.cms.models.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PodcastRepository extends JpaRepository<Podcast, UUID> {
}
