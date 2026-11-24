package com.mediaportal.cms.model;

import java.time.Duration;
import java.util.UUID;

public class Episode {
    private UUID id;
    private int number;
    private String header;
    private String URL;
    private Duration duration;
    private Podcast podcast;
}
