/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.6
 * Generated at: 2018-05-11 05:02:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Service.MemberService;
import DTO.Member;
import java.util.ArrayList;

public final class mypage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/E:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Semi/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1090214156000L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1521608251712L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("DTO.Member");
    _jspx_imports_classes.add("Service.MemberService");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/mypage.css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#btnConfirm\").click(function(){\r\n");
      out.write("\t\tif($(\"#password\").val()==null||$(\"#password\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"회원 정보 수정 시 새로 사용할 비밀번호를 입력해야합니다\");\r\n");
      out.write("\t\t\t$(\"#password\").focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#memberInfo\").submit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#btnCancel\").click(function() {\r\n");
      out.write("\t\tlocation.href=\"/00_Main.jsp\";\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style> \r\n");
      out.write("div#contents{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("div#contents label {\r\n");
      out.write("   display: inline-block;\r\n");
      out.write("   width: 120px;\r\n");
      out.write("   margin-left: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div#contents div {\r\n");
      out.write("\tmargin: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/top.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"aside\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "aside.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"contents\">\r\n");
      out.write("\t\t<h1>회원정보 수정</h1>\r\n");
      out.write("\t\t<form action=\"/MemberUpdate.do\" method=\"post\" id=\"memberInfo\"> \r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"id\">아이디</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"id\" name=\"id\" value=");
      out.print(session.getAttribute("id") );
      out.write(" readonly />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"password\">비밀번호 </label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"password\" id=\"password\" name=\"password\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"password2\">비밀번호 확인</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"password\" id=\"password2\" name=\"password2\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"name\">이름</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"name\" name=\"name\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.uName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"nick\">닉네임</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"nick\" name=\"nick\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.uNick }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" /><br>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"phone\">전화번호</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"phone\" name=\"phone\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.uPNo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" /><br>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"email\">이메일</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"email\" name=\"email\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.uEmail }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" /><br>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t<label for=\"location\">지역(주소)</label>\r\n");
      out.write("\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"addr\" name=\"addr\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m.uAddr }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" /><br>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t<label></label>\r\n");
      out.write("\t\t<input type=\"button\" id=\"btnConfirm\" class=\"btn btn-primary\" value=\"확인\"/>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<input type=\"button\" id=\"btnCancel\" class=\"btn btn-default\" value=\"취소\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t<div class=\"clear\"></div>\r\n");
      out.write("\t<div id=\"footer\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
