package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NewsDAO;
import model.vo.NewsVO;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String newsid = request.getParameter("newsid");
		NewsDAO dao = new NewsDAO();
		if(newsid != null) {
			if(action.equals("read")) {
				NewsVO vo =dao.listOne(Integer.parseInt(newsid));
				dao.update(vo);
				request.setAttribute("listone", vo);
			}else if(action.equals("delete")) {
				boolean result = dao.delete(Integer.parseInt(newsid));
				if(result)
					request.setAttribute("msg", "뉴스가 성공적으로 삭제되었어요!");
				else 
					request.setAttribute("msg", "뉴스 삭제를 실패했어요!");
			}	
		}
		request.setAttribute("list", dao.listAll()); //여기서 자꾸 오류가...
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String newsid = request.getParameter("newsid");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		if(action.equals("insert")) { //입력
			boolean result = dao.insert(vo);
			if(result) { 
				request.setAttribute("msg", title + " 뉴스가 성공적으로 입력되었어요~!");
			}
			else
				request.setAttribute("msg", title + " 뉴스 입력을 실패했어요~!");
		}else if(action.equals("update") && newsid != null){ //수정
			vo.setId(Integer.parseInt(newsid));
			vo.setCnt(dao.listOne(Integer.parseInt(newsid)).getCnt()-1);
			boolean result = dao.update(vo);
			if(result) 
				request.setAttribute("msg", title + " 뉴스가 성공적으로 수정되었어요~!");
			else
				request.setAttribute("msg", title + " 뉴스 수정을 실패했어요~!");
		}
		request.setAttribute("list", dao.listAll());		
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
}
