package webServlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import Domain_Package.Admin;
import Service_Package.adminService_impl;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
    	
        super();
        System.out.println("insider servlet constructor");
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	Admin a= new Admin();
	
	String name=request.getParameter("name");
	String phone=request.getParameter("phNo");
	
//ApplicationContext context1= new ClassPathXmlApplicationContext("applicationContext.xml");
	
    a.setaName(name);
	a.setaPhNo(phone);
	 WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
	 adminService_impl service = context.getBean(adminService_impl.class);
	//adminService_impl service=new adminService_impl();
	service.populate_admin(a);
	service.getPhoneNoByName(name);
	service.getPhoneNoByNameInAdmin(name);
	//request.setAttribute("result", result);
	 //request.getRequestDispatcher("/UI/SumResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
