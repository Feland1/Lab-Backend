package culturemedia.Service;
import java.util.ArrayList;
import java.util.List;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.CultureMediaService;
import culturemedia.exception.VideoNotFoundException;

public class CultureMediaServiceImpl implements CultureMediaService {
    private List<Video> videos = new ArrayList<>();
    private List<View> views = new ArrayList<>();
    @Override
    public List<Video> listAll() {
        return videos;
    }
    @Override
    public Video add(Video video) {
        videos.add(video);
        return video;
    }
    @Override
    public View add(View view) {
        views.add(view);
        return view;
    }
    public Video findByTitle(String title) throws VideoNotFoundException {
        for (Video video : videos) {
            if (video.getTitle().equals(title)) {
                return video;
            }
        }
        throw new VideoNotFoundException(title);
    }
}

