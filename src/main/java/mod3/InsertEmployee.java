/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * InsertEmployee.java
 *
 */

package mod3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {
    public static void main(String args[]) {

        Connection con = null;
        PreparedStatement stmt = null;

        if (args.length != 7) {
            System.out.println("Usage :InsertEmployee <server> <user> "
                    + "<password> <ID> <NAME> <SECTION> <PHONE>");
            System.exit(1);
        }

        String url = "jdbc:mysql://" + args[0] + ":3306/ite"
                + "?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";
        String sql = "insert into EMPLOYEE values(?,?,?,?)";

        try {
            // データベースへの接続
            con = DriverManager.getConnection(url, args[1], args[2]);

            // PreparedStatementの作成
            stmt = con.prepareStatement(sql);

            // INパラメータの設定
            stmt.setInt(1, Integer.parseInt(args[3]));
            stmt.setString(2, args[4]);
            stmt.setString(3, args[5]);
            stmt.setString(4, args[6]);

            System.out.print("処理結果：");

            // SQL文の実行
            stmt.executeUpdate();

            // 処理結果の判定
            System.out.println("以下のレコードを挿入しました。");

        } catch (SQLException e) {
            System.out.println("以下のレコードを挿入できませんでした。");
        } finally {
            System.out.println("ID      ：" + args[3]);
            System.out.println("NAME    ：" + args[4]);
            System.out.println("SECTION ：" + args[5]);
            System.out.println("PHONE   ：" + args[6]);

            try {
                // ステートメントのクローズ
                if (stmt != null) {
                    stmt.close();
                }
                // 接続のクローズ
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}