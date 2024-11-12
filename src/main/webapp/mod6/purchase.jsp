<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>purchase.jsp</title>
</head>

<body>

  <%-- 名前の表示 --%>
  <h1><c:out value="${sessionScope.member.name}" /> さんが購入した商品一覧</h1>

  <table border="1">
    <tr style="background-color:silver;">
      <th>商品名</th>
    </tr>
    <tr>
      <td>
      <%-- 購入した商品一覧の表示 --%>
        <c:forEach items="${requestScope.goods}" var="good">
          ・<c:out value="${good}" /><br>
        </c:forEach>
      </td>
    </tr>
  </table>
  <br><hr><br>
  <a href="/answers/mod6/login2.jsp">ログイン画面に戻る</a>

</body>
</html>
