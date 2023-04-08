import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
 public static void main(String[] args) throws ParseException {
	 String date = "26-02-1999";
	 
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");	 
	 Date newDate = sdf.parse(date);
	
	 String test = sdf.format(newDate);
	 
	 System.out.println(date);
	// System.out.println(newDate);
	 System.out.println(test);
 
 }
}
