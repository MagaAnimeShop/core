package com.ecomos.coreconfig.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ValidationUtils {

    @Autowired
    protected Validator validator;

    protected <T> void validateField(T dto) {
        var violations = validator.validate(dto);
        if (!violations.isEmpty()) {
            log.info("Violations: {}", violations);
            throw new RuntimeException(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
        }
    }


}
