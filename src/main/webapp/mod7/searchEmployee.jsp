<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>従業員検索</title>
  <script type="text/javascript">
    function PushSendButton() {
      var id = document.inform.id.value;
      if (id == "") {
        alert("従業員IDを入力してください。");
        return false;
      }
      return true;
    }
  </script>
</head>

<body>
  <form method="post" name="inform" action="/answers/searchemp">
  <div style="text-align:center;">
    <p>検索する人のIDを入力してください。</p>
    <div style="color:red; font-weight:bold;">
      <%-- エラーメッセージがある場合は表示 --%>
      <c:out value="${requestScope.error}" />
    </div>
    <input type="text" name="id">
    <input type="submit" value="送信" onclick="return PushSendButton()">
  </div>
  </form>
</body>
</html>
