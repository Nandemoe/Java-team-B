<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブタグで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <title>errorPage.jsp</title>
</head>

<body>

  <div style="font-weight:bold;">
    <c:out value="${requestScope.error}" />
  </div>

</body>

</html>
