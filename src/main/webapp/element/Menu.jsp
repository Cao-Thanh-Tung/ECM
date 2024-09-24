<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag" %>

<TABLE CELLSPACING="0" CELLPADDING="5" WIDTH="150" BORDER="0">
<TR>
  <TD BGCOLOR="F6F6F6">
    <FONT FACE="Verdana">Search</FONT>
    <FORM ACTION="/product" method="get">
    <INPUT TYPE="HIDDEN" NAME="action" VALUE="search">
      <INPUT TYPE="HIDDEN" NAME="categoryId" VALUE="${categoryId}">
    <INPUT TYPE="TEXT" NAME="keyword" SIZE="10">
    <INPUT type="SUBMIT" VALUE="Go">
    </FORM>
  </TD>
</TR>
<TR>
  <TD BGCOLOR="F6F6F6"><FONT FACE="Verdana">Categories:</FONT></TD>
</TR>
<TR VALIGN="TOP">
  <TD BGCOLOR="F6F6F6">

    <c:forEach items="${categoryList}" var="category">
        <A HREF="/product?action=search&categoryId=${category.getCategoryId()}"> ${category.getCategory()} </A> <BR>
    </c:forEach>
  </TD>
</TR>
</TABLE>
