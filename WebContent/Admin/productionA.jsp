<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<script>
            $(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                $.get("someservlet", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
            });
        </script>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Karma Shop</title>

<!--
            CSS
            ============================================= -->
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/themify-icons.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/nouislider.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>

<body>

	<!-- Start Header Area -->
	<jsp:include page="/Admin/headerA.jsp"/>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Manage Production</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Cart</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Cart Area =================-->
	<section class="cart_area">
		<div class="container">
			<div class="cart_inner">
				<c:if test="${cart.size() == 0}">
					<p>Gi??? h??ng r???ng
					<p>
				</c:if>
				<c:if test="${cart.size() != 0}">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Product</th>
									<th scope="col">Price</th>
									<th scope="col">Quantity</th>
									<th scope="col"></th>
									
									<th scope="col">Edit</th>
									<th scope="col">Delete</th>
								</tr>
							</thead>
							 <a href="AdminAddNewShoe"
										class="btn btn-primary"> Add New Shoe </a>
							<tbody>
								<c:forEach items="${shoelist}" var="shoe">
								<tr>
									<td>
										<div class="media">
										<div>
										<img src="${shoe.photo}">
										</div>
											<div class="media-body">
												<h4>${shoe.nameShoe}</h4>
											</div>
										</div>
									</td>
									<td>
										<h5>${shoe.price}</h5>
									</td>
									<td>
										<h5 >${shoe.count}</h5>
									</td>
									<td>
										<!-- <div class="product_count">
											<input type="text" name="qty" id="sst" maxlength="12"
												value="1" title="Quantity:" class="input-text qty">
											<button
												onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
												class="increase items-count" type="button">
												<i class="lnr lnr-chevron-up"></i>
											</button>
											<button
												onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
												class="reduced items-count" type="button">
												<i class="lnr lnr-chevron-down"></i>
											</button>
										</div> -->
									</td>
									
									<td>
									<input type="hidden" value="" name="deleteShoeId"
										id="btn-cart-delete${loop.index}"> <a href=""
										class="btn btn-success"> Edit </a>
									</td>
									<td>
									<input type="hidden" value="" name="deleteShoeId"
										id="btn-cart-delete${loop.index}"> <a href=""
										class="btn btn-dark"> Delete </a>
										
									</td>
								</tr>
							</c:forEach>
									<%-- <td>
									
										<button class="gray_btn" placeholder="Coupon Code"
											type="submit">Update Cart</button>
									</td>
									<td></td>
									<td></td>
									<td>
										<!--  <div class="cupon_text d-flex align-items-center">
											<input type="text" placeholder="Coupon Code"> <a
												class="primary-btn" href="#">Apply</a> <a class="gray_btn"
												href="CartController">Close Coupon</a>
										</div>  -->
									</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<h5>Subtotal</h5>
									</td>
									<td>

										<h5>
											<c:set var="total" value="${0}" />
											<c:forEach items="${cart}" var="category">
												<c:set var="total" value="${total + category.priceItem}" />
											</c:forEach>
											<c:out value="${total}" />
										</h5>
									</td>
								</tr>
								</form>
								<!-- <tr class="shipping_area">
									<td></td>
									<td></td>
									<td>
										<h5>Shipping</h5>
									</td>
									<td>
										<div class="shipping_box">
											<ul class="list">
												<li><a href="#">Flat Rate: $5.00</a></li>
												<li><a href="#">Free Shipping</a></li>
												<li><a href="#">Flat Rate: $10.00</a></li>
												<li class="active"><a href="#">Local Delivery:
														$2.00</a></li>
											</ul>
											<h6>
												Calculate Shipping <i class="fa fa-caret-down"
													aria-hidden="true"></i>
											</h6>
											<select class="shipping_select">
												<option value="1">Bangladesh</option>
												<option value="2">India</option>
												<option value="4">Pakistan</option>
											</select> <select class="shipping_select">
												<option value="1">Select a State</option>
												<option value="2">Select a State</option>
												<option value="4">Select a State</option>
											</select> <input type="text" placeholder="Postcode/Zipcode"> <a
												class="gray_btn" href="#">Update Details</a>
										</div>
									</td>
								</tr> -->
								<tr class="out_button_area">
									<td></td>
									<td></td>
									<td></td>
									<td>
										<div class="checkout_btn_inner d-flex align-items-center">
											<!-- <a class="gray_btn" href="#">Continue Shopping</a> -->
											<a class="primary-btn" href="BillController">Proceed to
												checkout</a>
										</div>
									</td>
								</tr> --%>
							</tbody>
						</table>
					</div>
				</c:if>

			</div>
		</div>
	</section>
	<!--================End Cart Area =================-->

	<!-- start footer Area -->
	<jsp:include page="/Admin/footerA.jsp"/>
	<!-- End footer Area -->

	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="js/gmaps.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>