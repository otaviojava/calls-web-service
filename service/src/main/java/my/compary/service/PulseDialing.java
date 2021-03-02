package my.compary.service;

import java.time.Duration;

public final class PulseDialing {

    private final Call call;

    public PulseDialing(Call call) {
        this.call = call;
    }

    public void pulse() {
        Period period = call.getPeriod();
        Duration duration = period.getCallDuration();
    }
}
