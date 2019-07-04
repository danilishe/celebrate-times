import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// todo перенести в конфигурируемый файл
public class BeautyPeriodLib {
    public static final Map<ChronoUnit, List<Integer>> celebs = new HashMap<ChronoUnit, List<Integer>>() {{
        put(ChronoUnit.SECONDS, Arrays.asList(10_000_000, 50_000_000, 100_000_000, 1_000_000_000));
        put(ChronoUnit.MINUTES, Arrays.asList(100_000, 500_000, 1_000_000));
        put(ChronoUnit.HOURS, Arrays.asList(10_000, 50_000, 100_000));
        put(ChronoUnit.DAYS, Arrays.asList(1_000, 5_000, 10_000));
        put(ChronoUnit.WEEKS, Arrays.asList(100, 500, 1000));
        put(ChronoUnit.MONTHS, Arrays.asList(10, 50, 100, 500));
        put(ChronoUnit.YEARS, Arrays.asList(5, 10, 50, 100));
    }};
}
