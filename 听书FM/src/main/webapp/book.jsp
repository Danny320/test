<%@ page import="com.luodan.service.BookService" %>
<%@ page import="com.luodan.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private BookService bookService;
    public void jspInit() {
        bookService = new BookService();
    }
%>
<%
    int bid = Integer.parseInt(request.getParameter("bid"));
    Book book = bookService.get(bid);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
