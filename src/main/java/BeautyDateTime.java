import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Value
@AllArgsConstructor
public class BeautyDateTime {
    private LocalDateTime dateTime;
    private int step;
    private ChronoUnit unit;
}
