package webServlt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int fn=Integer.parseInt(request.getParameter("fn"));
		int sn=Integer.parseInt(request.getParameter("sn"));
		int tn=Integer.parseInt(request.getParameter("tn"));
		int result=fn+sn+tn;
		System.out.println("result is::"+result);
		
	    request.setAttribute("result", result);
	   
	    //request.getSession().setAttribute("resultSession", 122);
	    
	    //response.sendRedirect("/TrialWithServlet/UI/SumResult.jsp");
	    request.getRequestDispatcher("/UI/SumResult.jsp").forward(request, response);
	    //RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
	    //dispatcher.forward(request, response);
	    //return;

		
		//System.out.println("Hi..this is addition servlet");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
