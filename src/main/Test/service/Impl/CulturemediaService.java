package service.Impl;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.impl.CulturemediaServiceImpl;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturemediaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;


class CulturemediaServiceImplTest {


    @Mock
    private VideoRepository videoRepository;
    private ViewsRepository viewsRepository;


    private CulturemediaService culturemediaService;

    @BeforeEach
    void init() {

        MockitoAnnotations.openMocks(this);
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewsRepository);
    }


    private final List<Video>Videos = List.of(
            new Video("01", "Título 1", "----", 4.5),
            new Video("02", "Título 2", "----", 5.5),
            new Video("03", "Título 3", "----", 4.4),
            new Video("04", "Título 4", "----", 3.5),
            new Video("05", "Clic 5", "----", 5.7),
            new Video("06", "Clic 6", "----", 5.1)
    );

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        mock_findAll_videos_returned_successfully();


        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewsRepository);
        }

        void saveVideos(){
        List<Video>Videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)
        );

        for (Video video :Videos) {
            culturemediaService.save(video);
        }
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        saveVideos();


        List<Video> videos = culturemediaService.findAll();
        assertEquals(6, videos.size());
    }
    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findAll());
    }
    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() throws VideoNotFoundException {

        mock_FindByTitle_videos_returned_successfully("Clic");

        saveVideos();


        List<Video> videos = culturemediaService.find( "Clic" );
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.find("Clic"));
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() throws VideoNotFoundException {

        mock_FindByDuration_videos_returned_successfully( 4.5, 5.5 );

        saveVideos();


        List<Video> videos = culturemediaService.find( 4.5, 5.5 );
        assertEquals(3, videos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws  DuracionNotValidException {
        assertThrows(DuracionNotValidException.class, () -> culturemediaService.find( 4.5, 5.5 ));
    }


    private void mock_findAll_videos_returned_successfully() {
        doReturn(Videos)
                .when(videoRepository)
                .findAll();
    }

    private void mock_FindByTitle_videos_returned_successfully(String title) {
        List<Video> filteredVideos = new ArrayList<>();
        for ( Video video : Videos ) {
            if(video.title().contains(title)){
                filteredVideos.add(video);
            }
        }
        doReturn(filteredVideos)
                .when(videoRepository)
                .find(title);
    }

    private void mock_FindByDuration_videos_returned_successfully(Double fromDuration, Double toDuration) {
        List<Video> filteredVideos = new ArrayList<>();
        for ( Video video : Videos ) {
            if(video.duration() >= fromDuration && video.duration() <= toDuration){
                filteredVideos.add(video);
            }
        }
        doReturn(filteredVideos)
                .when(videoRepository)
                .find(fromDuration, toDuration);
    }
}

}

