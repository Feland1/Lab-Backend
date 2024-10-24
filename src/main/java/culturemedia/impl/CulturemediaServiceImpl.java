package culturemedia.impl;

import java.util.List;

import culturemedia.model.View;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CultureMediaService;

public class CulturemediaServiceImpl implements CultureMediaService {
    private VideoRepository videos;
    private ViewsRepository views;

    @Override
    public List<Video> listAll() {
        return List.of();
    }

    @Override
    public List<Video> findAll() {
        return videos.findAll();
    }

    @Override
    public Video save(Video save){
        videos.save(save);
        return save;
    }

    @Override
    public View save(View save){
        views.add(save);
        return save;
    }
}