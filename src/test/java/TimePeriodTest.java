import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

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
}
