package com.goutham.leetcode.util;

import java.util.Arrays;



import junitparams.converters.ConversionFailedException;
import junitparams.converters.Converter;

public class IntArrayConverter implements Converter<IntArrayParam, int[]> {

    @Override
    public void initialize(final IntArrayParam annotation) {
    }

    @Override
    public int[] convert(final Object param) throws ConversionFailedException {
        final String str = (String) param;
        final String[] longStrings = str.split(";");
        return Arrays.stream(longStrings).mapToInt(s -> Integer.parseInt(s)).toArray();
    }

}