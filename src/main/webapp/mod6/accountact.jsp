<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>accountact.jsp</title>
</head>

<body>
  <form method="post" action="/answers/account">
    <div style="text-align:center;">
      <h2>
        <%-- 名前を表示 --%>
        ようこそ！
        <c:out value ="${sessionScope.account.name}" />さん。
        <br>
        入金、または出金額を入力してください。
      </h2>

      <div style="color:red; font-weight:bold;">
        <%-- エラーメッセージがある場合は表示 --%>
        <c:out value="${requestScope.error}" />
      </div>

      <table border="1" style="margin-left: auto; margin-right: auto;">
      <tr>
        <td>現在の残高</td>
        <td>
          <%-- 残高を表示 --%>
          <c:out value ="${sessionScope.account.balance}" />
        </td>
      </tr>
      <tr>
        <td>入金 or 出金</td>
        <td><input type="radio" name="flag" value=1 checked>入金
        <input type="radio" name="flag" value=2 >出金</td>
      </tr>
      <tr>
        <td>金額</td>
        <td><input type="text" name="balance" ></td>
      </tr>
      </table>
    </div>
    <hr>
    <div style="text-align:center;">
      <input type="submit" value="送信">
    </div>
  </form>
</body>
</html>
