/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-07-08 15:03:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.includes.dashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nepshop.model.User;

public final class category_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>NepShop || Manage Categories</title>\r\n");
      out.write("     <!-- favicon -->\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/img/favicon/apple-touch-icon.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"/img/favicon/favicon-32x32.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"/img/favicon/favicon-16x16.png\">\r\n");
      out.write("    <link rel=\"manifest\" href=\"/img/favicon/site.webmanifest\">\r\n");
      out.write("    <!-- font awesome -->\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\r\n");
      out.write("      integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("      referrerpolicy=\"no-referrer\"\r\n");
      out.write("    />\r\n");
      out.write("    <!-- Custom css -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/dashboard.css\" />\r\n");
      out.write("  </head>\r\n");
      out.write("  <body onload=\"showToastMessage('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.toast[0]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.toast[1]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("    ");
 
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
      response.setHeader("Pragma", "no-cache");
      User sessionUser = (User)session.getAttribute("user");
      if(sessionUser == null){
          response.sendRedirect("/includes/ecommerce/login.jsp");
      }
      session.removeAttribute("toast");
    
      out.write("\r\n");
      out.write("    <!-- main -->\r\n");
      out.write("     <div class=\"toast-message-container\"></div>\r\n");
      out.write("    <main class=\"main\">\r\n");
      out.write("      <!-- side panel -->\r\n");
      out.write("      <div class=\"side-panel\">\r\n");
      out.write("        <!-- side header -->\r\n");
      out.write("        <div class=\"side-panel-header\">\r\n");
      out.write("          <div class=\"btn btn-close-nav\">\r\n");
      out.write("            <i class=\"fas fa-times\"></i>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"side-panel-profile\">\r\n");
      out.write("            <div class=\"side-panel-pp-container\">\r\n");
      out.write("              <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.photo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" onerror=\"this.src='/img/defaultuser.jpg'\" alt=\"admin\"\r\n");
      out.write("              class=\"side-panel-pp\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <p class=\"side-panel-name\">\r\n");
      out.write("              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("            </p>\r\n");
      out.write("            <p class=\"side-panel-email\">\r\n");
      out.write("              ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("            </p>\r\n");
      out.write("            <a href=\"/includes/dashboard/accountsettings.jsp\" class=\"side-panel-btn-update\">update profile</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end of side panel header -->\r\n");
      out.write("        <!-- side panel nav-->\r\n");
      out.write("        <nav class=\"side-panel-nav\">\r\n");
      out.write("          <a href=\"/includes/dashboard/home.jsp\" class=\"nav-link\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-home\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">dashboard</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a href=\"/userservlet?action=list\" class=\"nav-link\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-user\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">user</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a href=\"/customerservlet?action=list\" class=\"nav-link\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-user\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">customer</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a href=\"/productservlet?action=list\" class=\"nav-link\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-home\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">product</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a href=\"/categoryservlet?action=list\" class=\"nav-link active\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-bars\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">category</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a href=\"/orderservlet?action=list\" class=\"nav-link\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-times\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">order</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a href=\"/includes/dashboard/accountsettings.jsp\" class=\"nav-link\">\r\n");
      out.write("            <span class=\"nav-link-icon\"><i class=\"fas fa-cog\"></i></span>\r\n");
      out.write("            <span class=\"nav-link-title\">settings</span>\r\n");
      out.write("          </a>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!-- end of side panel nav-->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- end of side panel -->\r\n");
      out.write("      <!-- container -->\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <!-- main header -->\r\n");
      out.write("        <div class=\"main-header\">\r\n");
      out.write("          <div class=\"btn btn-open-nav\">\r\n");
      out.write("            <i class=\"fas fa-bars\"></i>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"main-header-logo-container\">\r\n");
      out.write("            <div class=\"main-header-logo logo\">nepshop</div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"main-header-right\">\r\n");
      out.write("            <span class=\"btn-toggle-theme btn\" title=\"Toggle theme\">\r\n");
      out.write("              <i class=\"fas fa-adjust\"></i>\r\n");
      out.write("            </span>\r\n");
      out.write("            <span class=\"bell-icon btn\" title=\"Notification\">\r\n");
      out.write("              <i class=\"fas fa-bell\"></i>\r\n");
      out.write("            </span>\r\n");
      out.write("            <span class=\"main-header-name\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("            <div class=\"main-header-pp-container\">\r\n");
      out.write("              <img class=\"main-header-pp btn\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.photo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" onerror=\"this.src='/img/defaultuser.jpg'\" />\r\n");
      out.write("              <span class=\"down-arrow-icon btn\"\r\n");
      out.write("                ><i class=\"fas fa-angle-down\"></i\r\n");
      out.write("              ></span>\r\n");
      out.write("              <div class=\"profile-submenu\">\r\n");
      out.write("                <p>Signed in as <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></p>\r\n");
      out.write("                <a href=\"/includes/dashboard/accountsettings.jsp\" class=\"submenu-link\">update profile</a>\r\n");
      out.write("                <a href=\"\" class=\"submenu-link\">help</a>\r\n");
      out.write("                <a href=\"/includes/dashboard/accountsettings.jsp\" class=\"submenu-link\">settings</a>\r\n");
      out.write("                <a href=\"/authservlet?action=logout\" class=\"submenu-link btn-logout\">logout</a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end of main header -->\r\n");
      out.write("        <!-- main container -->\r\n");
      out.write("        <div class=\"main-container category-container\">\r\n");
      out.write("          <div class=\"main-content\">\r\n");
      out.write("            <h1 class=\"main-content-title\">manage category</h1>\r\n");
      out.write("            <div class=\"table-header\">\r\n");
      out.write("              <div class=\"btn-create-open btn\" title=\"Create category\">\r\n");
      out.write("                <span><i class=\"fas fa-plus-circle\"></i></span>\r\n");
      out.write("                create category\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"table-search-container\">\r\n");
      out.write("                <input type=\"text\" class=\"table-search\" placeholder=\"search name\" onkeyup=\"searchTable(2)\">\r\n");
      out.write("                <span><i class=\"fas fa-search\"></i></span>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"table-container\">\r\n");
      out.write("                    <table class=\"table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <th>id</th>\r\n");
      out.write("                            <th>name</th>\r\n");
      out.write("                            <th>description</th>\r\n");
      out.write("                            <th>actions</th>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                          </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                    <h1 class=\"table-empty-message\">no match found</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("            <!-- overlay - create overlay-->\r\n");
      out.write("            <div class=\"overlay create-overlay\">\r\n");
      out.write("              <!-- crud modal - create modal-->\r\n");
      out.write("              <div class=\"crud-modal create-modal\">\r\n");
      out.write("                <span class=\"modal-icon\">\r\n");
      out.write("                  <i class=\"fas fa-save\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                <form  action=\"/categoryservlet?action=create\" method=\"post\" class=\"form\" id=\"create-form\">\r\n");
      out.write("                  <a class=\"btn-cancel btn-crud-cancel\">\r\n");
      out.write("                    <i class=\"fas fa-times\"></i>\r\n");
      out.write("                  </a>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                        <label\r\n");
      out.write("                            >Enter name*\r\n");
      out.write("                            <input type=\"name\" name=\"name\"/>\r\n");
      out.write("                            <div class=\"message\">\r\n");
      out.write("                                <span><i class=\"fas fa-exclamation-circle\"></i></span>\r\n");
      out.write("                                <span>Name is required</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <label\r\n");
      out.write("                            >Enter description*\r\n");
      out.write("                            <input type=\"text\" name=\"description\"/>\r\n");
      out.write("                            <div class=\"message\">\r\n");
      out.write("                                <span><i class=\"fas fa-exclamation-circle\"></i></span>\r\n");
      out.write("                                <span>Description is required</span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </label>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <button type=\"submit\" class=\"btn-primary btn-create\" onclick=\"return validateForm('create-form');\">create category</button>\r\n");
      out.write("                </form>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- end of crud modal -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end of overlay - create overlay-->\r\n");
      out.write("            <!-- overlay - update overlay-->\r\n");
      out.write("            <div class=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${flag ? 'open-overlay overlay update-overlay' : 'overlay update-overlay'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("              <!-- crud modal- update modal -->\r\n");
      out.write("              <div class=\"crud-modal update-modal\">\r\n");
      out.write("                <span class=\"modal-icon\">\r\n");
      out.write("                  <i class=\"fas fa-edit\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                <form class=\"form\" action=\"/categoryservlet?action=update\" method=\"post\" id=\"update-form\">\r\n");
      out.write("                  <a class=\"btn-cancel btn-update-cancel btn-crud-cancel\">\r\n");
      out.write("                    <i class=\"fas fa-times\"></i>\r\n");
      out.write("                  </a>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      if (_jspx_meth_c_005fout_005f2(_jspx_page_context))
        return;
      out.write("\"/>\r\n");
      out.write("                    <label>Enter name*\r\n");
      out.write("                        <input type=\"name\" name=\"name\" value=\"");
      if (_jspx_meth_c_005fout_005f3(_jspx_page_context))
        return;
      out.write("\"/>\r\n");
      out.write("                        <div class=\"message\">\r\n");
      out.write("                            <span><i class=\"fas fa-exclamation-circle\"></i></span>\r\n");
      out.write("                            <span>Name is required</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <label>Enter description*\r\n");
      out.write("                        <input type=\"text\" name=\"description\" value=\"");
      if (_jspx_meth_c_005fout_005f4(_jspx_page_context))
        return;
      out.write("\"/>\r\n");
      out.write("                        <div class=\"message\">\r\n");
      out.write("                            <span><i class=\"fas fa-exclamation-circle\"></i></span>\r\n");
      out.write("                            <span>Description is required</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </label>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <button type=\"submit\" class=\"btn-primary btn-update\" onclick=\"return validateForm('update-form');\">update category</button>\r\n");
      out.write("                </form>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- end of crud modal -update modal -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end of overlay - update overlay-->\r\n");
      out.write("            <!-- overlay - delete overlay-->\r\n");
      out.write("            <div class=\"overlay delete-overlay\">\r\n");
      out.write("              <!-- delete modal -->\r\n");
      out.write("              <div class=\"delete-modal\">\r\n");
      out.write("                <span class=\"crud-modal-delete-icon\">\r\n");
      out.write("                  <i class=\"fas fa-trash-alt\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                <h1>Are you sure?</h1>\r\n");
      out.write("                <p>\r\n");
      out.write("                  Are you sure you want to delete this category? This action cannot\r\n");
      out.write("                  be undone.\r\n");
      out.write("                </p>\r\n");
      out.write("                <div class=\"delete-modal-btns\">\r\n");
      out.write("                  <a class=\"btn-cancel btn-delete-cancel\">cancel</a>\r\n");
      out.write("                  <button class=\"btn-delete-confirm\" onclick=\"return deleteData('categoryservlet');\">confirm</button>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("              <!-- end of delete modal -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end of overlay - delete overlay-->\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end main container -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- end of container -->\r\n");
      out.write("    </main>\r\n");
      out.write("    <!-- end of main -->\r\n");
      out.write("    <!-- custom js -->\r\n");
      out.write("    <script src=\"/js/dashboard.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /includes/dashboard/category.jsp(155,28) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/includes/dashboard/category.jsp(155,28) '${categories}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${categories}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /includes/dashboard/category.jsp(155,28) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("category");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                <tr>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                                    <td>\r\n");
          out.write("                                        <a class=\"table-action-icon btn-update-open\" title=\"Edit category\"\r\n");
          out.write("                                            href=\"/categoryservlet?action=populate&id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"\r\n");
          out.write("                                            data-id=\"");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\"\r\n");
          out.write("                                        >\r\n");
          out.write("                                            <i class=\"fas fa-edit\"></i>\r\n");
          out.write("                                        </span>\r\n");
          out.write("                                        <a class=\"table-action-icon btn-delete-open\" title=\"Delete category\"\r\n");
          out.write("                                            data-id=\"");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\"\r\n");
          out.write("                                        >\r\n");
          out.write("                                            <i class=\"fas fa-trash-alt\"></i>\r\n");
          out.write("                                        </a>\r\n");
          out.write("                                    </td>\r\n");
          out.write("                                </tr>\r\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /includes/dashboard/category.jsp(163,53) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.id }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /includes/dashboard/category.jsp(168,53) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.id }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent(null);
    // /includes/dashboard/category.jsp(226,58) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.id}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent(null);
    // /includes/dashboard/category.jsp(228,62) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.name}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent(null);
    // /includes/dashboard/category.jsp(235,69) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category.description}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }
}