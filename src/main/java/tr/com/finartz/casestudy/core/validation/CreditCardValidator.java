package tr.com.finartz.casestudy.core.validation;

import tr.com.finartz.casestudy.core.util.CreditCardUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreditCardValidator implements ConstraintValidator<CreditCard, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return CreditCardUtil.checkCreditCardStringIsValid(s);
    }

}
