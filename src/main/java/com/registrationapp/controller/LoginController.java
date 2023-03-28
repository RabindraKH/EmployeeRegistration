package com.registrationapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	
	DAOService dao= new DAOServiceImpl();
	dao.connectDB();
	
	boolean status = dao.verifyCredentials(email, password);
	if(status==true) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);
		
	}else {
		request.setAttribute("error","Invalid username/password");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
