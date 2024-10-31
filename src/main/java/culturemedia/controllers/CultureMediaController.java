package culturemedia.controllers;

import java.util.List;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.impl.CulturemediaServiceImpl;

public class CultureMediaController {

    private final CulturemediaServiceImpl cultureMediaService;

    public CultureMediaController(CulturemediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public List<Video> findAllVideos() throws VideoNotFoundException {
        List<Video> videos = cultureMediaService.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found.");
        }
        return videos;
    }
}