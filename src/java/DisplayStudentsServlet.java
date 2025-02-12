import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

public class DisplayStudentsServlet extends HttpServlet{
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/StudentManager";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="Shamha@2002";
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        ArrayList<String>studentList=new ArrayList<>();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            
            String sql="SELECT * FROM students";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                studentList.add(rs.getString("name")); 
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        request.setAttribute("students",studentList);
        RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
        rd.forward(request, response);
    }
    
}