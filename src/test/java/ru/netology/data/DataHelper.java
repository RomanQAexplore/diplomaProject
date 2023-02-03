package ru.netology.data;

import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
public class DataHelper {
    public static CardValidInformationModel getValidApprovedCardData() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getValidDeclinedCardData() {
        return new CardValidInformationModel("4444 4444 4444 4442", "08", "24", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getEmptyCardNumber() {
        return new CardValidInformationModel("", "08", "24", "IVANOV IVAN", "111");
    }

//    FIELD NUMBER

    public static CardValidInformationModel getInvalidCardNumberWith15Symbols() {
        return new CardValidInformationModel("4444 4444 4444 444", "08", "24", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getInvalidCardNumberAllZero() {
        return new CardValidInformationModel("0000 0000 0000 0000", "08", "24", "IVANOV IVAN", "000");
    }

    public static CardValidInformationModel getEmptyMonth() {
        return new CardValidInformationModel("4444 4444 4444 4441", "", "24", "IVANOV IVAN", "111");
    }


//    FIELD MONTH

    public static CardValidInformationModel getInvalidFormatMonthIsZeroZero() {
        return new CardValidInformationModel("4444 4444 4444 4441", "00", "24", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getInvalidFormatMonthIsIrrelevant() {
        return new CardValidInformationModel("4444 4444 4444 4441", "13", "24", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getInvalidFormatMonthIsOneDigit() {
        return new CardValidInformationModel("4444 4444 4444 4441", "8", "24", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getEmptyYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "", "IVANOV IVAN", "111");
    }

//    FIELD YEAR

    public static CardValidInformationModel getEarlyYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "20", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getFutureYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "50", "IVANOV IVAN", "111");
    }

    public static CardValidInformationModel getEmptyOwner() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "", "111");
    }

//    FIELD OWNER

    public static CardValidInformationModel getInvalidOwnerWithCyrillic() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "Иванов Иван", "111");
    }

    public static CardValidInformationModel getInvalidOwnerWithDigits() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "12345", "111");
    }

    public static CardValidInformationModel getEmptyCVV() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "IVANOV IVAN", "");
    }


//    FIELD CVV

    public static CardValidInformationModel getInvalidCVVWith1Digit() {
        return new CardValidInformationModel("4444 4444 4444 4441", "12", "23", "IVANOV IVAN", "1");
    }

    public static CardValidInformationModel getInvalidCVVWith2Digits() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "IVANOV IVAN", "11");
    }

    public static CardValidInformationModel getInvalidCVVWithAllZero() {
        return new CardValidInformationModel("4444 4444 4444 4441", "08", "24", "IVANOV IVAN", "000");
    }

    @Value
    public static class CardValidInformationModel {
        String number;
        String month;
        String year;
        String owner;
        String cvv;
    }
}


