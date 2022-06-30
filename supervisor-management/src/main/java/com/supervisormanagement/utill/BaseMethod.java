package com.supervisormanagement.utill;

import org.springframework.stereotype.Component;

@Component
public class BaseMethod {

    public static boolean isNumeric(String value) {


        if (value == null || value.isEmpty()) {
            return false;
        }

        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
//            System.out.println("This is not number");
        }
        return false;
    }
}
