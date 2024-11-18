package org.example.mockito;

import java.time.LocalTime;

public class Time {

    public boolean isMorning() {

        LocalTime morningStart = LocalTime.of(7, 0);
        LocalTime morningEnd = LocalTime.of(11, 0);

        LocalTime timeNow = LocalTime.now();

        return timeNow.isAfter(morningStart) && timeNow.isBefore(morningEnd);
    }
}
