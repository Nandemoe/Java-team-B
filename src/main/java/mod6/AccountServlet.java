/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * AccountServlet.java
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

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	//遷移先画面の初期値設定
        String page = "/mod6/accountbal.jsp";

        try {
        	// FORM情報の取り出し
            req.setCharacterEncoding("UTF-8");
        	String flag = req.getParameter("flag");
		    int balance = Integer.parseInt(req.getParameter("balance"));

		    // セッションオブジェクトからAccountオブジェクトを取得
		    HttpSession session = req.getSession(false);
		    Account account = (Account)session.getAttribute("account");

		    // Accountオブジェクトにflagを設定して入出金処理
		    account.setFlag(flag);
	        account.setBalance(balance);
    	} catch (NumberFormatException e) {
    		req.setAttribute("error", "数値を入力してください。");
        	page = "/mod6/accountact.jsp";
    	}

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher(page);
        rd.forward(req, res);
    }
}
