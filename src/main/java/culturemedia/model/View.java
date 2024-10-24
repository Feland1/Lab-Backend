package culturemedia.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record View(String userFullName, LocalDateTime startPlayingTime, Integer age, Video video) {
}
