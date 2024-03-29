/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-07-08 13:59:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.includes.ecommerce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nepshop.model.User;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("  \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>NepShop || Login</title>\r\n");
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
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.css\" />\r\n");
      out.write("  </head>\r\n");
      out.write("  <body onload=\"showToastMessage('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.toast[0]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.toast[1]}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("')\">\r\n");
      out.write("    ");

      session.removeAttribute("toast");
    
      out.write("\r\n");
      out.write("    <div class=\"toast-message-container\"></div>\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("      <div class=\"navbar-top\">\r\n");
      out.write("        <div class=\"nav-logo logo\">NepShop</div>\r\n");
      out.write("        <div class=\"navbar-top-right\">\r\n");
      out.write("          <form action=\"/productservlet\" class=\"navbar-search-form\">\r\n");
      out.write("            <input type=\"text\" name=\"search-field\" id=\"search\" class=\"input-search\" />\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"search-products-by-name\"/>\r\n");
      out.write("            <button class=\"btn-navbar-search\" type=\"submit\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("          </form>\r\n");
      out.write("          <div onclick=\"showCart()\" class=\"btn-navbar-cart\">\r\n");
      out.write("            <i class=\"fas fa-shopping-cart\"></i>\r\n");
      out.write("            <span class=\"cart-total-item-quantity\">121</span>\r\n");
      out.write("          </div>\r\n");
      out.write("          <span class=\"btn-navmenu-open\"><i class=\"fas fa-bars\"></i></span>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"navbar-bottom\">\r\n");
      out.write("        <div class=\"navbar-bottom-center\">\r\n");
      out.write("          <div class=\"navlinks\">\r\n");
      out.write("            <a href=\"/\" class=\"navlink\">home</a>\r\n");
      out.write("            <a href=\"/productservlet?action=display-all-products\" class=\"navlink\">products</a>\r\n");
      out.write("            <a href=\"\" class=\"navlink\">featured</a>\r\n");
      out.write("            <a href=\"\" class=\"navlink\">services</a>\r\n");
      out.write("            <a href=\"\" class=\"navlink\">contact us</a>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"navbar-bottom-right\">\r\n");
      out.write("            <form class=\"navbar-search-form\">\r\n");
      out.write("              <input\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                name=\"search\"\r\n");
      out.write("                class=\"input-search\"\r\n");
      out.write("              />\r\n");
      out.write("              <span class=\"btn-navbar-search\"\r\n");
      out.write("                ><i class=\"fas fa-search\"></i\r\n");
      out.write("              ></span>\r\n");
      out.write("            </form>\r\n");
      out.write("            <div onclick=\"showCart()\" class=\"btn-navbar-cart\">\r\n");
      out.write("              <i class=\"fas fa-shopping-cart\"></i>\r\n");
      out.write("               <span class=\"cart-total-item-quantity\">121</span>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"mobile-navmenu\">\r\n");
      out.write("        <div class=\"mobile-navmenu-header\">\r\n");
      out.write("          <div class=\"nav-logo logo\">NepShop</div>\r\n");
      out.write("          <span class=\"btn-navmenu-close\"><i class=\"fas fa-times\"></i></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"mobile-navlinks\">\r\n");
      out.write("          <a href=\"/\" class=\"mobile-navlink\">home</a>\r\n");
      out.write("          <a href=\"/productservlet?action=display-all-products\" class=\"mobile-navlink\">products</a>\r\n");
      out.write("          <a href=\"\" class=\"mobile-navlink\">featured</a>\r\n");
      out.write("          <a href=\"\" class=\"mobile-navlink\">services</a>\r\n");
      out.write("          <a href=\"\" class=\"mobile-navlink\">contact us</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <section class=\"section login\">\r\n");
      out.write("      <div class=\"login-center\">\r\n");
      out.write("        <h1>login to your account</h1>\r\n");
      out.write("        <form\r\n");
      out.write("          class=\"login-form\"\r\n");
      out.write("          action=\"/authservlet?action=login\"\r\n");
      out.write("          method=\"post\"\r\n");
      out.write("        >\r\n");
      out.write("          <label for=\"email\">\r\n");
      out.write("            enter your email*\r\n");
      out.write("            <input type=\"text\" name=\"email\" id=\"email\" />\r\n");
      out.write("            <span class=\"message\">email is required</span>\r\n");
      out.write("          </label>\r\n");
      out.write("          <label for=\"password\">\r\n");
      out.write("            enter your password*\r\n");
      out.write("            <input type=\"password\" name=\"password\" id=\"password\"/>\r\n");
      out.write("            <span class=\"message\">password is required</span>\r\n");
      out.write("          </label>\r\n");
      out.write("          <label for=\"role\">\r\n");
      out.write("            select your role*\r\n");
      out.write("            <select name=\"role\">\r\n");
      out.write("              <option value=\"customer\">customer</option>\r\n");
      out.write("              <option value=\"admin\">admin</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <span class=\"message\">password is required</span>\r\n");
      out.write("          </label>\r\n");
      out.write("          <button type=\"submit\" type=\"submit\" onclick=\"return validateForm('login-form');\" class=\"btn-login\">login</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div>\r\n");
      out.write("          <a href=\"\">register account?</a>\r\n");
      out.write("          <a href=\"\">lost password?</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <footer class=\"footer\">\r\n");
      out.write("      <div class=\"footer-center\">\r\n");
      out.write("        <div class=\"footer-top\">\r\n");
      out.write("          <div class=\"footer-column\">\r\n");
      out.write("            <div>\r\n");
      out.write("              <div class=\"logo footer-logo\">nepshop</div>\r\n");
      out.write("              <p>\r\n");
      out.write("                Lorem ipsum dolor sit amet consectetur adipisicing elit.\r\n");
      out.write("                Temporibus magnam deserunt est saepe dolores libero quam sequi\r\n");
      out.write("                nihil, magni officia aperiam debitis voluptatibus, reprehenderit\r\n");
      out.write("                illum.\r\n");
      out.write("              </p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"footer-column\">\r\n");
      out.write("            <h1>information</h1>\r\n");
      out.write("            <div>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">about us</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">faq</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">terms and conditions</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">contact us</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">help</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"footer-column\">\r\n");
      out.write("            <h1>customer service</h1>\r\n");
      out.write("            <div>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">payment methods</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">money-back returns</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">shipping</a>\r\n");
      out.write("              <a href=\"\" class=\"footer-link\">privacy policy</a>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"footer-column\">\r\n");
      out.write("            <h1>get in touch</h1>\r\n");
      out.write("            <div>\r\n");
      out.write("              <span>tinkune, kathmandu</span>\r\n");
      out.write("              <span>Nepal</span>\r\n");
      out.write("              <span>info@nepshop.com</span>\r\n");
      out.write("              <span>+9779841258748</span>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer-bottom\">\r\n");
      out.write("          <span>Copyright © 2021 NepShop- All Rights Reserved.</span>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("     <!-- cart -->\r\n");
      out.write("    <div class=\"cart-overlay\">\r\n");
      out.write("      <aside class=\"cart\">\r\n");
      out.write("        <span class=\"btn-close-cart\">\r\n");
      out.write("          <i class=\"fas fa-times\"></i>\r\n");
      out.write("        </span>\r\n");
      out.write("        <h1 class=\"cart-title\">shopping cart</h1>\r\n");
      out.write("        <div class=\"cart-content\">\r\n");
      out.write("          <div class=\"cart-items\">\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"order-summary\">\r\n");
      out.write("            <h1 class=\"order-summary-title\">order summary</h1>\r\n");
      out.write("            <div>\r\n");
      out.write("              <span>subtotal cost</span>\r\n");
      out.write("              <span class=\"cart-subtotal-cost\">Rs. 8000</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("              <span>shipping cost</span>\r\n");
      out.write("              <span  class=\"cart-shipping-cost\">Rs. 100</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("              <span>total cost</span>\r\n");
      out.write("              <span class=\"cart-total-cost\">Rs. 8100</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <a href=\"/includes/ecommerce/customer.jsp\" class=\"btn-checkout\">checkout now</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </aside>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"/js/app.js\"></script>\r\n");
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
}
