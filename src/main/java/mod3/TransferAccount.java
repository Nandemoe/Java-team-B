/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * TransferAccount.java
 *
 */

package mod3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferAccount {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        int count1 = 0;
        int count2 = 0;

        if (args.length != 6) {
            System.out.println("Usage : java UseTransaction <server> <user> "
                    + "<password> <FROM_ID> <TO_ID> <MONEY>");
            System.exit(1);
        }

        String url = "jdbc:mysql://" + args[0] + ":3306/ite"
                + "?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8";
        String sql1 = "update ACCOUNT set BALANCE = BALANCE + ? where ID=? ";
        String sql2 = "select * from ACCOUNT where ID=?";

        int from_id = Integer.parseInt(args[3]);
        int to_id = Integer.parseInt(args[4]);
        int money = Integer.parseInt(args[5]);

        try {

            // データベースへの接続
            con = DriverManager.getConnection(url, args[1], args[2]);

            // 自動コミットモードの解除
            con.setAutoCommit(false);


            System.out.println("【処理前データ】");
            stmt = con.prepareStatement(sql2);

            // 振込元
            stmt.setInt(1,from_id);
            res = stmt.executeQuery();
            System.out.println("<振込元>");
            int balance=-1;
            if (res.next()) {
                balance = res.getInt(3);
                System.out.println("ID      : " + res.getInt(1));
                System.out.println("NAME    : " + res.getString(2));
                System.out.println("BALANCE : " + balance);
                System.out.println();
            } else {
                throw new AccountException("振込元の指定に誤りがあります。");
            }

            //振込先
            stmt.setInt(1,to_id);
            res = stmt.executeQuery();
            System.out.println("<振込先>");
            if (res.next()) {
                System.out.println("ID      : " + res.getInt(1));
                System.out.println("NAME    : " + res.getString(2));
                System.out.println("BALANCE : " + res.getInt(3));
                System.out.println();
            } else {
                throw new AccountException("振込先の指定に誤りがあります。");
            }

            //振込元の残高がマイナスになったらAccountExceptionをスロー
            if (balance - money < 0) {
                throw new AccountException("振込元の残高が不足しています。");
            }

            // PreparedStatementの作成（更新）
            stmt = con.prepareStatement(sql1);

            // INパラメータに値を設定（振込元）
            stmt.setInt(1, -money);
            stmt.setInt(2, from_id);

            // 更新系SQLの実行（振込元）
            count1 = stmt.executeUpdate();

            // INパラメータに値を設定（振込先）
            stmt.setInt(1, money);
            stmt.setInt(2, to_id);

            // 更新系SQLの実行（振込先）
            count2 = stmt.executeUpdate();

            if (count1 == 1 && count2 == 1) {
                System.out.println("振り込みを行いました。");
                System.out.println();
            } else {
                throw new AccountException("振り込みに失敗しました。");
            }

            System.out.println("【処理後データ】");
            stmt = con.prepareStatement(sql2);
            // 振込元
            stmt.setInt(1,from_id);
            res = stmt.executeQuery();
            System.out.println("<振込元>");
            if (res.next()) {
                System.out.println("ID      : " + res.getInt(1));
                System.out.println("NAME    : " + res.getString(2));
                System.out.println("BALANCE : " + res.getInt(3));
                System.out.println();
            }

            //振込先
            stmt.setInt(1,to_id);
            res = stmt.executeQuery();
            System.out.println("<振込先>");
            if (res.next()) {
                System.out.println("ID      : " + res.getInt(1));
                System.out.println("NAME    : " + res.getString(2));
                System.out.println("BALANCE : " + res.getInt(3));
                System.out.println();
            }

            //コミット
            con.commit();
            System.out.println("振り込みが完了しました。");

        } catch (SQLException e) {
            System.out.println("システムエラーが発生しました。");
            try{
                if(con != null){
                    System.out.println();
                    System.out.println("※処理の途中でエラーが発生したため、");
                    System.out.println("振込元、振込先のデータを元に戻します");
                    //ロールバック
                    con.rollback();
                }
                
            }catch(SQLException se){
                se.printStackTrace();
                
            }
            
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            try{
                if(con != null){
                    System.out.println();
                    System.out.println("※処理の途中でエラーが発生したため、");
                    System.out.println("振込元、振込先のデータを元に戻します");
                    //ロールバック
                    con.rollback();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
            
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
