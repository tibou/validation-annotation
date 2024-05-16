package com.angularspring.validationannotation.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class NotNullIfValidator implements ConstraintValidator<NotNullIf, Object> {
    private String referenceFieldName;

    private String referenceFieldValue;

    private String targetFieldName;

    @Override
    public void initialize(NotNullIf annotation) { // on récupère les valeurs envoyées à l'annotation
        ConstraintValidator.super.initialize(annotation);
        referenceFieldName = annotation.referenceFieldName();
        referenceFieldValue = annotation.referenceFieldValue();
        targetFieldName = annotation.targetFieldName();

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext ctx) { // Cette méthode contient la logique de validation

        if(Objects.isNull(o)){ // On vérifie si l'objet à valider est null, dans ce cas on renvoie true
            return true;
        }

        try {
            /*
            A l'aide de la classe BeanUtils de la librairie commons-beanutils, on récupère la valeur
            actuelle du champs de référence dans l'objet à valider
             */
            String currentReferenceFieldValue = BeanUtils.getProperty(o, referenceFieldName);
            // Ensuite on récupère la valeur du champs cible
            String targetFieldValue = BeanUtils.getProperty(o, targetFieldName);
            /*
            On vérifie si la valeur de référence envoyée dans l'annotation est la même que celle contenue
            dans le champs de référence dans l'objet à valider. Si tel est le cas, et que la valeur du champs
            cible de l'objet à valider est null, alors la contrainte n'est pas respectée et on retourne false
             */
            if(referenceFieldValue.equals(currentReferenceFieldValue) && Objects.isNull(targetFieldValue)){
                ctx.disableDefaultConstraintViolation();
                ctx.buildConstraintViolationWithTemplate("Le champs ne peut pas être null").addPropertyNode(targetFieldName)
                        .addConstraintViolation();
                return false;
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
