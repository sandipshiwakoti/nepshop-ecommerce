<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page
import="com.nepshop.model.User , java.util.List , java.util.ArrayList, java.util.Arrays" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>NepShop || Dashboard</title>
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
  <body>
    <% 
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
      response.setHeader("Pragma", "no-cache");
      User sessionUser = (User)session.getAttribute("user");
      if(sessionUser == null){
          List<String> toast = new ArrayList<String>(Arrays.asList("Your session has expired. Please try login again.", "error"));
          session.setAttribute("toast", toast);
          response.sendRedirect("/includes/ecommerce/login.jsp");
      }
      
    %>
    <!-- main -->
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
              <img src="${sessionScope.user.photo}" alt="admin"
              class="side-panel-pp" onerror="this.src='/img/defaultuser.jpg'" />
            </div>
            <p class="side-panel-name">
              ${sessionScope.user.name}
            </p>
            <p class="side-panel-email">
              ${sessionScope.useremailphoto}
            </p>
            <a
              href="/includes/dashboard/accountsettings.jsp"
              class="side-panel-btn-update"
              >update profile</a>
          </div>
        </div>
        <!-- end of side panel header -->
        <!-- side panel nav-->
        <nav class="side-panel-nav">
          <a href="/includes/dashboard/home.jsp" class="nav-link active">
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
          <a href="/productservlet?action=list" class="nav-link">
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
                <a
                  href="/includes/dashboard/accountsettings.jsp"
                  class="submenu-link"
                  >update profile</a
                >
                <a href="" class="submenu-link">help</a>
                <a
                  href="/includes/dashboard/accountsettings.jsp"
                  class="submenu-link"
                  >settings</a
                >
                <a href="/authservlet?action=logout" class="submenu-link btn-logout">logout</a>
              </div>
            </div>
          </div>
        </div>
        <!-- end of main header -->
        <!-- main container -->
        <section class="main-container dashboard-container">
          <!-- welcome dashboard -->
          <div class="main-content">
            <h1 class="main-content-title">dashboard</h1>
            <h1 class="welcome-message-title">Hello, <span>${sessionScope.user.name}</span> 👋</h1>
            <p class="welcome-message-subtitle">
              Welcome to Nepshop web app! Here, you can manage customers,
              orders, products and many more in a single application. We have your
              back now. 😎
            </p>
          </div>
          <!-- end of welcome dashboard -->
          <!-- overview -->
          <div class="main-content">
            <h1 class="main-content-title">overall overview</h1>
            <div class="main-content-cards">
              <div class="main-content-card">
                <img src="/img/customer.png" alt="" />
                <h1>25</h1>
                <p>customers</p>
              </div>
              <div class="main-content-card">
                <img src="/img/admin.png" alt="" />
                <h1>4</h1>
                <p>admins</p>
              </div>
              <div class="main-content-card">
                <img src="/img/categories.png" alt="" />
                <h1>10</h1>
                <p>categories</p>
              </div>
              <div class="main-content-card">
                <img src="/img/product.png" alt="" />
                <h1>150</h1>
                <p>products</p>
              </div>
              <div class="main-content-card">
                <img src="/img/order.png" alt="" />
                <h1>110</h1>
                <p>orders</p>
              </div>
              <div class="main-content-card">
                <img src="/img/sale.png" alt="" />
                <h1>10000</h1>
                <p>sales</p>
              </div>
            </div>
          </div>
          <!-- end of overview -->
        </section>
        <!-- end main container -->
      </div>
      <!-- end of container -->
    </main>
    <!-- end of main -->
    <script src="/js/dashboard.js"></script>
  </body>
</html>
