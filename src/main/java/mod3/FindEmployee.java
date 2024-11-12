/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * FindEmployee.java
 *
 */

package mod3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindEmployee {
    public static void main(String args[]) {

        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        if (args.length != 4) {
            System.out.println("Usage : FindEmployee "
                    + "<server> <user> <password> <ID>");
            System.exit(1);
        }

        String url = "jdbc:mysql://" + args[0] + ":3306/ite"
        + "?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";

        String sql = "select ID,NAME,SECTION,PHONE from EMPLOYEE where ID="
                + args[3];

        try {
        	// データベースへの接続
            con = DriverManager.getConnection(url, args[1], args[2]);

            // Statementの作成
            stmt = con.createStatement();

            // SQL文の実行
            res = stmt.executeQuery(sql);
            System.out.print("検索結果：");

            // 結果セットから情報を取り出す
            if (res.next()) {
                System.out.println("該当者が見つかりました。");
                System.out.println("ID      ：" + res.getInt(1));
                System.out.println("NAME    ：" + res.getString(2));
                System.out.println("SECTION ：" + res.getString(3));
                System.out.println("PHONE   ：" + res.getString(4));
            } else {
                System.out.print("該当者が見つかりません。");
                System.out.println("ID=" + args[3]);
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 結果セットのクローズ
                if (res != null) {
                    res.close();
                }
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