package my.compary.service;

import java.math.BigDecimal;
import java.time.Duration;

public final class PulseDialing {

    private static final BigDecimal CHEAP = BigDecimal.valueOf(0.05D);
    private static final BigDecimal EXPENSIVE = BigDecimal.valueOf(0.10D);
    public static final BigDecimal MINUTES_PULSE = BigDecimal.valueOf(5L);
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
        if (minutes.compareTo(MINUTES_PULSE) < 0) {
            return minutes.multiply(CHEAP);
        } else {

        }
        return BigDecimal.ZERO;
    }
}
