package android.dsi32.org.proosoft_project.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public static final long dayDuration = 86400000;
    public static int guessRemainingDays(String taskEndDate) throws ParseException {
        int days=-1;
        if(taskEndDate.equals("false")){
            return -1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = sdf.parse(sdf.format(new Date()));
        Date targetDate = sdf.parse(taskEndDate);
        long difference = targetDate.getTime() - currentDate.getTime();
        if(difference >= 0){
            days = (int)(difference / dayDuration);
        }
        return days;
    }

    public static int guessRemainingDaysSpecial(String taskEndDate) throws ParseException{
        Date date = new Date(taskEndDate);
        System.out.println("******"+date.getTime()+"***");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(date);
        System.out.println("formated date ="+s+"******************************");
        return guessRemainingDays(s);
    }
}
