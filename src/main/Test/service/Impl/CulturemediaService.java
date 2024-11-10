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
        MockitoAnnotations.initMocks(this);
        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewsRepository);
    }


    private final List<Video> listVideos() {
        List<Video> videos= List.of(new Video("01", "Título 1", "----", 4.5),
            new Video("02", "Título 2", "----", 5.5),
            new Video("03", "Título 3", "----", 4.4),
            new Video("04", "Título 4", "----", 3.5),
            new Video("05", "Clic 5", "----", 5.7),
            new Video("06", "Clic 6", "----", 5.1));
        return videos;
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(listVideos()).when(videoRepository).findAll();
        List<Video> videos = culturemediaService.findAll();
        assertEquals(6, videos.size());

    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully(){
        doReturn(List.of()).when(videoRepository).findAll();
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.findAll());

    }

    @Test
    void when_FindByTitle_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(listVideos().subList(0, 4)).when(videoRepository).find("Título");
        List<Video> videos2 = culturemediaService.find("Título");
        assertEquals(4, videos2.size());

    }

    @Test
    void when_FindByTitle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {

        doReturn(List.of()).when(videoRepository).find("Clic");
        assertThrows(VideoNotFoundException.class, () -> culturemediaService.find("Hello"));
    }

    @Test
    void when_FindByDuration_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(List.of(new Video("02", "Título 2", "----", 5.5))).when(videoRepository).find(5.4, 5.6);
        List<Video> videos2 = culturemediaService.find(5.4, 5.6);
        assertEquals(1, videos2.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {

        doReturn(List.of()).when(videoRepository).find(5.8,10.2);
        assertThrows(DuracionNotValidException.class, () -> culturemediaService.find(5.8,10.2));
    }
}