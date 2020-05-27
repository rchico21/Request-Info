package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

@WebServlet("/lab3/requestInfo")
public class requestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
         
        Enumeration<String> allValues = request.getParameterNames();
        ArrayList<String> parameterHead = new ArrayList<String>();
        
        Enumeration <String> header = request.getHeaderNames();
        ArrayList <String> headerName = new ArrayList<String>();
        
        while (allValues.hasMoreElements()){
        	String pValues = (String) allValues.nextElement();
        	parameterHead.add(pValues);
        }
        
        while (header.hasMoreElements()) {
        	String name = (String) header.nextElement();
        	headerName.add(name);
        }
        
        out.println("<!DOCTYPE html>");
        out.println( "<html>" );
        out.println("<head>");
        out.print(" <meta charset=\"uft-8\"> ");
        out.println( "<title>Display Request Info</title>" ); 
        out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
        out.println("</head");
        
        out.println( "<body>" );
        
        out.println("<h1>");
        out.println("Request Parameters");
        out.println("</h1>");
        out.println("Lab 3");
        out.println("<h4>");
        out.println("The following ");
        out.println(request.getMethod());
        out.println("request was submitted on: ");
        out.println(new Date());
        out.println("</h4>");
        
        out.println("<h2>");
        out.println("Request Parameters");
        out.println("</h2>");
        
        out.println("<table class = \"table table-striped\">");
        
        out.println("<tr>");
        out.println("<td>");
        out.println("<b>Parameter Name</b> ");
        out.println("</td>");
        out.println("<td>");
        out.println("<b>Parameter Value</b>");
        out.println("</td>");
        out.println("</tr>");
        
        for(String value: parameterHead){
        	out.println("<tr>");
        	out.println("<td>");
        	out.println(value);
        	out.println("</td>");
        	String [] values = request.getParameterValues(value);
        	out.println("<td>");
        	for(int i = 0; i < values.length; i++){
        		out.println(values[i] + " ");
        	}
        	out.println("</td>");
        	out.println("</tr>");
        }
        
        for (String newValue: parameterHead){
        	String [] newValues = request.getParameterValues(newValue);
        }
        
        out.println("</table>");
        
        out.println("<h2>");
        out.println("Header Information");
        out.println("</h2>");
        
        out.println("<table class = \"table table-striped\" >");
        
        out.println("<tr>");
        out.println("<td>");
        out.println("<b>Header Field</b> ");
        out.println("</td>");
        out.println("<td>");
        out.println("<b>Header Values</b>");
        out.println("</td>");
        out.println("</tr>");
        
        for (String heads: headerName){
        	out.println("<tr>");
        	out.println("<td>");
        	out.println(heads);
        	out.println("</td>");
        	String newHeader = request.getHeader(heads);
        	out.println("<td>");
        	out.println(newHeader + " ");
        	out.println("</td>");
        	out.println("</tr>");
        }
        
        
        
        out.println("</table>");
        
        out.println( "</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}