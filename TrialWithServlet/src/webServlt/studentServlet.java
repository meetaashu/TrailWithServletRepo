package webServlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.util.SpringContestBeanProviderUtility;

import Domain_Package.Student;
import Service_Package.StudentService_impl;
import Service_Package.Student_Service;





/**
 * Servlet implementation class studentServlet
 */

@WebServlet("/studentServlet")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Student s= new Student();
		
		String name=request.getParameter("name")+"";
		
		int standard=Integer.parseInt(request.getParameter("std"));
		String phNo=request.getParameter("phNo");
		String city=request.getParameter("city");
		
		s.setName(name);
		
		s.setStandard(standard);
		s.setPhNo(phNo);
		s.setCity(city);
		
		
		Student_Service service;
		service=(StudentService_impl) SpringContestBeanProviderUtility.beanProvider("Service_Package.StudentService_impl");
		
		if(service==null){
			System.out.println("cant get bean");
		}
		System.out.println(service.student_admission(s));
	
		//request.setAttribute("stu", s);
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
