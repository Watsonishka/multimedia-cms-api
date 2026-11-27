package com.mediaportal.cms.repositories;

import com.mediaportal.cms.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EpisodeRepository extends JpaRepository<Episode, UUID> {
}
