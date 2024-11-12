<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>list.jsp</title>
</head>

<body>

  <%-- 名前の表示 --%>
  <h1>ようこそ。<c:out value="${sessionScope.member.name}" /> さん!</h1>

  <div style="color:blue;">欲しい商品を選択してください</div><br><br>

  <form method="post" action="/answers/purchase2">
    <input type="checkbox" name="goods" value="洗濯機">洗濯機<br>
    <input type="checkbox" name="goods" value="掃除機">掃除機<br>
    <input type="checkbox" name="goods" value="炊飯器">炊飯器<br>
    <input type="checkbox" name="goods" value="冷蔵庫">冷蔵庫<br>
    <input type="checkbox" name="goods" value="テレビ">テレビ<br>
    <input type="checkbox" name="goods" value="パソコン">パソコン<br>
    <input type="checkbox" name="goods" value="プリンタ">プリンタ<br><br>
    <input type="submit" value="送信">
    <input type="reset" value="キャンセル">
  </form>

</body>
</html>
