/**
 * Copyright (C) 2024, AEGIS DATA SOLUTIONS
 * @author Mikhail Teplitskiy
 * @version 1.0
 */
package com.aegisql.multifunction;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * The type Utils.
 */
public class Utils {

    /**
     * Handle exception string.
     *
     * @param e      the e
     * @param format the format
     * @param values the values
     * @return the string
     */
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

    /**
     * Validated array copy t [ ].
     *
     * @param <T>     the type parameter
     * @param values  the values
     * @param message the message
     * @return the t [ ]
     */
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

    /**
     * Array value t.
     *
     * @param <T>   the type parameter
     * @param pos   the pos
     * @param array the array
     * @return the t
     */
    public static <T> T arrayValue(int pos, T[]array) {
        if(pos < 0 || pos >= array.length) {
            throw new IndexOutOfBoundsException("Dispatch function returned wrong index: "+pos+"; expected range 0.."+(array.length-1));
        }
        return array[pos];
    }

    /**
     * Requires not null args.
     *
     * @param o1   the o 1
     * @param o2   the o 2
     * @param o3   the o 3
     * @param unit the unit
     */
    public static void requiresNotNullArgs(Object o1, Object o2, Object o3, String unit) {
        Objects.requireNonNull(o1,unit+" dispatch predicate is null");
        Objects.requireNonNull(o2,unit+" first function is null");
        Objects.requireNonNull(o3,unit+" second function is null");
    }

}
