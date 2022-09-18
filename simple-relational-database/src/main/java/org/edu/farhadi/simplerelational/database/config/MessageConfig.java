package org.edu.farhadi.simplerelational.database.config;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import static org.edu.farhadi.simplerelational.database.utils.MapperHelper.getOrDefault;


@Component
@AllArgsConstructor
public class MessageConfig {
    final MessageSource messageSource;

    public String getMessage(String code, String... args) {
        return getOrDefault(() -> messageSource.getMessage(code, args, LocaleContextHolder.getLocale()), code, NoSuchMessageException.class);
    }
}
