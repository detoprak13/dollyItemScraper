import Entity.Word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnect {
	private static DBConnect dbConnect = null;
	private static Connection conn = null;
	private final String url = "jdbc:postgresql://octovan-auxiliary.cx8030ikyuso.eu-central-1.rds.amazonaws.com:5432/aux";
	private final String user = "octovan";
	private final String password = "Octovan..2020";

	public static DBConnect getInstance() {
		if (dbConnect == null) {
			dbConnect = new DBConnect();
		}
		return dbConnect;
	}

	public static void insertWord(ArrayList<Word> wordList) {
		Connection connection = DBConnect.getInstance().connect();

		String SQL = "INSERT INTO words(name) "
				+ "VALUES(?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			for (Word word : wordList) {
				preparedStatement.setString(1, word.getName());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException throwable) {
			throwable.printStackTrace();
		}
	}

	/**
	 * Connect to the PostgreSQL database
	 *
	 * @return a Connection object
	 */
	public Connection connect() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Connected to the PostgreSQL server successfully.");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return conn;
	}
}
