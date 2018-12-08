package android.dsi32.org.proosoft_project.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public static final long dayDuration = 86400000;
    public static int guessRemainingDays(String taskEndDate) throws ParseException {
        int days=-1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = sdf.parse(sdf.format(new Date()));
        Date targetDate = sdf.parse(taskEndDate);
        long difference = targetDate.getTime() - currentDate.getTime();
        if(difference >= 0){
            days = (int)(difference / dayDuration);
        }
        return days;
    }
}
