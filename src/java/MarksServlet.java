import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class MarksServlet extends HttpServlet{
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/StudentManager";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="Shamha@2002";
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String studentId=request.getParameter("studentId");
        String subject=request.getParameter("subject");
        String grade=request.getParameter("grade");
        String semester=request.getParameter("semester");
        
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            
            String sql="INSERT INTO marks(sid,subject,grade,semester) VALUES(?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,studentId);
            ps.setString(2,subject);
            ps.setString(3,grade);
            ps.setString(4,semester);
            
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Marks Inserted");
            }
            response.sendRedirect("MarksView");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(ps!=null)ps.close();
                if(con!=null)con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}