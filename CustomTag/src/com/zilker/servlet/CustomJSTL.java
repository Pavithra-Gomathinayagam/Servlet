package com.zilker.servlet;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomJSTL extends SimpleTagSupport {
	private String message;

	   public void setMessage(String msg) {
	      this.message = msg;
	   }
	   StringWriter sw = new StringWriter();
	   public void doTag()
	   
	   throws JspException, IOException {
	      if (message != null) {
	         /* Use message from attribute */
	         JspWriter out = getJspContext().getOut();
	         out.println( message );
	      } else {
	         /* use message from the body */
	         getJspBody().invoke(sw);
	         getJspContext().getOut().println(sw.toString());
	      }
	   }
}
