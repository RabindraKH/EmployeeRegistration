package com.registrationapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;

@WebServlet("/update")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("email",email);
		request.setAttribute("mobile", mobile);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email= request.getParameter("email");
		 String mobile= request.getParameter("mobile");
		 
		 DAOService service = new DAOServiceImpl();
		 service.connectDB();
		 
		service.updateRegistration(email,mobile);
		
		ResultSet result = service.listAllReg();
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
		rd.forward(request, response);
		
		
		
	}

}
