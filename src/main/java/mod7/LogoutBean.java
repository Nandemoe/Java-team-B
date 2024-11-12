/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LogoutBean.java
 *
 */

package mod7;

import java.io.Serializable;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutBean implements Serializable {

    public String execute(HttpServletRequest req) {
    	// 遷移先画面の初期値設定
        String page = "/mod7/loginAccount.jsp";

        // セッションオブジェクトからユーザー情報を取得
        HttpSession session = req.getSession(false);
        Account account = (Account)session.getAttribute("account");

        AccountDAO dao = null;
        try {
	        // AccountDAOオブジェクトを生成してユーザー情報を更新
	        dao = new AccountDAO();
	        dao.connect();
	        dao.update(account);

	        // セッションオブジェクトを削除
	        session.invalidate();

        } catch (SQLException e) {
        	e.printStackTrace();

            // リクエストオブジェクトにエラーメッセージを格納
            req.setAttribute("error", "システム管理者に連絡してください。");
            // システムエラー発生時の画面遷移先の設定
            page = "/mod7/errorPage.jsp";
        } finally {
        	try {
                // 接続のクローズ
                dao.close();
            } catch (SQLException e) {
                e.printStackTrace();

                // リクエストオブジェクトにエラーメッセージを格納
                req.setAttribute("error", "システム管理者に連絡してください。");
                // システムエラー発生時の画面遷移先の設定
                page = "/mod7/errorPage.jsp";
            }
        }

        return page;
    }
}
