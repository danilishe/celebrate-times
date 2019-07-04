import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class PeriodCalculator {

    public Map<ChronoUnit, Set<BeautyDateTime>> getRoundTimes(LocalDateTime dateOf, Period period, ChronoUnit... units) {
        return getRoundTimes(dateOf, LocalDateTime.now(), period, units);
    }

    public Map<ChronoUnit, Set<BeautyDateTime>> getRoundTimes(LocalDateTime dateOf, LocalDateTime dateCloseTo, Period period, ChronoUnit... units) {
        if (units == null) {
            units = new ChronoUnit[]{ChronoUnit.DAYS};
        }
        Map<ChronoUnit, Set<BeautyDateTime>> beautyDatesTable = new HashMap<>();
        for (ChronoUnit unit : units) {
            beautyDatesTable.put(unit, getNearRoundTimes(dateOf, dateCloseTo, period, unit));
        }
        return beautyDatesTable;
    }

    public Set<BeautyDateTime> getNearRoundTimes(final LocalDateTime dateOf, final LocalDateTime dateCloseTo, final Period period, final ChronoUnit unit) {
        LocalDateTime minDateTime = dateCloseTo.minus(period);
        LocalDateTime maxDateTime = dateCloseTo.plus(period);

        Set<BeautyDateTime> beautyDates = new TreeSet<>();
        List<Integer> beautySteps = BeautyPeriodLib.celebs.get(unit);
        for (int priority = beautySteps.size(); priority > 0; priority--) {
            int step = beautySteps.get(priority - 1);
            for (LocalDateTime date = dateOf; date.isBefore(maxDateTime); date = date.plus(step, unit)) {
                if (date.isAfter(minDateTime))
                    beautyDates.add(new BeautyDateTime(date,
                            priority,
                            unit, unit.between(dateOf, date)));
            }
        }
        return beautyDates;
    }
}
