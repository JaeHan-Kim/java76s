package java76.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener{

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("스프링 IoC 컨테이너 준비하기");
    
    // 1) Spring IoC 컨테이너 준비
    // ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
    //   "java76/pms/application-context.xml");
      ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
          sce.getServletContext().getInitParameter("contextConfigLocation"));
   
      // 2) ServletContext 저장소에 스프링 IoC 컨테이너 보과
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("iocContainer", iocContainer);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }

}
