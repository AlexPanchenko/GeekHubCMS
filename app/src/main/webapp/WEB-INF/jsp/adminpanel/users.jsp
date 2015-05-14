<%--
  Created by IntelliJ IDEA.
  User: Marikutsa Oleksandr
  Date: 14.05.2015
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Table</title>
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table class="table-bordered table-striped" style="width: 100%">
  <tr>
    <th><input type="text" style="width: 100%" placeholder="Введите текст"></th>
    <th><input type="text" style="width: 100%" placeholder="Введите текст"></th>
  </tr>
  <thead class="alert-success">
    <tr>
      <th> Email </th>
      <th> Name </th>
      <th> Lastname </th>
      <th> Phone </th>
      <th> Skype </th>
      <th> Action </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>11111 </td>
      <td> <button class="btn btn-success btn-large btn-primary" type="button">Show user profile</button></td>
    </tr>
    <tr>
      <td>111111 </td>
      <td>11111111 </td>
      <td> <button class="btn btn-success btn-large btn-primary" type="button">Show user profile</button></td>
    </tr>
    <tr>
      <td> 11111111</td>
      <td> 11111111</td>
      <td> <button class="btn btn-success btn-large btn-primary" type="button">Show user profile</button></td>
    </tr>
   </tbody>
</table>
  <div style="width: 100%">
    <ul class="pagination pagination-sm" style="margin: auto">
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
    </ul>
  </div>
</body>
</html>
