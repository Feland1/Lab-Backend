package culturemedia.Service;

import java.util.List;
import culturemedia.model.Video;
import culturemedia.model.View;

public interface CultureMediaService {
    List<Video> listAll();
    Video add(Video video);
    View add(View view);
}
