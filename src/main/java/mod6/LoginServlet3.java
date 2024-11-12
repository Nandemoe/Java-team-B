/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LoginServlet3.java
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

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	//遷移先画面の初期値設定
        String page = "/mod6/list.jsp";

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        // ログイン処理
        // ログインに失敗した場合はリクエストオブジェクトにエラーメッセージを格納し、
        // 遷移先画面をログイン画面に変更する。
        if (!(name.equals("taro") && password.equals("taro"))) {
        	req.setAttribute("error", "ログインに失敗しました。");
        	page = "/mod6/login2.jsp";
        }

        // Memberオブジェクトを生成してセッションオブジェクトに格納
        Member member = new Member(name, password);
        HttpSession session = req.getSession();
        session.setAttribute("member", member);

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
