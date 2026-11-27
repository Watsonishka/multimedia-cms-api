package com.mediaportal.cms.repositories;

import com.mediaportal.cms.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
}
