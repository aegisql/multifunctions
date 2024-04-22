package com.aegisql.multifunction;

import java.text.MessageFormat;
import java.util.Objects;

class Utils {

    public static String handleException(Exception e, String format, Object... values) {
        String message = e.getMessage();
        if(message == null || message.isBlank()) {
            message = e.getClass().getSimpleName();
        }
        MessageFormat messageFormat = new MessageFormat(format);
        Object[] formatValues = new Object[values.length+1];
        formatValues[0] = message;
        System.arraycopy(values,0,formatValues,1,values.length);
        return messageFormat.format(formatValues);
    }

    public static <T> T[] validatedArrayCopy(T[] values, String message) {
        Objects.requireNonNull(values,message+": "+"no values available");
        T[] clone = values.clone();
        for(int i = 0; i < clone.length; i++) {
            if(clone[i]==null) {
                throw new RuntimeException(message+": NULL value found at pos "+i);
            }
        }
        return clone;
    }

    public static <T> T arrayValue(int pos, T[]array) {
        if(pos < 0 || pos >= array.length) {
            throw new IndexOutOfBoundsException("Dispatch function returned wrong index: "+pos+"; expected range 0.."+(array.length-1));
        }
        return array[pos];
    }

    public static void requiresNotNullArgs(Object o1, Object o2, Object o3, String unit) {
        Objects.requireNonNull(o1,unit+" dispatch predicate is null");
        Objects.requireNonNull(o2,unit+" first function is null");
        Objects.requireNonNull(o3,unit+" second function is null");
    }

}
