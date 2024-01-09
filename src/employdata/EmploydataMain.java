package employdata;
import java.sql.*;
public class EmploydataMain {

	public static void main(String[] args) {
		try
		{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database2","root","shubhangi410");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		EmployData obj=new EmployData();

	}

}
