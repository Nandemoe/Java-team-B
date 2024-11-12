<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<%-- pageディレクティブの使用 --%>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>whatTime.jsp</title>
</head>

<body>
  <div style="text-align:center;">
    <%-- 日付と時刻の取得 --%>
    <%
        Date d = new Date();
        String str = d.toString();
    %>
    ただいまの日付、時刻は <%= str %>です。
    <hr>
    WhatTimeJSP
  </div>
</body>
</html>
