/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TestInsertEmployee.java
 *
 */

package mod3;

import java.sql.SQLException;

public class TestInsertEmployee {
	public static void main(String args[]) {

		if (args.length != 7) {
			System.out.println("Usage :TestInsertEmployee <server> <user> "
					+ "<password> <ID> <NAME> <SECTION> <PHONE>");
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

			dao.insertEmployee(emp);

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
