/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * LoginServlet.java
 *
 */

package mod5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        // ログイン処理
        // ログインに失敗した場合はエラーページにフォワードする。
        if (!(name.equals("taro") && password.equals("taro"))) {
            RequestDispatcher rd = req.getRequestDispatcher("/mod5/LoginError.html");
            rd.forward(req, res);
            return;
        }

        // セッションオブジェクトにユーザー名を格納
        HttpSession session = req.getSession();
        session.setAttribute("name", name);

        // クライアントへ送るHTMLの作成
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head></head><body>");

        // 取得したユーザー名の表示
        pw.println("<h1>ようこそ" + name + "さん！</h1>");

        // 商品一覧の表示
        pw.println("<div style=\"color:blue;\">"
                                   + "欲しい商品を選択してください</div><br><br>");
        pw.println("<form method=\"post\" action=\"/answers/purchase\">");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"洗濯機\">"
                                                                   + "洗濯機<br>");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"掃除機\">"
                                                                   + "掃除機<br>");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"炊飯器\">"
                                                                   + "炊飯器<br>");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"冷蔵庫\">"
                                                                   + "冷蔵庫<br>");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"テレビ\">"
                                                                   + "テレビ<br>");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"パソコン\">"
                                                                   + "パソコン<br>");
        pw.println("<input type=\"checkbox\" name=\"goods\" value=\"プリンタ\">"
                                                             + "プリンタ<br><br>");
        pw.println("<input type=\"submit\" value=\"送信\">");
        pw.println("<input type=\"reset\" value=\"キャンセル\">");
        pw.println("</form></body></html>");

    }
}
