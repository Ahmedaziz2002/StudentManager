import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class StudentServlet extends HttpServlet{
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/StudentManager";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="Shamha@2002";
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch(ClassNotFoundException e){
                e.printStackTrace();
                throw new ServletException("MYSQL JDBC DRIVER NOT FOUND!",e);
            }
            con=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            con.setAutoCommit(false);
            
            String studentName=request.getParameter("name");
            System.out.println("Received name"+studentName);
            
            if(studentName==null||studentName.trim().isEmpty()){
                System.out.println("ERROR:Empty name input");
                response.sendRedirect("register.jsp");
            }
            String sql="INSERT INTO students (name) VALUES(?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, studentName);
            int rowsAffected=ps.executeUpdate();
            System.out.println("Rows affected"+rowsAffected);
            con.commit();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("DisplayStudentsServlet");
    }
}