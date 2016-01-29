package com.hive.ext.example;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

/**
 * Created by shona on 1/29/16.
 */
public class TestJODA {

    private static final DateTimeFormatter DATE_FORMATTER =
            new DateTimeFormatterBuilder()
                    .append(null, new DateTimeParser[]{
                            DateTimeFormat.forPattern("yyyy/MM/dd").getParser(),
                            DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
                            DateTimeFormat.forPattern("MM/dd/yyyy").getParser(),
                            DateTimeFormat.forPattern("dd/MM/yyyy").getParser()})
                    .toFormatter();

    public static void main(String[] args) {

        System.out.println(DATE_FORMATTER.parseLocalDate("2015/12/25"));
        System.out.println(DATE_FORMATTER.parseLocalDate("2015-12-25"));
        System.out.println(DATE_FORMATTER.parseLocalDate("15/12/2016"));
        System.out.println(DATE_FORMATTER.parseLocalDate("14/08/2016"));


    }
}
