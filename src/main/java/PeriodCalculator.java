import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.*;

public class PeriodCalculator {
    Map<ChronoUnit, Set<BeautyDateTime>> result;

    public Map<ChronoUnit, Set<BeautyDateTime>> getRoundTimes(LocalDateTime dateOf, Period period, ChronoUnit... units) {
        return getRoundTimes(dateOf, LocalDateTime.now(), period, units);
    }

    public Map<ChronoUnit, Set<BeautyDateTime>> getRoundTimes(LocalDateTime dateOf, LocalDateTime dateCloseTo, Period period, ChronoUnit... units) {
        if (units == null) {
            units = new ChronoUnit[]{ChronoUnit.DAYS};
        }
        result = new HashMap<>();
        for (ChronoUnit unit : units) {
            result.put(unit, getNearRoundTimes(dateOf, dateCloseTo, period, unit));
        }
        return result;
    }

    /**
     * Находим список дат, находящихся в пределах периода, соответствующих указанному шагу (нужно распилить функцию на два)
     * @param dateOf дата, от которой ищутся круглые "юбилейные" даты и время
     * @param dateCloseTo дата вблизи которой отобразятся имена
     * @param period максимальный период до и после целевой даты
     * @param unit периоды времени, в которых ищутся "юбилеи"
     * @return
     */
    public Set<BeautyDateTime> getNearRoundTimes(LocalDateTime dateOf, LocalDateTime dateCloseTo, Period period, ChronoUnit unit) {
        LocalDateTime minDateTime = dateCloseTo.minus(period);
        LocalDateTime maxDateTime = dateCloseTo.plus(period);
        long periods = unit.between(dateOf, minDateTime);
        int step = getBeautyStep(periods);

        Set<BeautyDateTime> result = new TreeSet<>();
        for (LocalDateTime date = dateOf; date.isBefore(maxDateTime); date.plus(step, unit)) {
            if (date.isAfter(minDateTime))
                result.add(new BeautyDateTime(date, step, unit));
        }
        return result;
    }

    /**
     * Определяем оптимальный шаг "красивых" дат
     */
    private int getBeautyStep(long periods) {
        if (periods <= 10)
            return 5;
        if (periods <= 50)
            return 10;
        if (periods <= 100)
            return 50;
        if (periods <= 500)
            return 100;
        if (periods <= 1_000)
            return 500;
        if (periods <= 5_000)
            return 1_000;
        if (periods <= 10_000)
            return 5_000;
        if (periods <= 50_000)
            return 10_000;
        if (periods <= 100_000)
            return 50_000;
        if (periods <= 500_000)
            return 100_000;
        return 500_000;
    }
}
