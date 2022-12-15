package appCore.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import apiServlet.DbUtil;

public class InsertToDatabase {
	DbUtil c = new DbUtil();

	public void saveDataToDb(String eventCode, String city, String firstName, String lastName, String requestId,
			String TransactionId, String resMessgeForTrans) {

		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/bsaproject";

		try {

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			String myquery = "INSERT INTO bsa_transactions (EVENT_CODE,requestId,City,FirstName,LastName,response_message,CREATE_DATE,REPLY_DATE,IS_executuig , TRANSACTION_ID)"
					+ " values (?, ?, ?, ?, ?, ?,?,?,?,?)";
			PreparedStatement preparedStmt = conn.prepareStatement(myquery);
			preparedStmt.setString(1, eventCode);
			preparedStmt.setString(2, requestId);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, firstName);
			preparedStmt.setString(5, lastName);
			preparedStmt.setString(6, resMessgeForTrans);
			preparedStmt.setString(7, time());
			preparedStmt.setString(8, c.timeRes());
			preparedStmt.setString(9, "0");
			preparedStmt.setString(10, TransactionId);

			preparedStmt.executeUpdate();
			if (!conn.getAutoCommit())
				conn.commit();
			conn.close();
			updateISExecutuig(resMessgeForTrans, TransactionId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String time() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		String dateTime = dateTimeFormatter.format(localDateTime);
		return dateTime;
	}

	public void updateISExecutuig(String messege, String TransactionId) {
		String myDriver = "com.mysql.cj.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/bsaproject";
		try {

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "root");

			String myQuery = "UPDATE bsaproject.bsa_transactions SET response_message=?, REPLY_DATE = ?  WHERE TRANSACTION_ID = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(myQuery);
			preparedStatement.setString(1, messege);
			preparedStatement.setString(2, LocalDateTime.now().plusSeconds(1L).toString());
			preparedStatement.setString(3, TransactionId);
			preparedStatement.executeUpdate();

			if (!conn.getAutoCommit())
				conn.commit();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
