/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TestConnection.java
 *
 */

package mod3;

import java.sql.SQLException;

public class TestConnection {
	public static void main(String args[]) {

		if (args.length != 3) {
			System.out
					.println("Usage : TestGetEmployee <server> <user> <password>");
			System.exit(1);
		}

		EmployeeDAO dao = new EmployeeDAO(args[0], args[1], args[2]);

		try {

			dao.connect();
			System.out.println("接続完了");
			dao.close();
			System.out.println("クローズ完了");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
