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
		String id = request.getParameter("id");
		NewsDAO dao = new NewsDAO();
		if(id != null) {
			request.setAttribute("listone", dao.listOne(Integer.parseInt(id)));
		}
		request.setAttribute("list", dao.listAll());
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		
		if(action.equals("insert")) { //�엯�젰
			boolean result = dao.insert(vo);
			if(result) 
				request.setAttribute("msg", title + " �돱�뒪媛� �꽦怨듭쟻�쑝濡� �엯�젰�릺�뿀�뼱�슂~!");
			else
				request.setAttribute("msg", title + " �돱�뒪 �엯�젰�쓣 �떎�뙣�뻽�뼱�슂~!");
		}else { //�닔�젙
			vo.setId(Integer.parseInt(action));
			boolean result = dao.update(vo);
			if(result) 
				request.setAttribute("msg", title + " �돱�뒪媛� �꽦怨듭쟻�쑝濡� �닔�젙�릺�뿀�뼱�슂~!");
			else
				request.setAttribute("msg", title + " �돱�뒪 �닔�젙�쓣 �떎�뙣�뻽�뼱�슂~!");
		}
		request.setAttribute("list", dao.listAll());
		
		request.getRequestDispatcher("/jspexam/news.jsp").forward(request, response);
	}
}
