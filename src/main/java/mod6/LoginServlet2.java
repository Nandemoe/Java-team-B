/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LoginServlet2.java
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

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	// 遷移先画面の初期値設定
        String page = "/mod6/loginResult.jsp";

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        // ログイン処理
        // ログインに失敗した場合はリクエストオブジェクトにエラーメッセージを格納し、
        // 遷移先画面をログイン画面に変更する。
        if (!(name.equals("taro") && password.equals("taro"))) {
        	req.setAttribute("error", "ログインに失敗しました。");
        	page = "/mod6/login.jsp";
        }

        // セッションオブジェクトにユーザー名を格納
        HttpSession session = req.getSession();
        session.setAttribute("name", name);

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
