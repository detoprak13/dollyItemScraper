import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		DBConnect.getInstance().connect();

		Java11HttpClient obj = new Java11HttpClient();

//		System.out.println("Send Http GET request");
//		obj.sendGet();

		System.out.println("Send Http POST request");
		try {
			obj.sendPost("chair");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
