package culturemedia.exception;

public class DuracionNotValidException extends CultureMediaException {

  public DuracionNotValidException() {
    super("Duración no válida");
  }

  public DuracionNotValidException(String titulo, Double duracion) {
    super("Duración no válida para el video: " + titulo + ". Duración proporcionada: " + duracion);
  }
}