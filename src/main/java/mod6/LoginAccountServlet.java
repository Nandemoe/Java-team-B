/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LoginAccountServlet.java
 *
 */

package mod6;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginAccount")
public class LoginAccountServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	// 遷移先画面の初期値設定
        String page = "/mod6/accountact.jsp";

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        // ログイン処理
        if (!(id.equals("101") && password.equals("eclipse"))) {
        	// ログインに失敗した場合はリクエストオブジェクトにエラーメッセージを
            // 格納し、ログイン画面にフォワード
        	req.setAttribute("error", "IDまたはパスワードが間違っています。");
        	page = "/mod6/loginAccount.jsp";
        } else {
	        // Accountオブジェクトを生成してセッションオブジェクトに格納
	        Account account = new Account(id, "鈴木　道子");
	        HttpSession session = req.getSession();
	        session.setAttribute("account", account);
        }

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
