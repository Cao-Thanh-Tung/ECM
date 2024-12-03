<%@ page import="java.util.List" %>
<%@ page import="ecm.dto.CartItemDTO" %>
<%@ page import="ecm.model.Product" %>
<%@ page import="ecm.model.Cart" %>

<HTML>
<HEAD>
<TITLE>Shopping Cart</TITLE>
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
                <TD><FONT FACE="Verdana" SIZE="3"><B>Name</B></FONT></TD>
                <TD><FONT FACE="Verdana" SIZE="3"><B>Description</B></FONT></TD>
                <TD><FONT FACE="Verdana" SIZE="3"><B>Price</B></FONT></TD>
                <TD><FONT FACE="Verdana" SIZE="3"><B>Quantity</B></FONT></TD>
                <TD><FONT FACE="Verdana" SIZE="3"><B>Subtotal</B></FONT></TD>
                <TD><FONT FACE="Verdana" SIZE="3"><B>Update</B></FONT></TD>
                <TD><FONT FACE="Verdana" SIZE="3"><B>Delete</B></FONT></TD>
            </TR>

            <%
                // Get the cart items from the model
                List<CartItemDTO> cartItems = (List<CartItemDTO>) request.getAttribute("cartItems");

                // Loop through each CartItemDTO
                if (cartItems != null) {
                    for (CartItemDTO cartItemDTO : cartItems) {
                        Cart cartItem = cartItemDTO.getCart();
                        Product product = cartItemDTO.getProduct();
            %>
                        <TR>
                            <TD><FONT FACE="Verdana" SIZE="2"><%= product != null ? product.getName() : "Unknown" %></FONT></TD>
                            <TD><FONT FACE="Verdana" SIZE="2"><%= product != null ? product.getDescription() : "No Description" %></FONT></TD>
                            <TD><FONT FACE="Verdana" SIZE="2"><%= product != null ? product.getPrice() : 0 %></FONT></TD>
                            <FORM method="post" action="yourUpdateActionUrl"> <!-- Specify your update action URL -->
                                <INPUT TYPE="HIDDEN" NAME="action" VALUE="updateShoppingItem">
                                <INPUT TYPE="HIDDEN" NAME="productId" VALUE="<%= cartItem.getProductId() %>">
                                <TD><INPUT TYPE="TEXT" Size="2" NAME="quantity" VALUE="<%= cartItem.getQuantity() %>"></TD>
                                <TD><FONT FACE="Verdana" SIZE="2"><%= cartItem.getQuantity() * (product != null ? product.getPrice() : 0) %></FONT></TD>
                                <TD><INPUT TYPE="SUBMIT" VALUE="Update"></TD>
                            </FORM>
                            <FORM method="post" action="yourDeleteActionUrl"> <!-- Specify your delete action URL -->
                                <INPUT TYPE="HIDDEN" NAME="action" VALUE="deleteShoppingItem">
                                <INPUT TYPE="HIDDEN" NAME="productId" VALUE="<%= cartItem.getProductId() %>">
                                <TD><INPUT TYPE="SUBMIT" VALUE="Delete"></TD>
                            </FORM>
                        </TR>
            <%
                    }
                } else {
            %>
                    <TR>
                        <TD COLSPAN="7"><FONT FACE="Verdana" SIZE="2">Your cart is empty.</FONT></TD>
                    </TR>
            <%
                }
            %>
            <TR>
                <TD COLSPAN="7"><A HREF="<%= request.getContextPath() %>/checkout">Check Out</A></TD> <!-- Use context path for base -->
            </TR>
        </TABLE>
    </TD>
</TR>
</TABLE>
</BODY>
</HTML>
