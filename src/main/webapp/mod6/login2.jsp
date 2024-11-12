<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>login2.jsp</title>
</head>

<body>

  <h1>ログイン画面</h1>
  <hr><br>

  <div style="color:red; font-weight:bold;">
    <%-- エラーメッセージがある場合は表示 --%>
    <c:out value="${requestScope.error}" />
  </div>

  <form method="post" action="/answers/login3">
    ユーザー名：<input type="text" name="name"><br>
    パスワード：<input type="password" name="password"><br><br>
    <input type="submit" value="送信">
    <input type="reset" value="キャンセル">
  </form>


</body>
</html>
