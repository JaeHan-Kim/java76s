package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardListServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      int pageNo = 1;
      int pageSize = 10;

      if (request.getParameter("pageNo") != null) {
        pageNo =Integer.parseInt(request.getParameter("pageNo"));
      }
      if (request.getParameter("pageSize") != null) {
        pageSize =Integer.parseInt(request.getParameter("pageSize"));
      }

      String keyword = "no";
      String align = "desc";
      if (request.getParameter("keyword") != null) {
        keyword = request.getParameter("keyword");
      }
      if (request.getParameter("align") != null) {
        align = request.getParameter("align");
      }

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
          .getAttribute("iocContainer");
      BoardDao boardDao = iocContext.getBean(BoardDao.class);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>게시판-목록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시판</h1>");
      
      out.println("<a href='form.html'>새 글</a><br>");
      
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("  <th>번호</th>");
      out.println("  <th>제목</th>");
      out.println("  <th>조회수</th>");
      out.println("  <th>등록일</th>");
      out.println("</tr>");
      
      for (Board Board : boardDao.selectList(
                                      pageNo, pageSize, keyword, align)) {
      out.println(" <tr>");
      out.printf("   <td>%s</td> \n", Board.getNo());
      out.printf("   <td><a href='update?no=%d'>%s</a></td> \n", Board.getNo(),Board.getTitle());
      out.printf("   <td>%s</td> \n", Board.getViews());
      out.printf("   <td>%s</td> \n", Board.getCreatedDate());
      out.println(" </tr>");
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);

    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      rd.forward(request, response);
    }
  }
}
