package apiServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DbUtil {

	public void saveDataRequst(String priority, String appointmentNo, String feasibilityId, String TRANSACTION_ID,
			boolean success) {

		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/bsaproject";

		try {

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			String myquery = "INSERT INTO bsa_details (priority , AppointmentNo , FeasibilityId , is_success,TRANSACTION_ID)"
					+ " values (?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(myquery);
			preparedStmt.setString(1, priority);
			preparedStmt.setString(2, appointmentNo);
			preparedStmt.setString(3, feasibilityId);
			preparedStmt.setBoolean(4, success);
			preparedStmt.setString(5, TRANSACTION_ID);
			preparedStmt.executeUpdate();
			if (!conn.getAutoCommit())
				conn.commit();
			conn.close();

			updateISExecutuig(TRANSACTION_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String timeRes() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String dateTime = dateTimeFormatter.format(localDateTime);
		return dateTime;
	}

	public void updateISExecutuig(String TRANSACTION_ID) {
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/bsaproject";
		try {

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			String myQuery = "UPDATE bsaproject.bsa_transactions SET IS_executuig = ?  WHERE TRANSACTION_ID = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(myQuery);
			preparedStatement.setBoolean(1, isExsist(TRANSACTION_ID));
			preparedStatement.setString(2, TRANSACTION_ID);

			preparedStatement.executeUpdate();

			if (!conn.getAutoCommit())
				conn.commit();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isExsist(String TRANSACTION_ID) {
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/bsaproject";
		boolean isEx = false;
		try {

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			String myQuery = "select * from bsaproject.bsa_transactions   WHERE TRANSACTION_ID = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(myQuery);
			preparedStatement.setString(1, TRANSACTION_ID);

			ResultSet rs;

			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				isEx = true;
			}

			if (!conn.getAutoCommit())
				conn.commit();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEx;

	}

}
