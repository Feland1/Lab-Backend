package culturemedia.exception;

public class VideoNotFoundException extends CultureMediaException {

    public VideoNotFoundException() {
        super("Video no encontrado");
    }

    public VideoNotFoundException(String titulo) {
        super("Video no encontrado: " + titulo);
    }
}
