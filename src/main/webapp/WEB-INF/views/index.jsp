<%@ page import="org.andh.mymybatis.model.vo.KeywordSearch" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: tal63
  Date: 25. 4. 1.
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>검색을 할거에요</title>
</head>
<body>
<h1>검색하자!</h1>
<form>
    <label>키워드 : <input name="keyword"></label>
    <input type="submit" value="검색">
</form>
<% if (request.getAttribute("result") != null) { %>
<section style="display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 12px">
    <%
        for (KeywordSearch v : (List<KeywordSearch>) request.getAttribute("result")) {
    %>
    <div>
        <h3><%= v.title() %></h3>
        <ul>
            <li><%= v.link() %></li>
            <li><%= v.description() %></li>
            <li><%= v.date() %></li>
            <%--<li><%= v.createdAt() %></li>--%>
            <form action="bookmark" method="post">
                <input type="hidden" name="uuid" value="<%= v.uuid() %>">
                <button>북마크</button>
            </form>
        </ul>
    </div>
    <%
        }
    %>
</section>
<% } %>
</body>
</html>