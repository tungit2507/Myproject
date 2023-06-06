<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<%@ include file="common/_css.jsp" %>
<body>
<%@ include file="common/_header.jsp" %>
<!-- Cart Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-light table-borderless table-hover text-center mb-0">
                    <thead class="thead-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                        <c:forEach var="item" items="${list}">
                        	<tr id="${item.id}">
                            <td class="align-middle"><img src="templates/img/product-1.jpg" alt="" style="width: 50px;">${item.product.names}</td>
                            <td class="align-middle">${item.product.price}</td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-minus" onclick="addToCart('${item.product.id}',-1,'${item.quantity-1}','${item.product.price}')">
                                        <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input id="quantityOf${item.product.id}" type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="${item.quantity}">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-primary btn-plus" onclick="addToCart('${item.product.id}',1,'${item.quantity+1}','${item.product.price}')">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle" id="totalOf${item.product.id}">${item.product.price * item.quantity}</td>
                            <td class="align-middle"><button class="btn btn-sm btn-danger" onclick="removeCartItem('${item.id}')"><i class="fa fa-times"></i></button></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <form class="mb-30" action="">
                    <div class="input-group">
                        <input type="text" class="form-control border-0 p-4" placeholder="Coupon Code">
                        <div class="input-group-append">
                            <button class="btn btn-primary">Apply Coupon</button>
                        </div>
                    </div>
                </form>
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart Summary</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom pb-2">
                        <div class="d-flex justify-content-between mb-3">
                            <h6>Subtotal</h6>
                            <h6>$150</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium">$10</h6>
                        </div>
                    </div>
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Total</h5>
                            <h5>$160</h5>
                        </div>
                        <button class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout</button>
                    </div>
                </div>
            </div> 	
        </div>
    </div>
    <!-- Cart End -->
<%@ include file="common/_footer.jsp" %>
</body>
</html>
<%@ include file="common/_js.jsp" %>

<script type="text/javascript">
	function addToCart(productId,Plusquantity, newquantity,price) {
		var inputQuantity = document.getElementById("quantityOf"+productId).value;
		var total = document.getElementById("totalOf"+productId);
		total.innerHTML = (inputQuantity) * price;
		$.ajax({
		  url: '/cart/add?productId='+productId+"&quantity="+Plusquantity,
		  type: 'POST',
		});
	}
	
	function removeCartItem(cartItemId) {
		var CartItem =  document.getElementById(cartItemId);
		CartItem.remove();
		$.ajax({
			  url: '/cart/remove?cartItemId='+cartItemId,
			  type: 'POST',
			  success: function(response) {
			    	alert("Xóa Thành Công");
			  },
			  error: function(xhr, status, error) {
				  alert("Xóa Thất Bại");	
			  }  
		});
	
	}
</script>