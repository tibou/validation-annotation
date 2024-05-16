package com.angularspring.validationannotation.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = NotNullIfValidator.class)
public @interface NotNullIf {

    String referenceFieldName(); // nom du champs de référence

    String referenceFieldValue(); // valeur du champs de référence

    String targetFieldName(); // nom du champs cible à valider

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotNullIf[] value(); // Peut contenir un tableau de @NotNullIf
    }
}
