
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Calender {
public static void printCalendar(int year, int month) {
        int leap_year;
        int dayOfWeek = 1;
        String space = "   ";
        String[] monthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] calDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Calendar cal = new GregorianCalendar(year, month, 1);
        // check leapyear
        if (year % 100 == 0) {
            if (year % 400 == 0) {

                calDays[1] = 29;
            }
        } else if (year % 4 == 0) {
            calDays[1] = 29;
        }
        
        System.out.println("Year: " + year + space + "Month: " + monthName[month] + "\n");
        System.out.println("S   M   T   W   T   F   S\n");
        // print the first day of the month
        // dayCounter is current day of m & dayOfWeek is day of the week,1 is Sunday
        for (int dayCounter = 1; dayCounter <= calDays[month]; dayCounter++) {
            if (dayCounter > 9) {
                space = "  ";
            }
           
            if (dayCounter == 1) {
                while (dayOfWeek != cal.get(Calendar.DAY_OF_WEEK)) {
                    System.out.print(space + " ");
                    dayOfWeek++;
                }
                //print first day m
                System.out.print(dayCounter + space);
                dayOfWeek++;
            } else {
               
                if (dayOfWeek == 8) {
                    System.out.print("\n" + dayCounter + space);
                    dayOfWeek = 2;
                } else {
                    // print current day and increments 
                    System.out.print(dayCounter + space);
                    dayOfWeek++;
                }
            }
        }
        System.out.println("\n");

    }
    public static void main(String[] args) {
        int Year, Month;
        Year = 2005;
        Month = 6;
        printCalendar(Year, Month);
    }
}
