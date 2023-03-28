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
@WebServlet("/getRegistration")
public class GetRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetRegistrations() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DAOService service = new DAOServiceImpl();
		service.connectDB();
		
		ResultSet result = service.listAllReg();
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
