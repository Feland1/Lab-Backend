package culturemedia.service;

import java.util.List;
import culturemedia.model.Video;
import culturemedia.model.View;

public interface CulturemediaService {
    List<Video> findAll();
    Video save(Video video);
    View save(View view);
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
}