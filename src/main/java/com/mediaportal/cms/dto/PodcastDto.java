package com.mediaportal.cms.dto;

import java.time.Duration;
import java.util.List;

public class PodcastDto {
    private String header;
    private List<EpisodeDto> episodes;
    private String URL;
    private Duration duration;
}
