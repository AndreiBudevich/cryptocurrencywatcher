package com.cryptocurrencywatcher.util.validation;


import com.cryptocurrencywatcher.error.NotFoundException;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@UtilityClass
public class ValidationUtil {

    public static <T> T checkNotFoundWithStatus(T object) {
        try {
            checkNotFound(object != null);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
        return object;
    }

    public static void checkNotFound(boolean found) {
        if (!found) {
            throw new NotFoundException("Not found entity");
        }
    }
}