<!-- All Rights Reserved, Copyright(c) IT Educations Inc. Limited -->
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <title>triangle.jsp</title>
</head>

<body>

  <%
      for (int i = 0; i < 20; i++) {
          for (int j = 0; j <= i; j++) {
  %>
            *
  <%
          }
  %>
      <br>
  <%
      }
  %>

</body>
</html>
