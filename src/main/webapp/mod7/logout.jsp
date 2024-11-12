<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->

<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- セッションオブジェクトを削除する --%>
<%
    session.invalidate();
%>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>logout.jsp</title>
</head>
<body>
  <h2>
    ログアウトします。<br>
    またのご来店をお待ちしております。
  </h2>

  <br>
    <a href="/answers/mod7/loginAccount.jsp">ログイン画面に戻る</a>
  <br>

</body>
</html>
