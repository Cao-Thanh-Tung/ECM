<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Browse Catalog</title>
</head>
<body>
<table>
    <tr>
        <td colspan="2">
            <jsp:include page="/element/Header.jsp" flush="true"/>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="/element/Menu.jsp" flush="true"/>
        </td>
        <td valign="top">
            <c:if test="${not empty products}">
                <table>
                    <tr>
                        <td><b>Name</b></td>
                        <td><b>Description</b></td>
                        <td><b>Price</b></td>
                        <td><b>Details</b></td>
                    </tr>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td><a href="/product/${product.productId}">Details</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${not empty error}">
                <p>${error}</p>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
