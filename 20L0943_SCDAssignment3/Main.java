import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static String main(int date, int month, int year)
    {
        java.time.DayOfWeek dayOfWeek = null;
        try
        {
            LocalDate localDate = LocalDate.of(year, month, date);
            dayOfWeek = localDate.getDayOfWeek();
            System.out.println("Your birthday is on "+dayOfWeek.toString());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return "false";
        }
        return dayOfWeek.toString();

    }
}