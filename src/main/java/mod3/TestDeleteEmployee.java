/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TestDeleteEmployee.java
 *
 */

package mod3;

import java.sql.SQLException;

public class TestDeleteEmployee {
	public static void main(String args[]) {

		if (args.length != 4) {
			System.out
					.println("Usage : java TestDeleteEmployee <server> <user> <password> <ID>");
			System.exit(1);
		}

		EmployeeDAO dao = new EmployeeDAO(args[0], args[1], args[2]);

		try {

			dao.connect();
			dao.deleteEmployee(Integer.parseInt(args[3]));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String param[] = {args[0], args[1], args[2]};
			TestGetAllEmployee.main(param);
		}
	}
}