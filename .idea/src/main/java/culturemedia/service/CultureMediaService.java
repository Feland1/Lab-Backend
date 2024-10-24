package culturemedia.Service;

import java.util.List;
import culturemedia.model.Video;
import culturemedia.model.View;

public interface CultureMediaService {
    List<Video> listAll();
    Video save(Video video);
    View save(View view);
}
