/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * PurchaseServlet.java
 *
 */

package mod5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/purchase")
public class PurchaseServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String[] goods = req.getParameterValues("goods");

        // 商品が何も選択されていなかった場合の処理
        if (goods == null) {
            goods = new String[1];
            goods[0] = "選択なし";

        }

        // セッション情報の獲得
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");

        // クライアントへ送るHTMLの作成
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = res.getWriter();

        pw.println("<html><head></head><body>");

        // セッションから取得したユーザー名の表示
        pw.println("<h1>" + name + "さんが購入した商品一覧</h1>");


        // 購入した商品一覧の表示
        pw.println("<table border=\"1\" style=\"width:150px\">");
        pw.println("<tr style=\"background-color:silver;\"><th>商品名</th></tr>");
        pw.println("<tr><td>");

        // 取得した商品情報が存在する間繰り返す
        for (String str : goods) {
            pw.println("・" + str + "<br>");
        }

        pw.println("</td></tr></table>");
        pw.println("<br><hr><br>");
        pw.println("<a href=\"/answers/mod5/Login.html\">ログイン画面に戻る</a>");
        pw.println("</body></html>");

    }
}
