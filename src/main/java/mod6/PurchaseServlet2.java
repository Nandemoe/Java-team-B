/**
 * All Rights Reserved, Copyright(c) IT Educations Inc. Limited
 *
 * PurchaseServlet2.java
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

@WebServlet("/purchase2")
public class PurchaseServlet2 extends HttpServlet {

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

        // リクエストオブジェクトに商品一覧を格納
        req.setAttribute("goods", goods);

        // フォワード処理
        RequestDispatcher rd = req.getRequestDispatcher("/mod6/purchase.jsp");
        rd.forward(req, res);
    }
}
