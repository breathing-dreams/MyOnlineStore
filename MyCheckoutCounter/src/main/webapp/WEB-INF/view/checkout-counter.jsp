<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div>
	
		<div id="wrapper">
		<div id="header">
			<h2>Hello, you are at the checkout counter</h2>
		</div>
	</div>
	<hr>
	<hr>
	<h3>Scan all the products</h3>
	<div class="container">
	
	<form name="scanProductId" action="scanProductId" method="POST" >
    <ul>
        <li><label>Enter Product Id:</label> <input type='text' name='theProductId' /></li>
        <li><label>Enter Quantity: </label> <input type='text' name='theQuantity' /></li>
        

        <li><label>&nbsp;</label> <input type="submit" value="Scan" class="btn"></li>
        <li><label>&nbsp;</label> <input id="cleart()" type="reset" value="clear" class="btn"></li>
    </ul>
	</form>
	</div>
	<hr>
	<p>
	<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
		<h3>Your bill</h3>
			<table>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product price</th>
					<th>Product Quantity</th>
					<th>Total price</th>
					<th>Sale Tax</th>
				</tr>
				
				<!-- loop over and print our list -->
				<c:set var="saleTax" value="${0}" />
				<c:set var="totalAmount" value="${0}" />
				<c:forEach var="tempProduct" items="${productList}">
					<c:set var="saleTax" value="${saleTax + tempProduct.saleTax}" />
					<c:set var="totalAmount" value="${totalAmount + tempProduct.totalAmount+ saleTax}" />
					<tr>
						<td> ${tempProduct.productId} </td>
						<td> ${tempProduct.productName} </td>
						<td> ${tempProduct.productPrice} </td>
						<td> ${tempProduct.quantity} </td>
						<td> ${tempProduct.totalAmount} </td>
						<td> ${tempProduct.saleTax} </td>
					</tr>
				
				</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Total Sales Tax</td>
					<td>${saleTax}</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>GrandTotal</td>
					<td>${totalAmount}</td>
				</tr>			
						
			</table>		
		
		</div>
	
		<p>
			<a href="${pageContext.request.contextPath}/onlinestore/generateBill">Proceed to Checkout</a>
		</p>
	</div>
	</div>

	

</body>
</html>