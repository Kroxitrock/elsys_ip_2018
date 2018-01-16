<%--
  Created by IntelliJ IDEA.
  User: milko.mitropolitsky
  Date: 11/29/17
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <title>$Title$</title>
  </head>
  <body id="body">
    <form id="Search">
      <input type="text" id="id" name="id" />
      <input type="text" id="name" name="name" />
      <input type="text" id="genre" name="genre" />
      <input type="text" id="owner" name="owner" />
      <input type="text" id="director" name="director" />
      <input type="text" id="writer" name="writer" />
      <input type="text" id="actors" name="actors" />
      <input type="text" id="screenTime" name="screenTime" />
      <input type="text" id="releaseDate" name="releaseDate" />
      <input type="text" id="score" name="score" />
      <input type="text" id="awards" name="awards" />
      <input type="submit" value="Search"/>
    </form>
    <table id="movies"></table>
    <form id="create">
      <input type="text" name="id" />
      <input type="text" name="name" />
      <input type="text" name="genre" />
      <input type="text" name="owner" />
      <input type="text" name="director" />
      <input type="text" name="writer" />
      <input type="text" name="actors" />
      <input type="text" name="screenTime" />
      <input type="text" name="releaseDate" />
      <input type="text" name="score" />
      <input type="text" name="awards" />
      <input type="submit" value="Create"/>
    </form>
    <form action = "http://localhost:8081/api/movies/upload" method="post" enctype="multipart/form-data" id="Upload">
      <input type="file" name="file" id="file"> <br>
      <input type="submit" value="Upload">
    </form>
    <form action = "http://localhost:8081/api/movies/download" method="get" enctype="multipart/form-data">
      <input type="submit" value="Download">
    </form>
    <script src = "main.js"></script>
  </body>
</html>
