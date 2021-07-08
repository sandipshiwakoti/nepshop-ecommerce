<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NepShop || Home</title>
    <!-- font awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Custom css -->
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <%
        if(session.getAttribute("user") == null){
            response.sendRedirect("/pages/login.jsp");
        }
    %>
    <nav class="navbar">
        <div class="navbar-top">
            <div class="nav-logo logo">
                NepShop
            </div>
            <div class="navbar-top-right">
                <form class="navbar-search-form">
                    <input type="text" name="search" id="search" class="input-search">
                    <span class="btn-navbar-search"><i class="fas fa-search"></i></span>
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
                    <a href="" class="navlink">home</a>
                    <a href="" class="navlink">products</a>
                    <a href="" class="navlink">featured</a>
                    <a href="" class="navlink">services</a>
                    <a href="" class="navlink">contact us</a>
                </div>
                <div class="navbar-bottom-right">
                    <form class="navbar-search-form">
                        <input type="text" name="search" id="search" class="input-search">
                        <span class="btn-navbar-search"><i class="fas fa-search"></i></span>
                    </form>
                    <div onclick="showCart()" class="btn-navbar-cart">
                        <i class="fas fa-shopping-cart"></i>
                        <span class="cart-total-item-quantity">121</span>
                    </div>
                    <a href="/authservlet?action=logout" class="btn-navbar-authenticate btn-navbar-logout">logout
                        <span><i class="fas fa-sign-in-alt"></i></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="mobile-navmenu">
            <div class="mobile-navmenu-header">
                <div class="nav-logo logo">
                    NepShop
                </div>
                <span class="btn-navmenu-close"><i class="fas fa-times"></i></span>
            </div>
            <div class="mobile-navlinks">
                <a href="" class="mobile-navlink">home</a>
                <a href="" class="mobile-navlink">products</a>
                <a href="" class="mobile-navlink">featured</a>
                <a href="" class="mobile-navlink">services</a>
                <a href="" class="mobile-navlink">contact us</a>
            </div>
            <a href="/includes/ecommerce/login.jsp" class="btn-navbar-authenticate btn-logout">logout
                        <span><i class="fas fa-sign-in-alt"></i></span>
            </a>
        </div>
    </nav>
    <section class="section admin">
        <div class="section-center">
            <h1 class="section-title">admin panel</h1>
            <article class="entity-tabs">
                <a href="" class="entity-tab active">user</a>
                <a href="" class="entity-tab">order</a>
                <a href="" class="entity-tab">product</a>
                <a href="" class="entity-tab">category</a>
            </article>
            <article class="entity-list">
                <div class="entity-list-header">
                    <h2>manage users</h2>
                    <div class="btn-create-open" title="Create user">
                        <span><i class="fas fa-plus-circle"></i></span>
                        create user
                    </div>
                </div>
                <div class="table-container">
                    <table class="table">
                        <thead>
                            <th>id</th>
                            <th>photo</th>
                            <th>name</th>
                            <th>email</th>
                            <th>password</th>
                            <th>gender</th>
                            <th>actions</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>
                                        <div class="table-img-container">
                                            <img src="${user.photo}" onerror="this.src='/img/defaultuser.jpg'" class="table-img"/>
                                        </div
                                    </td>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.password}</td>
                                    <td>${user.gender}</td>
                                     <td>
                                        <a class="table-action-icon btn-update-open" title="Edit user"
                                            href="/userservlet?action=populate&id=${user.id}"
                                            data-id="<c:out value="${user.id }"/>"
                                        >
                                            <i class="fas fa-edit"></i>
                                        </span>
                                        <a class="table-action-icon btn-delete-open" title="Delete user"
                                            data-id="<c:out value="${user.id }"/>"
                                        >
                                            <i class="fas fa-trash-alt"></i>
                                        </a>
                                     </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- overlay - create overlay-->
                <div class="overlay create-overlay">
                <!-- crud modal - create modal-->
                <div class="crud-modal create-modal">
                    <span class="modal-icon">
                    <i class="fas fa-save"></i>
                    </span>
                    <form action="/userservlet?action=create" method="post" class="form" enctype="multipart/form-data">
                        <a class="btn-cancel btn-crud-cancel">
                            <i class="fas fa-times"></i>
                        </a>
                        <label
                            >upload photo
                            <input type="file" name="photo"/>
                        </label>
                        <label
                            >enter name*
                            <input type="name" name="name"/>
                        </label>
                        <label
                            >enter email address*
                            <input type="email" name="email"/>
                        </label>
                            <label
                            >enter password*
                            <input type="password" name="password"/>
                        </label>
                        <label
                            >enter gender*
                            <select name="gender">
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                    <option value="others">Others</option>
                            </select>
                        </label>
                        <input type="hidden" name="action" value="create">
                        <button type="submit" class="btn-primary btn-create">create user</button>
                    </form>
                </div>
                <!-- end of crud modal -->
                </div>
                <!-- end of overlay - create overlay-->
                <!-- overlay - update overlay-->
                <div class="${flag ? 'open-overlay overlay update-overlay' : 'overlay update-overlay'}">
                <!-- crud modal- update modal -->
                <div class="crud-modal update-modal">
                    <span class="modal-icon">
                    <i class="fas fa-edit"></i>
                    </span>
                    <form class="form" action="/userservlet?action=update" method="post" enctype="multipart/form-data">
                        <a class="btn-cancel btn-update-cancel btn-crud-cancel">
                            <i class="fas fa-times"></i>
                        </a>
                        <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/>
                         <label>
                            upload photo
                            <input type="file" name="photo"/>
                        </label>
                        <label>enter name*
                            <input type="name" name="name" value="<c:out value="${user.name}"/>"/>
                        </label>
                        <label>enter email address*
                            <input type="email" name="email" value="<c:out value="${user.email}"/>"/>
                        </label>
                        <label>enter password*
                            <input type="password" name="password" value="<c:out value="${user.password}"/>"/>
                        </label>
                        <label
                            >enter gender*
                            <select name="gender">
                                <option value="male" ${user.gender == "male" ? "selected" : ""}>Male</option>
                                <option value="female" ${user.gender == "female" ? "selected" : ""}>Female</option>
                                <option value="others" ${user.gender == "others" ? "selected" : ""}>Others</option>
                            </select>
                        </label>
                        <button type="submit" class="btn-primary btn-update">update user</button>
                    </form>
                </div>
                <!-- end of crud modal -update modal -->
                </div>
                <!-- end of overlay - update overlay-->
                <!-- overlay - delete overlay-->
                <div class="overlay delete-overlay">
                <!-- delete modal -->
                <div class="delete-modal">
                    <span class="crud-modal-delete-icon">
                    <i class="fas fa-trash-alt"></i>
                    </span>
                    <h1>Are you sure?</h1>
                    <p>
                    Are you sure you want to delete this user? This action
                    cannot be undone.
                    </p>
                    <div class="delete-modal-btns">
                    <button class="btn-cancel btn-delete-cancel">cancel</button>
                    <button class="btn-delete-confirm">confirm</button>
                    </div>
                </div>
                <!-- end of delete modal -->
                </div>
                <!-- end of overlay - delete overlay-->
            </article>
        </div>
    </section>
    <footer class="footer">
        <div class="footer-center">
            <div class="footer-top">
                <div class="footer-column">
                    <div>
                        <div class="logo footer-logo">nepshop</div>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Temporibus magnam deserunt est saepe dolores libero quam sequi nihil, magni officia aperiam debitis voluptatibus, reprehenderit illum.</p>
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
    <script src="../js/app.js"></script>
</body>
</html>
