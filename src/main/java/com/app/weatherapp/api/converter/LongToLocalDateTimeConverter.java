package com.app.weatherapp.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class LongToLocalDateTimeConverter extends StdConverter<Long, LocalDateTime> {

    @Override
    public LocalDateTime convert(Long aLong) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(aLong), TimeZone.getDefault().toZoneId());
    }
}
