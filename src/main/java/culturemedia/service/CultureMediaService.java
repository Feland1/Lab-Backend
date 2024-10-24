package culturemedia.service;

import java.util.List;
import culturemedia.model.Video;
import culturemedia.model.View;

public interface CultureMediaService {
    List<Video> listAll();

    List<Video> findAll();

    Video save(Video video);
    View save(View view);
}
