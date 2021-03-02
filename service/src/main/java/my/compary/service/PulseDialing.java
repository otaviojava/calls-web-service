package my.compary.service;

import java.math.BigDecimal;
import java.time.Duration;

public final class PulseDialing {

    private static final BigDecimal CHEAP_PRICE = BigDecimal.valueOf(0.05D);
    private static final BigDecimal EXPENSIVE_PRICE = BigDecimal.valueOf(0.10D);

    private static final BigDecimal EXPENSIVE_PULSE = BigDecimal.valueOf(5L);
    private static final BigDecimal CHEAP_MINUTES = BigDecimal.valueOf(4L);
    private static final BigDecimal CHEAP_PULSE = CHEAP_MINUTES.multiply(CHEAP_PRICE);

    private final Call call;

    public PulseDialing(Call call) {
        this.call = call;
    }

    public BigDecimal pulse() {
        BigDecimal pulse = getValue();
        call.setCost(pulse);
        return pulse;
    }

    private BigDecimal getValue() {
        if (TypeCall.INBOUND.equals(call.getType())) {
            return BigDecimal.ZERO;
        }
        Period period = call.getPeriod();
        Duration duration = period.getCallDuration();
        BigDecimal minutes = BigDecimal.valueOf(duration.toMinutes());
        if (minutes.compareTo(EXPENSIVE_PULSE) < 0) {
            return minutes.multiply(CHEAP_PRICE);
        } else {
            BigDecimal minutesLeft = minutes.subtract(CHEAP_MINUTES);
            BigDecimal expensivePrice = minutesLeft.multiply(EXPENSIVE_PRICE);
            return CHEAP_PULSE.add(expensivePrice);
        }
    }
}
