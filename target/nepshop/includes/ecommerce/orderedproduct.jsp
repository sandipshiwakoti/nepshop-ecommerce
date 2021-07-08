<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
import="com.nepshop.model.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>NepShop || Customer</title>
     <!-- favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="/img/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/img/favicon/favicon-16x16.png">
    <link rel="manifest" href="/img/favicon/site.webmanifest">
    <!-- font awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- Custom css -->
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body onload="showToastMessage('${sessionScope.toast[0]}', '${sessionScope.toast[1]}')">
     <% 
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
      response.setHeader("Pragma", "no-cache");
      Customer sessionCustomer = (Customer)session.getAttribute("customer");
      if(sessionCustomer == null){
          response.sendRedirect("/includes/ecommerce/login.jsp");
      }
      session.removeAttribute("toast");
    %>
    <div class="toast-message-container"></div>
    <nav class="navbar">
      <div class="navbar-top">
        <div class="nav-logo logo">NepShop</div>
        <div class="navbar-top-right">
          <form action="/productservlet" class="navbar-search-form">
            <input type="text" name="search-field" id="search" class="input-search" />
            <input type="hidden" name="action" value="search-products-by-name"/>
            <button class="btn-navbar-search" type="submit"><i class="fas fa-search"></i></button>
          </form>
          <div onclick="showCart()" class="btn-navbar-cart">
            <i class="fas fa-shopping-cart"></i>
            <span class="cart-total-item-quantity">121</span>
          </div>
          <span class="btn-navmenu-open"><i class="fas fa-bars"></i></span>
        </div>
      </div>
      <div class="navbar-bottom">
        <div class="navbar-bottom-center">
          <div class="navlinks">
            <a href="/" class="navlink">home</a>
            <a href="/productservlet?action=display-all-products" class="navlink">products</a>
            <a href="" class="navlink">featured</a>
            <a href="" class="navlink">services</a>
            <a href="" class="navlink">contact us</a>
          </div>
          <div class="navbar-bottom-right">
            <form class="navbar-search-form">
              <input
                type="text"
                name="search"
                class="input-search"
              />
              <span class="btn-navbar-search"
                ><i class="fas fa-search"></i
              ></span>
            </form>
            <div onclick="showCart()" class="btn-navbar-cart">
              <i class="fas fa-shopping-cart"></i>
              <span class="cart-total-item-quantity">121</span>
            </div>
            <a
              href="/includes/ecommerce/login.jsp"
              class="btn-navbar-authenticate"
              >login
              <span><i class="fas fa-sign-in-alt"></i></span>
            </a>
          </div>
        </div>
      </div>
      <div class="mobile-navmenu">
        <div class="mobile-navmenu-header">
          <div class="nav-logo logo">NepShop</div>
          <span class="btn-navmenu-close"><i class="fas fa-times"></i></span>
        </div>
        <div class="mobile-navlinks">
          <a href="" class="mobile-navlink">home</a>
          <a href="/productservlet?action=display-all-products" class="mobile-navlink">products</a>
          <a href="" class="mobile-navlink">featured</a>
          <a href="" class="mobile-navlink">services</a>
          <a href="" class="mobile-navlink">contact us</a>
        </div>
        <a href="/includes/ecommerce/login.jsp" class="btn-navbar-authenticate btn-logout">logout
                        <span><i class="fas fa-sign-in-alt"></i></span>
        </a>
      </div>
    </nav>
    <section class="section ordered-product-section">
        <div class="ordered-product-center section-center">
            <h1 class="section-title">Order history</h1>
            <div class="table-container">
                    <table class="table">
                        <thead>
                            <th>photo</th>
                            <th>name</th>
                            <th>company</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>shipping address</th>
                            <th>payment method</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${orderedProducts}" var="product">
                                <tr>
                                    <td>
                                        <div class="table-img-container">
                                            <img src="${product.photo}" onerror="this.src='/img/default.jpg'" class="table-img"/>
                                        </div>
                                    </td>
                                    <td>${product.name}</td>
                                    <td>${product.company}</td>
                                    <td>${product.price}</td>
                                    <td>${product.quantity}</td>
                                    <td>${product.shipping_address}</td>
                                    <td>${product.payment_method}</td>
                                </tr>
                            </c:forEach>
                          </tbody>
                        </table>
                </div>
        </div>
    </section>
    <footer class="footer">
      <div class="footer-center">
        <div class="footer-top">
          <div class="footer-column">
            <div>
              <div class="logo footer-logo">nepshop</div>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Temporibus magnam deserunt est saepe dolores libero quam sequi
                nihil, magni officia aperiam debitis voluptatibus, reprehenderit
                illum.
              </p>
            </div>
          </div>
          <div class="footer-column">
            <h1>information</h1>
            <div>
              <a href="" class="footer-link">about us</a>
              <a href="" class="footer-link">faq</a>
              <a href="" class="footer-link">terms and conditions</a>
              <a href="" class="footer-link">contact us</a>
              <a href="" class="footer-link">help</a>
            </div>
          </div>
          <div class="footer-column">
            <h1>customer service</h1>
            <div>
              <a href="" class="footer-link">payment methods</a>
              <a href="" class="footer-link">money-back returns</a>
              <a href="" class="footer-link">shipping</a>
              <a href="" class="footer-link">privacy policy</a>
            </div>
          </div>
          <div class="footer-column">
            <h1>get in touch</h1>
            <div>
              <span>tinkune, kathmandu</span>
              <span>Nepal</span>
              <span>info@nepshop.com</span>
              <span>+9779841258748</span>
            </div>
          </div>
        </div>
        <div class="footer-bottom">
          <span>Copyright © 2021 NepShop- All Rights Reserved.</span>
        </div>
      </div>
    </footer>
     <!-- cart -->
    <div class="cart-overlay">
      <aside class="cart">
        <span class="btn-close-cart">
          <i class="fas fa-times"></i>
        </span>
        <h1 class="cart-title">shopping cart</h1>
        <div class="cart-content">
          <div class="cart-items">
          </div>
          <div class="order-summary">
            <h1 class="order-summary-title">order summary</h1>
            <div>
              <span>subtotal cost</span>
              <span class="cart-subtotal-cost">Rs. 8000</span>
            </div>
            <div>
              <span>shipping cost</span>
              <span  class="cart-shipping-cost">Rs. 100</span>
            </div>
            <div>
              <span>total cost</span>
              <span class="cart-total-cost">Rs. 8100</span>
            </div>
            <a href="/includes/ecommerce/customer.jsp" class="btn-checkout">checkout now</a>
          </div>
        </div>
      </aside>
    </div>
    <script src="/js/app.js"></script>
  </body>
</html>
