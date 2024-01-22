package com.goutham.leetcode.util;

import junitparams.converters.ConversionFailedException;
import junitparams.converters.Converter;

public class StringArrayConverter implements Converter<StringArrayParam, String[]>  {

	@Override
    public void initialize(final StringArrayParam annotation) {
    }

    @Override
    public String[] convert(final Object param) throws ConversionFailedException {
        final String str = (String) param;
        final String[] longStrings = str.split(";");
        return longStrings;
    }
}
