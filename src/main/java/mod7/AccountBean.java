/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * AccountBean.java
 *
 */

package mod7;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AccountBean implements Serializable {

    public String execute(HttpServletRequest req) {
    	//遷移先画面の初期値設定
        String page = "/mod7/accountbal.jsp";

        try {
            // FORM情報の取り出し
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
        	page = "/mod7/accountact.jsp";
    	}

        return page;
    }
}
