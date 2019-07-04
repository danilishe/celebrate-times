import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;

import static java.time.temporal.ChronoUnit.*;

public class TimePeriodTest {
    @Test
    public void testPeriod() {
        Assert.assertEquals(12L,
                ChronoUnit.MONTHS.between(
                        LocalDate.of(2011, Month.FEBRUARY, 28),
                        LocalDate.of(2012, Month.FEBRUARY, 29)
                ));
        Assert.assertEquals(15L,
                ChronoUnit.MONTHS.between(
                        LocalDate.of(2011, Month.FEBRUARY, 28),
                        LocalDate.of(2012, Month.MAY, 31)
                ));
    }

    @Test
    public void getDates() {
        Map<ChronoUnit, Set<BeautyDateTime>> roundTimes = new PeriodCalculator().getRoundTimes(LocalDateTime.of(1983, Month.FEBRUARY, 21, 9, 0),
                Period.ofMonths(6),
                YEARS, MONTHS, WEEKS, DAYS, HOURS, MINUTES, SECONDS);
        System.out.println(roundTimes);
    }
}
