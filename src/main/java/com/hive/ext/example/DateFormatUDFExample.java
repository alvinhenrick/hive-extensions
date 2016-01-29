package com.hive.ext.example;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

import java.text.SimpleDateFormat;

/**
 * Created by shona on 1/29/16.
 */
public class DateFormatUDFExample extends UDF {

    private static final DateTimeFormatter DATE_FORMATTER =
            new DateTimeFormatterBuilder()
                    .append(null, new DateTimeParser[]{
                            DateTimeFormat.forPattern("dd-MMM-yy").getParser(),
                            DateTimeFormat.forPattern("dd-MMM-yyyy").getParser(),
                            DateTimeFormat.forPattern("dd/MM/yyyy").getParser(),
                            DateTimeFormat.forPattern("d.MMM.yy").getParser(),
                            DateTimeFormat.forPattern("MMM:dd:yy").getParser(),
                            DateTimeFormat.forPattern("yyyy-MMM-d").getParser(),
                            DateTimeFormat.forPattern("dd-MM-yy").getParser(),
                            DateTimeFormat.forPattern("dd-MMM-yyyy").getParser(),
                            DateTimeFormat.forPattern("dd-MMM-yy").getParser(),
                            DateTimeFormat.forPattern("dd-MM-yy").getParser()
                    }).toFormatter();

    public Text evaluate(Text input) {
        if (input == null) return null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            return new Text(formatter.format(DATE_FORMATTER.parseLocalDate(input.toString()).toDate()));

        } catch (Exception ex) {
            return null;
        }
    }
}
