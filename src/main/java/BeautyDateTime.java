import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Value
public class BeautyDateTime implements Comparable<BeautyDateTime>, Serializable {
    private final LocalDateTime dateTime;
    private final int priority;
    private final ChronoUnit unit;
    private final DateTimeFormatter formatter;
    private final long steps;

    public BeautyDateTime(LocalDateTime dateTime, int priority, ChronoUnit unit, long steps) {
        this.dateTime = dateTime;
        this.priority = priority;
        this.unit = unit;
        formatter = unit.compareTo(ChronoUnit.HOURS) > 0
                ? DateTimeFormatter.ofPattern("dd.MM.yyyy") // for celebras greater then hour
                : DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"); // for celebras less then day
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeautyDateTime that = (BeautyDateTime) o;
        return dateTime.equals(that.dateTime) &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, unit, steps);
    }

    @Override
    public int compareTo(BeautyDateTime o) {
        return this.dateTime.compareTo(o.dateTime);
    }

    @Override
    public String toString() {
        return String.format("[%d] %,d %s at %s", priority, steps, unit, dateTime.format(formatter));
    }
}
