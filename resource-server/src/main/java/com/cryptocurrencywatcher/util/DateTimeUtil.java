package com.cryptocurrencywatcher.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@UtilityClass
public class DateTimeUtil {
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}