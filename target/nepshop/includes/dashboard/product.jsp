<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
import="com.nepshop.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>NepShop || Manage Products</title>
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
    <link rel="stylesheet" href="/css/dashboard.css" />
  </head>
  <body onload="showToastMessage('${sessionScope.toast[0]}', '${sessionScope.toast[1]}')">
    <% 
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
      response.setHeader("Pragma", "no-cache");
      User sessionUser = (User)session.getAttribute("user");
      if(sessionUser == null){
          response.sendRedirect("/includes/ecommerce/login.jsp");
      }
      session.removeAttribute("toast");
    %>
    <!-- main -->
     <div class="toast-message-container"></div>
    <main class="main">
      <!-- side panel -->
      <div class="side-panel">
        <!-- side header -->
        <div class="side-panel-header">
          <div class="btn btn-close-nav">
            <i class="fas fa-times"></i>
          </div>
          <div class="side-panel-profile">
            <div class="side-panel-pp-container">
              <img src="${sessionScope.user.photo}" onerror="this.src='/img/defaultuser.jpg'" alt="admin"
              class="side-panel-pp" />
            </div>
            <p class="side-panel-name">
              ${sessionScope.user.name}
            </p>
            <p class="side-panel-email">
              ${sessionScope.user.email}
            </p>
            <a href="/includes/dashboard/accountsettings.jsp" class="side-panel-btn-update">update profile</a>
          </div>
        </div>
        <!-- end of side panel header -->
        <!-- side panel nav-->
        <nav class="side-panel-nav">
          <a href="/includes/dashboard/home.jsp" class="nav-link">
            <span class="nav-link-icon"><i class="fas fa-home"></i></span>
            <span class="nav-link-title">dashboard</span>
          </a>
          <a href="/userservlet?action=list" class="nav-link">
            <span class="nav-link-icon"><i class="fas fa-user"></i></span>
            <span class="nav-link-title">user</span>
          </a>
          <a href="/customerservlet?action=list" class="nav-link">
            <span class="nav-link-icon"><i class="fas fa-user"></i></span>
            <span class="nav-link-title">customer</span>
          </a>
          <a href="/productservlet?action=list" class="nav-link active">
            <span class="nav-link-icon"><i class="fas fa-home"></i></span>
            <span class="nav-link-title">product</span>
          </a>
          <a href="/categoryservlet?action=list" class="nav-link">
            <span class="nav-link-icon"><i class="fas fa-bars"></i></span>
            <span class="nav-link-title">category</span>
          </a>
          <a href="/orderservlet?action=list" class="nav-link">
            <span class="nav-link-icon"><i class="fas fa-times"></i></span>
            <span class="nav-link-title">order</span>
          </a>
          <a href="/includes/dashboard/accountsettings.jsp" class="nav-link">
            <span class="nav-link-icon"><i class="fas fa-cog"></i></span>
            <span class="nav-link-title">settings</span>
          </a>
        </nav>
        <!-- end of side panel nav-->
      </div>
      <!-- end of side panel -->
      <!-- container -->
      <div class="container">
        <!-- main header -->
        <div class="main-header">
          <div class="btn btn-open-nav">
            <i class="fas fa-bars"></i>
          </div>
          <div class="main-header-logo-container">
            <div class="main-header-logo logo">nepshop</div>
          </div>
          <div class="main-header-right">
            <span class="btn-toggle-theme btn" title="Toggle theme">
              <i class="fas fa-adjust"></i>
            </span>
            <span class="bell-icon btn" title="Notification">
              <i class="fas fa-bell"></i>
            </span>
            <span class="main-header-name">${sessionScope.user.name}</span>
            <div class="main-header-pp-container">
              <img class="main-header-pp btn" src="${sessionScope.user.photo}" onerror="this.src='/img/defaultuser.jpg'" />
              <span class="down-arrow-icon btn"
                ><i class="fas fa-angle-down"></i
              ></span>
              <div class="profile-submenu">
                <p>Signed in as <span>${sessionScope.user.email}</span></p>
                <a href="/includes/dashboard/accountsettings.jsp" class="submenu-link">update profile</a>
                <a href="" class="submenu-link">help</a>
                <a href="/includes/dashboard/accountsettings.jsp" class="submenu-link">settings</a>
                <a href="/authservlet?action=logout" class="submenu-link btn-logout">logout</a>
              </div>
            </div>
          </div>
        </div>
        <!-- end of main header -->
        <!-- main container -->
        <div class="main-container product-container">
          <div class="main-content">
            <h1 class="main-content-title">manage products</h1>
            <div class="table-header">
              <div class="btn-create-open btn" title="Create product">
                <span><i class="fas fa-plus-circle"></i></span>
                create product
              </div>
              <div class="table-search-container">
                <input type="text" class="table-search" placeholder="search name" onkeyup="searchTable(3)">
                <span><i class="fas fa-search"></i></span>
              </div>
            </div>
            <div class="table-container">
                    <table class="table">
                        <thead>
                            <th>id</th>
                            <th>photo</th>
                            <th>name</th>
                            <th>description</th>
                            <th>price</th>
                            <th>category</th>
                            <th>company</th>
                            <th>actions</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${products}" var="product">
                                <tr>
                                    <td>${product.id}</td>
                                    <td>
                                        <div class="table-img-container">
                                            <img src="${product.photo}" onerror="this.src='/img/default.jpg'" class="table-img"/>
                                        </div>
                                    </td>
                                    <td>${product.name}</td>
                                    <td>${product.description}</td>
                                    <td>${product.price}</td>
                                    <td>${product.categoryId}</td>
                                    <td>${product.company}</td>
                                    <td>
                                        <a class="table-action-icon btn-update-open" title="Edit product"
                                            href="/productservlet?action=populate&id=${product.id}"
                                            data-id="<c:out value="${product.id }"/>"
                                        >
                                            <i class="fas fa-edit"></i>
                                        </span>
                                        <a class="table-action-icon btn-delete-open" title="Delete product"
                                            data-id="<c:out value="${product.id }"/>"
                                        >
                                            <i class="fas fa-trash-alt"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                          </tbody>
                    </table>
                    <h1 class="table-empty-message">no match found</h1>
                </div>
            <!-- overlay - create overlay-->
            <div class="overlay create-overlay">
              <!-- crud modal - create modal-->
              <div class="crud-modal create-modal">
                <span class="modal-icon">
                  <i class="fas fa-save"></i>
                </span>
                <form  action="/productservlet?action=create" method="post" class="form" enctype="multipart/form-data" id="create-form">
                  <a class="btn-cancel btn-crud-cancel">
                    <i class="fas fa-times"></i>
                  </a>
                  <div class="form-group">
                    <label
                            >Upload photo
                            <input type="file" name="photo"/>
                            <div class="message">
                              <span><i class="fas fa-exclamation-circle"></i></span>
                              <span>Photo is required</span>
                            </div>
                        </label>
                        <label
                            >Enter name*
                            <input type="name" name="name"/>
                            <div class="message">
                                <span><i class="fas fa-exclamation-circle"></i></span>
                                <span>Name is required</span>
                            </div>
                        </label>
                        <label
                            >Enter description*
                            <input type="text" name="description"/>
                            <div class="message">
                                <span><i class="fas fa-exclamation-circle"></i></span>
                                <span>Description is required</span>
                            </div>
                        </label>
                        <label
                            >Enter price*
                            <input type="number" name="price"/>
                            <div class="message">
                                <span><i class="fas fa-exclamation-circle"></i></span>
                                <span>Price is required</span>
                            </div>
                        </label>
                        <label
                            >Enter category*
                            <select name="category-id" required>
                                    <option hidden disabled selected></option>
                                    <c:forEach items="${categories}" var="category">
                                      <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                            </select>
                            <div class="message">
                                <span><i class="fas fa-exclamation-circle"></i></span>
                                <span>Category is required</span>
                            </div>
                        </label>
                        <label
                            >Enter company*
                            <input type="text" name="company"/>
                            <div class="message">
                                <span><i class="fas fa-exclamation-circle"></i></span>
                                <span>Company is required</span>
                            </div>
                        </label>
                  </div>
                  <button type="submit" class="btn-primary btn-create" onclick="return validateForm('create-form');">create product</button>
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
                <form class="form" action="/productservlet?action=update" method="post" enctype="multipart/form-data" id="update-form">
                  <a class="btn-cancel btn-update-cancel btn-crud-cancel">
                    <i class="fas fa-times"></i>
                  </a>
                  <div class="form-group">
                    <input type="hidden" name="id" value="<c:out value="${product.id}"/>"/>
                    <label>
                        Upload photo
                        <input type="file" name="photo" class="not-mandatory"/>
                        <div class="message">
                          hidden
                        </div>
                    </label>
                    <label>Enter name*
                        <input type="name" name="name" value="<c:out value="${product.name}"/>"/>
                        <div class="message">
                            <span><i class="fas fa-exclamation-circle"></i></span>
                            <span>Name is required</span>
                        </div>
                    </label>
                    <label>Enter description*
                        <input type="text" name="description" value="<c:out value="${product.description}"/>"/>
                        <div class="message">
                            <span><i class="fas fa-exclamation-circle"></i></span>
                            <span>Description is required</span>
                        </div>
                    </label>
                    <label>Enter price*
                        <input type="number" name="price" value="<c:out value="${product.price}"/>"/>
                        <div class="message">
                          <span><i class="fas fa-exclamation-circle"></i></span>
                          <span>Price is required</span>
                        </div>
                    </label>
                    <label
                        >Enter category*
                        <select name="category-id" required>
                            <option hidden disabled selected></option>
                            <c:forEach items="${categories}" var="category">
                              <option value="${category.id}" ${product.categoryId == category.id ? "selected" : ""}>${category.name}</option>
                            </c:forEach>
                        </select>
                        <div class="message">
                          <span><i class="fas fa-exclamation-circle"></i></span>
                          <span>category is required</span>
                        </div>
                    </label>
                    <label>Enter company*
                        <input type="text" name="company" value="<c:out value="${product.company}"/>"/>
                        <div class="message">
                          <span><i class="fas fa-exclamation-circle"></i></span>
                          <span>Company is required</span>
                        </div>
                    </label>
                  </div>
                  <button type="submit" class="btn-primary btn-update" onclick="return validateForm('update-form');">update product</button>
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
                  Are you sure you want to delete this product? This action cannot
                  be undone.
                </p>
                <div class="delete-modal-btns">
                  <a class="btn-cancel btn-delete-cancel">cancel</a>
                  <button class="btn-delete-confirm" onclick="return deleteData('productservlet');">confirm</button>
                </div>
              </div>
              <!-- end of delete modal -->
            </div>
            <!-- end of overlay - delete overlay-->
          </div>
        </div>
        <!-- end main container -->
      </div>
      <!-- end of container -->
    </main>
    <!-- end of main -->
    <!-- custom js -->
    <script src="/js/dashboard.js"></script>
  </body>
</html>
