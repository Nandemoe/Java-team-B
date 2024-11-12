<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->

<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>accountbal.jsp</title>
</head>

<body>

  <div style="text-align:center;">
    <h2>
      <%-- 名前を表示 --%>
      <c:out value ="${sessionScope.account.name}" />さんの残高
    </h2>

    <%-- <c:if>タグを使用して、Accountオブジェクトのflag==1の場合は「入金」を、
               flag==2の場合は「出金」を表示 --%>
    <c:if test="${sessionScope.account.flag == 1}"> 入金 </c:if>
    <c:if test="${sessionScope.account.flag == 2}"> 出金 </c:if>

    処理を行いました。

    <table border="1" style="margin-left: auto; margin-right: auto;">
      <tr>
        <td>お名前</td>
        <td>
          <%-- 名前を表示 --%>
          <c:out value ="${sessionScope.account.name}" />
        </td>
      </tr>
      <tr>
        <td>現在の残高</td>
        <td>
          <%-- 残高を表示 --%>
          <c:out value ="${sessionScope.account.balance}" />
        </td>
      </tr>
    </table>
  </div>
  <hr>


  <div style="text-align:center;">
    <%-- リンクを作成 --%>
    <a href="/answers/mod7/accountact.jsp">入出金画面に戻る</a>   |
    <a href="/answers/logout2">ログアウト</a>
    <%-- 任意問題2 --%>
    <%--
    <a href="/answers/control?command_id=100">入出金画面に戻る</a>   |
    <a href="/answers/control?command_id=2">ログアウト</a>
    --%>
  </div>
</body>
</html>
