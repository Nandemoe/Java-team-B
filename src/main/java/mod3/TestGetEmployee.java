/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TestGetEmployee.java
 *
 */

package mod3;

import java.sql.SQLException;

public class TestGetEmployee {
	public static void main(String args[]) {

		if (args.length != 4) {
			System.out
					.println("Usage : java TestGetEmployee <server> <user> <password> <ID>");
			System.exit(1);
		}

		EmployeeDAO dao = new EmployeeDAO(args[0], args[1], args[2]);

		try {

			dao.connect();
			Employee emp = dao.getEmployee(Integer.parseInt(args[3]));
			if (emp != null) {
				emp.print();
			} else {
				System.out.println("該当者が見つかりません。 id:" + args[3]);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
