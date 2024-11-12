/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * ControlServlet.java
 *
 */

package mod7;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/control")
public class ControlServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
             throws ServletException, IOException {
        String next_page = "errorPage.jsp";
        // エンコーディング方式の指定
        req.setCharacterEncoding("UTF-8");

        // hiddenが指定されたinputタグのvalue属性の値を取得
        String command_id = req.getParameter("command_id");

        // どの画面から呼び出されたかの判別
        switch (command_id) {
            case "0" : // ログインから入出金画面
                // 業務処理
                LoginAccountBean lab = new LoginAccountBean();
                next_page = lab.execute(req);
                break;
            case "1" : // 残高照会画面
                // 業務処理
            	AccountBean ab = new AccountBean();
            	next_page = ab.execute(req);
                break;
            case "2" : // ログアウト画面
                // 業務処理
                LogoutBean lb = new LogoutBean();
                next_page = lb.execute(req);
                break;
            default : // どれにも当てはまらない場合は入出金画面
                next_page = "/mod7/accountact.jsp";
        }

        // 出力画面へフォワード
        RequestDispatcher rd = req.getRequestDispatcher(next_page);
        rd.forward(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

}