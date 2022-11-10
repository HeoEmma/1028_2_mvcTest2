package com.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	브라우저 주소창의 contextPath("/1028_2_mvcTest") 뒤에 @WebServlet 어노테이션에서 인수로 지정된
//	요청("/HomeController")이 들어오면 @WebServlet 어노테이션이 붙어있는 클래스(컨트롤러)에서 
//	get 방식의 요청이 들어오면 doGet() 메소드가 자동으로 실행되고 post 방식으로 요청이 들어오면
//	doPost() 메소드가 자동으로 실행된다.
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
	}

//	get 방식으로 컨트롤러에 요청이 들어올 때 자동을 실행되는 메소드 => submit 버튼이 클릭되지 않은 경우
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() 메소드 실행");
		actionDo(request, response);
	}

//	post 방식으로 컨트롤러에 요청이 들어올 때 자동을 실행되는 메소드 => submit 버튼이 클릭된 경우
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() 메소드 실행");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() 메소드 실행");
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8"); // 받을때
		response.setContentType("text/html; charset=UTF-8"); // 보낼때
		
		// get 방식으로 요청될 때 넘어오는 데이터를 받는다.
		String name = request.getParameter("name");
		System.out.println(name);
		
		// view 페이지로 전달할 데이터를 request 영역에 저장한다.
		request.setAttribute("name", name);
		
		// view 페이지 이름을 만든다.
		String viewpage = "/WEB-INF/hello.jsp";
		// RequestDispatcher 인터페이스 객체를 이용해서 요청에 따른 실제 view 페이지를 호출해서
		// 브라우저에 표시하기 위해 준비한다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
		// view 페이지를 호출한다.
		dispatcher.forward(request, response);
	}

}








