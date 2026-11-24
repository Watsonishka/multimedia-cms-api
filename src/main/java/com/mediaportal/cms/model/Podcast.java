package com.mediaportal.cms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Podcast {
    private UUID id;
    private String header;
    private List<Episode> episodes = new ArrayList<>();
}
