/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * YourselfServlet.java
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

@WebServlet("/yourself")
public class YourselfServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // FORM情報の取り出し
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String from = req.getParameter("from");
        String[] hobby = req.getParameterValues("hobby");

        // 趣味が何も選択されていなかった場合の処理
        if (hobby == null) {
            hobby = new String[1];
            hobby[0] = "なし";
        }

        // クライアントへ送るHTMLの作成
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = res.getWriter();

        pw.println("<html><head></head><body>");
        pw.println("<table border=\"1\" style=\"margin-left: auto; margin-right: auto; width:200px\">");
        pw.println("<caption>入力された情報</caption>");
        pw.println("<tr><td style=\"background-color:silver;\">名前</td>");
        pw.println("<td>" + name + "</td></tr>");
        pw.println("<tr><td style=\"background-color:silver;\">性別</td>");
        pw.println("<td>" + gender + "</td></tr>");
        pw.println("<tr><td style=\"background-color:silver;\">出身地</td>");
        pw.println("<td>" + from + "</td></tr>");
        pw.println("<tr><td style=\"background-color:silver;\">趣味</td>");
        pw.println("<td>");

        // 取得した趣味情報が存在する間繰り返す
        for (String str : hobby) {
            pw.println(str + "<br>");
        }

        pw.println("</td></tr>");
        pw.println("</table></body></html>");

    }
}
