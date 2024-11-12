/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LogoutServlet2.java
 *
 */

package mod7;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout2")
public class LogoutServlet2 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	// 遷移先画面の初期値設定
        String page = "/mod7/logout.jsp";

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

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
