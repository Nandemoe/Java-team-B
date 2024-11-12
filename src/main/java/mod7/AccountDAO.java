/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * AccountDAO.java
 *
 */

package mod7;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO implements Serializable {

	private Connection con;  // 接続オブジェクト
    private static final String URL = "jdbc:mysql://localhost:3306/ite"
            + "?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";
    private static final String USER = "mysql";     // ユーザー名
    private static final String PASSWORD = "mysql"; // パスワード

    private String sqlselect = "select * from ACCOUNT where ID=?";
    private String sqlupdate = "update ACCOUNT set BALANCE=? where ID=?";

    // 接続
    public void connect() throws SQLException {
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 接続のクローズ
    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public Account select(String id) throws SQLException {
        Account account = null;

        // PreparedStatementの作成（検索）
        PreparedStatement stmt = con.prepareStatement(sqlselect);
        stmt.setString(1, id);

        ResultSet res = stmt.executeQuery();




        try {
            if (res.next()) {
                account = new Account();
                account.setId(id);
                account.setName(res.getString("name"));
                account.setBalance(res.getInt("balance"));
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return account;
    }

    public void update(Account account) throws SQLException {
        // PreparedStatementの作成（更新）
        PreparedStatement stmt = con.prepareStatement(sqlupdate);
        stmt.setInt(1, account.getBalance());
        stmt.setString(2, account.getId());

        int ret = stmt.executeUpdate();
        if (ret != 1) {
            throw new SQLException("更新に失敗しました");
        }
    }
}