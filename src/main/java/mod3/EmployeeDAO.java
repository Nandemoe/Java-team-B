/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * EmployeeDAO.java
 *
 */

package mod3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {

    private Connection con;  // 接続オブジェクト
    private String server;   // DBサーバ名
    private String user;     // ユーザー名
    private String password; // パスワード

    // コンストラクタ
    public EmployeeDAO(String server, String user, String password) {
        this.server = server;
        this.user = user;
        this.password = password;
    }

    // 接続
    public void connect() throws SQLException {
        String url = "jdbc:mysql://" + server + ":3306/ite"
        + "?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";

        con = DriverManager.getConnection(url, user, password);
    }

    // 接続のクローズ
    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    // 1件検索
    public Employee getEmployee(int id) throws SQLException {
        ResultSet res = null;
        PreparedStatement stmt = null;
        Employee emp = null;
        String sql = "select * from EMPLOYEE where ID=?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            res = stmt.executeQuery();
            if (res.next()) {
                emp = new Employee();
                emp.setId(res.getInt(1));
                emp.setName(res.getString(2));
                emp.setSection(res.getString(3));
                emp.setPhone(res.getString(4));
            }
        } finally {
            if (res != null) {
                res.close();
            }

            if (stmt != null) {
                stmt.close();
            }
        }
        return emp;
    }

    // 全件検索
    public ArrayList<Employee> getAllEmployee() throws SQLException {
        ResultSet res = null;
        PreparedStatement stmt = null;
        ArrayList<Employee> list = new ArrayList<Employee>();
        Employee emp = null;
        String sql = "select * from EMPLOYEE";

        try {
            stmt = con.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {
                emp = new Employee();
                emp.setId(res.getInt(1));
                emp.setName(res.getString(2));
                emp.setSection(res.getString(3));
                emp.setPhone(res.getString(4));
                list.add(emp);
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }        
        return list;        
    }

    /* オプションで使用するメソッド */
    // レコードの挿入
    public void insertEmployee(Employee emp) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "insert into EMPLOYEE values(?,?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getSection());
            stmt.setString(4, emp.getPhone());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }        
    }

    // レコードの更新
    public void updateEmployee(Employee emp) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "update EMPLOYEE set NAME=?,SECTION=?,PHONE=? where ID=?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getSection());
            stmt.setString(3, emp.getPhone());
            stmt.setInt(4, emp.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }        
    }

    // レコードの削除
    public void deleteEmployee(int id) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "delete from EMPLOYEE where ID=?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}