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

public class BoardUpdateServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  // GET 요청이 들어연 해당 게시물의 상세 정보를 출력한다.
  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    ApplicationContext iocContext = 
        (ApplicationContext)this.getServletContext()
                                .getAttribute("iocContainer");
    BoardDao boardDao = iocContext.getBean(BoardDao.class);
    Board board = boardDao.selectOne(no);
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
   
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>게시판 - 상세정보</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시물 정보</h1>");
    
    out.println("<form id='form1' action = 'update' method='post'>");
    out.println("<table border='1'>");
    out.println(" <tr>");
    out.println("   <th>번호</th>");
    out.printf("   <td><input type='text' value='%d' name='no' readonly></td>", 
        board.getNo());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>제목</th>");
    out.printf("   <td><input type='text' value='%s' name='title'></td> \n", 
        board.getTitle());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>내용</th>");
    out.printf("   <td><textarea rows='10' cols='60' name='content'>'%s'</textarea></td> \n", 
        board.getContent());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>조회수</th>");
    out.printf("   <td>%s</td> \n", board.getViews());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>등록일</th>");
    out.printf("   <td>%s</td> \n", board.getCreatedDate());
    out.println(" </tr>");
    out.println(" <tr>");
    out.println("   <th>비밀번호</th>");
    out.println("   <td><input type='password' name='password'></td>");
    out.println(" </tr>");
    
    out.println("</table>");
    
    out.println("<p>");
    out.println("<button name = 'update' type ='submit'>변경</button>");
    out.printf("<button name = 'delete' type ='submit' onclick='deleteBoard()'>삭제</button>");
    out.println("</p>");
    
    out.println("<script>");
    out.println("function deleteBoard() {");
    out.println("  document.getElementById('form1').action = 'delete';");
    out.println("}");
    out.println("</script>");
    
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  // POST 요청이 들어면 해당 게시물을 입력한 값으로 변경한다.
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException { 
    try {
      Board board = new Board();

      
      ApplicationContext iocContext = 
          (ApplicationContext)this.getServletContext()
                                  .getAttribute("iocContainer");
      BoardDao boardDao = iocContext.getBean(BoardDao.class);

      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setPassword(request.getParameter("password"));


      if (boardDao.update(board) > 0) {
        response.sendRedirect("list");
        return;
      } 
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>게시판 - 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시물 변경 오류</h1>");
      
      out.println("<p>해당 게시물이 존재하지 않거나 암호가 맞지 않습니다.</p>");
      
      RequestDispatcher rd = request.getRequestDispatcher("/copyright");
      rd.include(request, response);

      out.println("</body>");
      out.println("</html>");
      
      response.setHeader("Refresh","2;url=list");
    } catch (Exception e){
      RequestDispatcher rd = request.getRequestDispatcher("/error");
      request.setAttribute("error", e); // 오류 정보를 Error 서블릿에 담는다.
      rd.forward(request, response);
    }
  }
}
