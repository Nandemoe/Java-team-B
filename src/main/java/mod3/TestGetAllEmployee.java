/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TestGetAllEmployee.java
 *
 */

package mod3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class TestGetAllEmployee {
	public static void main(String args[]) {

		if (args.length != 3) {
			System.out
					.println("Usage : TestGetAllEmployee <server> <user> <password>");
			System.exit(1);
		}

		EmployeeDAO dao = new EmployeeDAO(args[0], args[1], args[2]);

		try {

			dao.connect();
			ArrayList<Employee> list = dao.getAllEmployee();
			Iterator<Employee> iter = list.iterator();
			while (iter.hasNext()) {
				Employee emp = iter.next();
				emp.print();
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
