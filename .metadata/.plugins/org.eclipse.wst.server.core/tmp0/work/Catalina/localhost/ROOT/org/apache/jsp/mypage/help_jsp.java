/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.6
 * Generated at: 2018-05-11 04:12:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class help_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/mypage.css\" />\r\n");
      out.write("<style> \r\n");
      out.write("\r\n");
      out.write("div#contents label {\r\n");
      out.write("   display: inline-block;\r\n");
      out.write("   width: 120px;\r\n");
      out.write("/*    margin-left: 30px; */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* div#contents div { */\r\n");
      out.write("/* \tmargin: 20px; */\r\n");
      out.write("/* } */\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$(\"#id_phone\").blur(function(){\r\n");
      out.write("    \tvar num = $(this).val();\r\n");
      out.write("    \tblur(num, this)\r\n");
      out.write("\t });\r\n");
      out.write("\r\n");
      out.write("    $(\"#id_phone\").click(function(){\r\n");
      out.write("    \tvar num = $(this).val();\r\n");
      out.write("    \tfocus(num, this);\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    $(\"#pw_phone\").blur(function(){\r\n");
      out.write("    \tvar num = $(this).val();\r\n");
      out.write("    \tblur(num, this)\r\n");
      out.write("\t });\r\n");
      out.write("\r\n");
      out.write("    $(\"#pw_phone\").click(function(){\r\n");
      out.write("    \tvar num = $(this).val();\r\n");
      out.write("    \tfocus(num, this);\r\n");
      out.write("    });\r\n");
      out.write("\t\r\n");
      out.write("\tfunction focus(num, id) {\r\n");
      out.write("\t\tnum = num.replace(/[^0-9]/g, '');\r\n");
      out.write("\t\t$(id).val(num);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction blur(num, id) {\r\n");
      out.write("\t\tnum = num.replace(/[^0-9]/g, '');\r\n");
      out.write("\t\tvar tmp = '';\r\n");
      out.write("\t\ttmp += num.substr(0, 3);\r\n");
      out.write("\t\ttmp += '-';\r\n");
      out.write("\t\ttmp += num.substr(3, 4);\r\n");
      out.write("\t\ttmp += '-';\r\n");
      out.write("\t\ttmp += num.substr(7, 13);\r\n");
      out.write("\t\t$(id).val(tmp);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#btnid\").click(function(){\r\n");
      out.write("\t\tif($(\"#id_name\").val()==null||$(\"#id_name\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"이름을 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#name\").focus();\r\n");
      out.write("\t\t}else if($(\"#id_phone\").val()==null||$(\"#id_phone\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"전화번호를 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#id_phone\").focus();\r\n");
      out.write("\t\t}else{\t\r\n");
      out.write("\t\t\t$(\"#idSearch\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#btnpw\").click(function(){\r\n");
      out.write("\t\tif($(\"#id\").val()==null||$(\"#id\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"아이디를 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#id\").focus();\r\n");
      out.write("\t\t}else if($(\"#pw_name\").val()==null||$(\"#pw_name\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"이름을 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#name\").focus();\r\n");
      out.write("\t\t}else if($(\"#pw_phone\").val()==null||$(\"#pw_phone\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"전화번호를 입력하세요\");\r\n");
      out.write("\t\t\t$(\"#pw_phone\").focus();\r\n");
      out.write("\t\t}else{\t\r\n");
      out.write("\t\t\t$(\"#pwSearch\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#btnCancel1\").click(function(){\r\n");
      out.write("\t\tlocation.href=\"/00_Main.jsp\";\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#btnCancel2\").click(function(){\r\n");
      out.write("\t\tlocation.href=\"/00_Main.jsp\";\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"wrapper\">\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/top.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"contents\">\r\n");
      out.write("\t\t<h1>아이디 찾기</h1>\r\n");
      out.write("\t\t<form action=\"/IdHelper.do\" method=\"post\" id=\"idSearch\">\r\n");
      out.write("\t\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t\t<label for=\"name\">이름</label>\r\n");
      out.write("\t\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"id_name\" name=\"id_name\" /><br>\r\n");
      out.write("\t\t\t<label for=\"phone\">전화번호</label>\r\n");
      out.write("\t\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"id_phone\" name=\"id_phone\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label></label>\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"btnid\" class=\"btn btn-primary\" value=\"아이디 찾기\"/>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"btnCancel1\" class=\"btn btn-default\" value=\"취소\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<h1>비밀번호 찾기</h1>\r\n");
      out.write("\t\t<form action=\"/PwHelper.do\" method=\"post\" id=\"pwSearch\">\r\n");
      out.write("\t\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t\t<label for=\"name\">아이디</label>\r\n");
      out.write("\t\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"id\" name=\"id\" /><br>\r\n");
      out.write("\t\t\t<label for=\"name\">이름</label>\r\n");
      out.write("\t\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"pw_name\" name=\"pw_name\" /><br>\r\n");
      out.write("\t\t\t<label for=\"phone\">전화번호</label>\r\n");
      out.write("\t\t\t<input class=\"form-control\" size=\"30\" type=\"text\" id=\"pw_phone\" name=\"pw_phone\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<label></label>\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"btnpw\" class=\"btn btn-primary\" value=\"비밀번호 찾기\"/>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"btnCancel2\" class=\"btn btn-default\" value=\"취소\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"clear:both;\"></div>\r\n");
      out.write("\t<div id=\"footer\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
