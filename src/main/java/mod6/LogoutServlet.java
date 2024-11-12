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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	// 遷移先画面の初期値設定
        String page = "/mod6/logout.jsp";

        // セッションオブジェクトを削除
        HttpSession session = req.getSession(false);
        session.invalidate();

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
