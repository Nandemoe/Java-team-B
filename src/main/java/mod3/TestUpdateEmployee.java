/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TestUpdateEmployee.java
 *
 */

package mod3;

import java.sql.SQLException;

public class TestUpdateEmployee {
	public static void main(String args[]) {

		if (args.length != 7) {
			System.out.println("Usage : java TestUpdateEmployee <server> "
					+ "<user> <password> <ID> <NAME> <SECTION> <PHONE>");
			System.exit(1);
		}

		EmployeeDAO dao = new EmployeeDAO(args[0], args[1], args[2]);

		try {

			dao.connect();
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(args[3]));
			emp.setName(args[4]);
			emp.setSection(args[5]);
			emp.setPhone(args[6]);

			dao.updateEmployee(emp);

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
