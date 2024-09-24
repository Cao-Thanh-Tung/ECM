<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<HTML>
<HEAD>
<TITLE>Product Details</TITLE>
</HEAD>
<BODY>
<TABLE>
<TR>
  <TD COLSPAN=2><jsp:include page="/element/Header.jsp" flush="true"/></TD>
</TR>
<TR>
  <TD><jsp:include page="/element/Menu.jsp" flush="true"/></TD>
  <TD VALIGN="TOP">
<TABLE>
<TR>
<%--  <TD><IMG BORDER="0" WIDTH="100" SRC=""></TD>--%>
  <TD><B>${product.name}</B><BR>
      ${product.description}<BR>
      Price : $${product.price}</TD>
</TR>
<TR>
  <TD COLSPAN="2" ALIGN="RIGHT">
    <A HREF="/sd?action=addShoppingItem&productId=${product.productId}">
      Add To Cart</A>
  </TD>
</TR>
</TABLE>
  </TD>
</TR>
</TABLE>
</BODY>
</HTML>
