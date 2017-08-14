package webServlt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import Domain_Package.Mail;
import Service_Package.ComposeService;

/**
 * Servlet implementation class ComposeSaveServlet
 */
@WebServlet("/ComposeSaveServlet")
public class ComposeSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	Mail m =new Mail();
	String toUserId=request.getParameter("uId");
	String sub= request.getParameter("sub");
	String msg=request.getParameter("msg");
	Cookie ck[]=request.getCookies();
	String fromUId=ck[0].getValue();
	
	Date dt= new Date();
	int y, month,d;
	y=dt.getYear()+1900;
	month=dt.getMonth()+1;
	d=dt.getDate();
	String eDate= y+"-"+month+"-"+d;

	m.seteDate(eDate);
	m.setEmailText(msg);
	m.setFromUserId(fromUId);
	m.setSubject(sub);
	m.setToUserId(toUserId);
	
	
	
	
	WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
	ComposeService service= context.getBean(Service_Package.ComposeService_impl.class);
	String result=service.addComposeMessage(m);
	response.setContentType("text/html");  
    PrintWriter out = response.getWriter();
	List<Map<String,Object>> result2=service.getInbox(fromUId);
	if(result2==null){
		out.println("No mail in inbox");
	}else{
		for(Map<String,Object> row: result2)
		{
			String emailNo=row.get("EmailNo").toString();
			String eDate1=row.get("EmailDate").toString();
			String fId=row.get("FromUserId").toString();
			String sub1=row.get("MailSubject").toString();
			out.println(emailNo+" Date:"+eDate1+"FromUserID:"+fId+"Mail Subject:"+sub1);
			out.println("/n");
			out.println("<br>");
		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
