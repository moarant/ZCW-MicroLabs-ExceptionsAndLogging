package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberFactory.class);

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
            PhoneNumber [] arrayOfNumbers= new PhoneNumber[phoneNumberCount];

        arrayOfNumbers[0]=createRandomPhoneNumber();
        for(int i=0;i<phoneNumberCount;i++){
            arrayOfNumbers[i]=createRandomPhoneNumber();
        }
        return arrayOfNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {
         int areaCode =RandomNumberFactory.createInteger(200, 999);
         int centralOfficeCode= RandomNumberFactory.createInteger(200,999);
         int phoneLineCode= RandomNumberFactory.createInteger(1000,9999);



        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phone= "("+ areaCode+")-" +centralOfficeCode+"-" +phoneLineCode;

        try {

            return createPhoneNumber(phone);

        } catch (InvalidPhoneNumberFormatException e) {
            logger.info(phone+ "is not a valid phone number");
            //e.printStackTrace();

            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phone = new PhoneNumber(phoneNumberString);
        logger.info("Attempting to create a new PhoneNumber object with a value of"+ phoneNumberString );

        return phone;


    }
}