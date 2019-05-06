package demo1;
import java.sql.*;
import java.util.*;
import java.text.*;

public class cobadatabase{
protected String sn,fn,ln,srt, sn2, srt2, et;
protected Long tt;
private Connection conn;
private PreparedStatement st; 

public cobadatabase(){
    try{
       Class.forName("com.mysql.jdbc.Driver");
       conn =   DriverManager.getConnection("jdbc:mysql://localhost/studentrecords","root","");

        }

catch(Exception e){}
}

 public cobadatabase(String sn2, String str2, String et, long tt)
{
    this();
    try
    {
    st = conn.prepareStatement("Insert into time(StudentNumber,StartTime,EndTime,TotalTime) values(?,?,?,?)");
    st.setString(1,sn2);
    st.setString(2,str2);
    st.setString(3,et);
    st.setLong(4,tt);
    st.executeUpdate();

}
catch(Exception e){}
}

public cobadatabase(String StudentNumber)
{

    this();
    try{
       st = conn.prepareStatement("SELECT * FROM student WHERE StudentNumber=?");
       st.setString(1,StudentNumber);
       ResultSet rs = st.executeQuery();

            while (rs.next())
            {
                this.sn = rs.getString(1);
                this.fn = rs.getString(2);
                this.ln = rs.getString(3);
                this.srt = rs.getString(4);

                SimpleDateFormat ft = new SimpleDateFormat("kk:mm:ss");
                ft.format(rs.getTime("TotalTime").getTime());
            }   
}
catch(Exception e){}
}

public cobadatabase(String StudentNumber2, String Start, String End)
{

    this();
    try{
       st = conn.prepareStatement("SELECT * FROM time WHERE StudentNumber2=?");
       st.setString(2,Start);
       st.setString(3,End);
       ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                this.sn2 = rs.getString(1);
                this.srt2 = rs.getString(2);
                this.et = rs.getString(3);
                this.tt = rs.getLong(4);
            }
    }
    catch(Exception e){}
}



    public String getFirstName(){
    return fn;
}
    public String getLastName(){
    return ln;
}
    public String getStudentNumber(){
    return sn;
}
    public String getStart(){
    return srt2;
}
    public String getEnd(){
    return et;
}

}