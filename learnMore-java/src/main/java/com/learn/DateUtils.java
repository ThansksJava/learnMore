package com.learn;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
    public static final String EXCEL_EXPANDED_DATE_FORMAT = "yyyy/MM/dd";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static boolean LENIENT_DATE = false;


    protected static final float normalizedJulian(float JD) {
        float f = Math.round(JD + 0.5F) - 0.5F;
        return f;
    }


    public static final String dateIncrease(String isoString, String fmt, int field, int amount) {
        try {
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(
                    "GMT"));
            cal.setTime(stringToDate(isoString, fmt, true));
            cal.add(field, amount);
            return dateToString(cal.getTime(), fmt);
        } catch (Exception ex) {
        }
        return null;
    }

    public static final String roll(String isoString, String fmt, int field, boolean up)
            throws ParseException {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(
                "GMT"));
        cal.setTime(stringToDate(isoString, fmt));
        cal.roll(field, up);
        return dateToString(cal.getTime(), fmt);
    }

    public static final String roll(String isoString, int field, boolean up) throws ParseException {
        return roll(isoString, DATETIME_PATTERN, field, up);
    }

    public static Date stringToDate(String dateText, String format, boolean lenient) {
        if (dateText == null) {
            return null;
        }
        DateFormat df = null;
        try {
            if (format == null) {
                df = new SimpleDateFormat();
            } else {
                df = new SimpleDateFormat(format);
            }

            df.setLenient(false);
            return df.parse(dateText);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date stringToDate(String dateString, String format) {
        return stringToDate(dateString, format, LENIENT_DATE);
    }

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, "yyyy-MM-dd", LENIENT_DATE);
    }

    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        try {
            SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
            sfDate.setLenient(false);
            return sfDate.format(date);
        } catch (Exception e) {
        }
        return null;
    }

    public static String dateToString(Date date) {
        return dateToString(date, "yyyy-MM-dd");
    }

    public static Date getCurrentDateTime() {
        Calendar calNow = Calendar.getInstance();
        Date dtNow = calNow.getTime();
        return dtNow;
    }

    public static String getNowDateTime() {
        Date cur = new Date();
        cur = getCurrentDateTime();
        String dtnow = dateToStringWithTime(cur);
        return dtnow;
    }

    public static String getCurrentDateString(String pattern) {
        return dateToString(getCurrentDateTime(), pattern);
    }

    public static String getCurrentDateString() {
        return dateToString(getCurrentDateTime(), DATETIME_PATTERN);
    }

    public static String dateToStringWithTime(Date date) {
        return dateToString(date, DATETIME_PATTERN);
    }

    public static Date dateIncreaseByDay(Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(
                "GMT"));
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static Date dateIncreaseByMonth(Date date, int mnt) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(
                "GMT"));
        cal.setTime(date);
        cal.add(2, mnt);
        return dateIncreaseByDay(cal.getTime(), -1);
    }

    public static Date dateIncreaseByYear(Date date, int mnt) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(
                "GMT"));
        cal.setTime(date);
        cal.add(1, mnt);

        return dateIncreaseByDay(cal.getTime(), -1);
    }

    public static String dateIncreaseByDay(String date, int days) {
        return dateIncreaseByDay(date, "yyyyMMdd", days);
    }

    public static String dateIncreaseByDay(String date, String fmt, int days) {
        return dateIncrease(date, fmt, 5, days);
    }

    public static int compareDate(String date1, String date2) {
        return stringToDate(date1, "yyyy-MM-dd").compareTo(stringToDate(date2, "yyyy-MM-dd"));
    }

    public static String stringToString(String src, String srcfmt, String desfmt) {
        return dateToString(stringToDate(src, srcfmt), desfmt);
    }

    public static String getTodayString() {
        Date cur = new Date();
        String today = dateToString(cur, "yyyy-MM-dd");
        return today;
    }


    /**
     * 将指定字符串转换成日期
     *
     * @param date        String 日期字符串
     * @param datePattern String 日期格式
     * @return Date
     */
    public static Date getFormatDate(String date, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);
        return sd.parse(date, new ParsePosition(1));
    }


    /**
     * 将指定日期对象转换成格式化字符串
     *
     * @param date        Date XML日期对象
     * @param datePattern String 日期格式
     * @return String
     */
    public static String getFormattedString(Date date, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);

        return sd.format(date);
    }

    /**
     * 将指定XML日期对象转换成格式化字符串
     *
     * @param xmlDate     Date XML日期对象
     * @param datePattern String 日期格式
     * @return String
     */
    public static String getFormattedString(XMLGregorianCalendar xmlDate,
                                            String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);

        Calendar calendar = xmlDate.toGregorianCalendar();

        return sd.format(calendar.getTime());
    }

    /**
     * 将指定XML日期对象转换成日期对象
     *
     * @param xmlDate     Date XML日期对象
//     * @param datePattern String 日期格式
     * @return Date
     */
    public static Date xmlGregorianCalendar2Date(XMLGregorianCalendar xmlDate) {
        return xmlDate.toGregorianCalendar().getTime();
    }

    public static String getThisYear() {
        // 获得当前日期
        Calendar cldCurrent = Calendar.getInstance();
        // 获得年月日
        String strYear = String.valueOf(cldCurrent.get(Calendar.YEAR));
        return strYear;
    }

    public static XMLGregorianCalendar convert2XMLCalendar(Calendar calendar) {
        try {
            DatatypeFactory dtf = DatatypeFactory.newInstance();
            return dtf.newXMLGregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.HOUR),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND),
                    calendar.get(Calendar.MILLISECOND),
                    calendar.get(Calendar.ZONE_OFFSET) / (1000 * 60));

        } catch (DatatypeConfigurationException e) {
            return null;
        }
    }

    // 获取当天时间
    public static java.sql.Timestamp getNowTime(String dateformat) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
        String dateString = dateFormat.format(now);
        SimpleDateFormat sd = new SimpleDateFormat(dateformat);
        Date dateFormt = sd.parse(dateString, new ParsePosition(0));
        java.sql.Timestamp dateTime = new java.sql.Timestamp(dateFormt
                .getTime());

        return dateTime;
        // return hehe;
    }

    // 获取指定时间
    public static java.sql.Timestamp getNowNewTime(String date, String dateformat) {
        //Date   now   =   new   Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);//可以方便地修改日期格式
        dateFormat.parse(date, new ParsePosition(0));

        //  String  dateString= dateFormat.format(date);
        Date dateFormt = dateFormat.parse(date, new ParsePosition(0));
        java.sql.Timestamp dateTime = new java.sql.Timestamp(dateFormt.getTime());


        return dateTime;
        // return hehe;
    }

    /**
//     * @param 含有yyyy-MM-dd'T'hh:mm:ss.SSS格式的时间转换.
     * @return
     */
    public static String getTFormatString(String tdate) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String str = "";
        try {
            Date date = format1.parse(tdate);
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            str = format2.format(date);
        } catch (ParseException e) {
        }
        return str;
    }


    //获取当前时间前2个小时的时间。
    public static String getBefore2HourDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, -2); // 目前時間加3小時
        return df.format(c.getTime());
    }

    //获取当前时间前n天
    public static String getBeforeDayDate(Integer day) {
        return getBeforeDayDate(day, null);
    }

    //获取当前时间前n天
    public static String getBeforeDayDate(Integer day, String dataFormat) {
        SimpleDateFormat df = null;
        if (dataFormat == null) {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            df = new SimpleDateFormat(dataFormat);
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, -day);
        return df.format(c.getTime());
    }

    //获取当前时间前n天
    public static String getBeforeMonthDate(Integer month) {
        return getBeforeDayDate(month, null);
    }

    //获取当前时间前n天
    public static String getBeforeMonthDate(Integer month, String dataFormat) {
        SimpleDateFormat df = null;
        if (dataFormat == null) {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            df = new SimpleDateFormat(dataFormat);
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONDAY, -month);
        return df.format(c.getTime());
    }

    //获取当前时间前n天
    public static String getBeforeYearDate(Integer year) {
        return getBeforeDayDate(year, null);
    }

    //获取当前时间前n天
    public static String getBeforeYearDate(Integer year, String dataFormat) {
        SimpleDateFormat df = null;
        if (dataFormat == null) {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            df = new SimpleDateFormat(dataFormat);
        }
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -year);
        return df.format(c.getTime());
    }


    public static String getStartTime() {
        @SuppressWarnings("unused")
        String ctime = new SimpleDateFormat("yyMMdd").format(new Date());
        Date date = new Date();
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDate();
        long hours = date.getHours();
        return String.valueOf(year) + (month < 10 ? "0" : "") + String.valueOf(month) + (day < 10 ? "0" : "") + String.valueOf(day) + hours;
    }

    /**
     * @param time1 当前时间
     * @param time2 比较时间
     * @return 如果time1比time2大gap分钟，则返回true;
     */
    public static boolean compareDateTime(Date time1, Date time2, int gap) {
        return time1.getTime() - time2.getTime() > gap * 60 * 1000;
    }


    /**
//     * @param 当前时间
     * @return 返回数据库时间;
     */
    public static String getNowDate(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(dateString, pos);
        String temp1 = strtodate.toString();
        String[] temp2 = temp1.split(" ");
        String cruuentTime = temp2[2] + "-" + temp2[1].toUpperCase() + "-"
                + temp2[5].substring(2, 4);

        return cruuentTime;
    }

    /**
     * 将时间去掉秒及毫秒后返回
     *
     * @param date
     * @return
     */
    public static Date getNoSecondDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date d = c.getTime();
        return d;
    }

    /**
     * 获得几天(前)后时间
     *
     * @param nowDate 传入时间
     * @param day     几天后(如果是负,就是几天前)
     * @return
     */
    public static Date getAfterDay(Date nowDate, int day) {
        Date returnDate = new Date();
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(nowDate);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, day);  //设置为后一天
        returnDate = calendar.getTime();   //得到后一天的时间
        return returnDate;
    }

    public static String getMonitorBeforeOneMonth() {
        return "1" + DateUtils.getBeforeMonthDate(1, "yyMMddHHmmssSSS");
    }

    public static String getMonitorBeforeOneYear() {
        return "1" + DateUtils.getBeforeYearDate(1, "yyMMddHHmmssSSS");
    }
    public static String formatWriteTime(String writeTime) throws Exception{
        SimpleDateFormat sf = new SimpleDateFormat("1yyMMddHHmmssSSS");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sf.parse(writeTime));
    }
    public static String getPreMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);

        DateFormat format = new SimpleDateFormat("yyyyMM");
        return format.format(calendar.getTime());
    }


    public static boolean checkDate(String date) {
        String eL = "[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(date);
        boolean b = m.matches();
        if (b) {
            return true;
        } else {
            return false;
        }
    }

    public static String formatToTime(Long time,String dataFormat){
        SimpleDateFormat df = null;
        if (dataFormat == null) {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else {
            df = new SimpleDateFormat(dataFormat);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return  "1"+df.format(calendar.getTime());
    }
    public static void main(String[] args) throws Exception {
//        logger.info("",getStartTime());
//        logger.info("",getBeforeDayDate(1, "yyMMddHHmmssSSS"));
//        logger.info("",getBeforeMonthDate(1, "yyMMddHHmmssSSS"));
//        logger.info("",getBeforeYearDate(1, "yyMMddHHmmssSSS"));
//
//        logger.info("",getPreMonth(new Date()));
        System.out.println(formatWriteTime("1180908132324000"));
    }
}