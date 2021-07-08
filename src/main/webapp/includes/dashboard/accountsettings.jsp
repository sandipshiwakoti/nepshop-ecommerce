<%@ page language="java" contentType="text/html; charset=UTF-8"
isELIgnored="false"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
import="com.nepshop.model.User" %>
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
              <img src="${sessionScope.user.photo}" alt="admin"
              class="side-panel-pp" onerror="this.src='/img/defaultuser.jpg'" />
            </div>
            <p class="side-panel-name">
              ${sessionScope.user.name}
            </p>
            <p class="side-panel-email">
              ${sessionScope.user.email}
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
          <a
            href="/includes/dashboard/accountsettings.jsp"
            class="nav-link active"
          >
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
              <img class="main-header-pp btn" src="${sessionScope.user.photo}" onerror="this.src='/img/defaultuser.jpg'"/>
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
        <div class="main-container account-settings-container">
          <!-- account settings page-->
          <div class="account-settings-page inner-page">
            <!-- settings tab -->
            <div class="settings-tabs">
              <h1 class="main-content-title">my account</h1>
              <div>
                <button class="btn-settings-tab active" data-id="tab-user-info">
                  user information
                </button>
                <button class="btn-settings-tab" data-id="tab-user-password">
                  password
                </button>
                <button class="btn-settings-tab" data-id="tab-account-deletion">
                  account deletion
                </button>
              </div>
            </div>
            <!-- end of settings tab -->
            <!-- settings tab content - tab user info-->
            <div class="settings-tab-content active" id="tab-user-info">
              <!-- settings tab header - tab user info -->
              <div class="settings-tab-header">
                <div class="settings-pp-container">
                  <img
                    src="${sessionScope.user.photo}"
                    alt="user photo"
                    class="settings-pp"
                    onerror="this.src='/img/defaultuser.jpg'"
                  />
                </div>
              </div>
              <!-- end of settings tab header - tab user info -->
              <!-- settings tab form - tab user info -->
              <form id="update-info-form" action="/userservlet?action=update_ac_info" method="post" enctype="multipart/form-data">
                <div class="settings-tab-form" >
                  <input type="hidden" name="id" value="${sessionScope.user.id}">
                  <div>
                    <label>upload your photo</label>
                    <input
                      type="file"
                      id="file-upload"
                      name="photo"
                      class="not-mandatory"
                    />
                    <div class="message">hidden</div>
                  </div>
                  <div>
                    <label>enter your username*</label>
                    <input type="text" name="name" value="${sessionScope.user.name}"/>
                    <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Username is required</span>
                    </div>
                  </div>
                  <div>
                    <label>enter your email address*</label>
                    <input type="text" name="email" value="${sessionScope.user.email}"/>
                    <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Email address is required</span>
                    </div>
                  </div>
                  <div>
                    <label>enter your gender</label>
                    <input type="text" name="gender" value="${sessionScope.user.gender}"/>
                    <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Gender is required</span>
                    </div>
                  </div>
                </div>
                <button type="submit" class="btn btn-save-changes" onclick="return validateForm('update-info-form');">save changes</button>
              </form>
              <!-- end of settings tab form - tab user info -->
            </div>
            <!-- end of settings tab content - tab user info-->
            <!-- settings tab content - tab user password-->
            <div class="settings-tab-content" id="tab-user-password">
              <!-- settings-tab-form - tab user password -->
              <form id="update-password-form" action="/userservlet?action=update_ac_password" method="post">
                 <div class="settings-tab-form">
                  <input type="hidden" name="id" value="${sessionScope.user.id}">
                  <div>
                    <label>enter current password*</label>
                    <input type="password" name="old-password"/>
                   <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Current password is required</span>
                    </div>
                  </div>
                  <div>
                    <label>enter new password*</label>
                    <input type="password" name="new-password"/>
                    <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>New password is required</span>
                    </div>
                  </div>
                  <div>
                    <label>enter confirm password*</label>
                    <input type="password" name="confirm-password"/>
                    <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Confirm password is required</span>
                    </div>
                  </div>
                </div>
                <button class="btn btn-save-changes btn-change-password" onclick="return validateForm('update-password-form');">
                    change password
                </button>
              </form>
              <!-- end of settings-tab-form - tab user password -->
            </div>
            <!-- end of settings tab content - tab user password-->
            <!-- settings tab content - tab account deletion-->
            <div class="settings-tab-content" id="tab-account-deletion">
              <!-- settings-tab-form - tab account deletion -->
              <div class="settings-tab-form">
                <div>
                  <label>enter current password*</label>
                  <input type="password" name="password" id="delete-ac-password" />
                  <div class="message">
                      <span><i class="fas fa-exclamation-circle"></i></span>
                      <span>Current password is required</span>
                  </div>
                </div>
              </div>
              <button class="btn btn-save-changes btn-delete-account" >
                  delete account
                </button>
              <!-- end of settings-tab-form - tab account deletion -->
            </div>
            <!-- end of settings tab content - tab account deletion-->
            <!-- overlay - delete overlay -->
            <div class="overlay delete-account-overlay">
              <div class="delete-modal">
                <span class="modal-delete-icon">
                  <i class="fas fa-trash-alt"></i>
                </span>
                <h1>Are you sure?</h1>
                <p>
                  Are you sure you want to delete your account? This action
                  cannot be undone.
                </p>
                <form class="delete-ac-form" action="/userservlet?action=delete_ac" method="post">
                  <div class="delete-modal-btns" >
                    <input type="hidden" name="id" value="${sessionScope.user.id}" >
                    <input type="hidden" name="password"/>
                    <a class="btn-delete-cancel">cancel</a>
                    <button class="btn-delete-confirm">confirm</button>
                  </div>
                </form>
              </div>
            </div>
            <!-- end of overlay - delete overlay -->
          </div>
          <!-- end of account setttings page-->
        </div>
        <!-- end main container -->
      </div>
      <!-- end of container -->
    </main>
    <!-- end of main -->
    <script src="/js/dashboard.js"></script>
  </body>
</html>
