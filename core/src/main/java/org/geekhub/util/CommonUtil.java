package org.geekhub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by odahovskiy on 15.05.2015.
 */
public class CommonUtil {

    /**
     * Convert formatted date to date object
     * @param formattedDate date in string format yyyy-MM-dd
     * @return date object or throw parse exception
     * @throws ParseException
     */
    public static Date getFormattedDate(String formattedDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(formattedDate);
    }

}
