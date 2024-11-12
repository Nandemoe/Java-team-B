/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LoginAccountServlet2.java
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

@WebServlet("/loginAccount2")
public class LoginAccountServlet2 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	// 遷移先画面の初期値設定
        String page = "/mod7/accountact.jsp";

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        AccountDAO dao = null;

        // ログイン処理
        // ログインに失敗した場合はリクエストオブジェクトにエラーメッセージ
        // を格納し、ログイン画面にフォワード
        if (!(id.equals("101") && password.equals("eclipse"))) {
        	req.setAttribute("error", "IDまたはパスワードが間違っています。");
        	page = "/mod7/loginAccount.jsp";
        } else {
            try {
		        // AccountDAOオブジェクトを生成してユーザー情報を検索
		        dao = new AccountDAO();
		        dao.connect();
		        Account account = dao.select(id);

		        // ユーザー情報をセッションオブジェクトに格納
		        HttpSession session = req.getSession();
		        session.setAttribute("account", account);

	        } catch(SQLException e) {
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
        }

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
