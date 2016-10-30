package org.nakonechnyi.domain.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
public class PhoneValidator implements ConstraintValidator<Phone, String>{

    private PhoneNumberUtil phoneUtil;

    @Override
    public void initialize(Phone paramA) {
        phoneUtil = PhoneNumberUtil.getInstance();
    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
        try {
            if (phoneNo.length() == 15) {
                phoneUtil.parse(phoneNo, "UA");
                return true;
            }
            return false;
        } catch (NumberParseException e) {
            return false;
        }
    }
}
