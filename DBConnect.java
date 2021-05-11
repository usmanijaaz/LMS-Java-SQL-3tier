/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsda;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Date;
/**
 *
 * @author Usman
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {
    private Connection con;
    private Statement stmt;
    private PreparedStatement st;
    private static DBConnect instance;

    private DBConnect() {
        try {
            String s = "jdbc:sqlserver://localhost:1433;databaseName=java";
            con = DriverManager.getConnection(s, "maan", "maan");
            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static DBConnect getInstance() {
        if(instance == null)
            instance = new DBConnect();
        return instance;
    }

    /*public void displayAll() {
        try {
            ResultSet rs = stmt.executeQuery("select [username], [password] from [teacher]");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "  " + rs.getString(2));
            }
        } catch (Exception e) {
           // System.out.println("exceptionhereeeeeeee");
            System.out.println(e);
        }
    }*/
    
    public int verifystudent(int userName, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("select [id], [password] from [student]");
            while (rs.next()) {
                if(Integer.parseInt(rs.getString(1))== userName && rs.getString(2).equals(pass))
                    return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    public int verifyteacher(int userName, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("select [id], [password] from [teacher]");
            while (rs.next()) {
                if(Integer.parseInt(rs.getString(1))== userName  && rs.getString(2).equals(pass))
                    return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
     public int verifyofficer(int userName, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("select [id], [password] from [officer]");
            while (rs.next()) {
                if(Integer.parseInt(rs.getString(1))== userName  && rs.getString(2).equals(pass))
                    return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
     
     
     public Student populatestudentFrame(int num)
     {
         Student s=new Student();
        ArrayList<Course>Scourses= new ArrayList<Course>();
        ArrayList<Section>Ssec= new ArrayList<Section>();
        ArrayList<Course>Subcourses= new ArrayList<Course>();
        
        try {
             st=con.prepareStatement("select * from [student] where id = ?");
        
          st.setInt(1,num);
          ResultSet rs = st.executeQuery();
           
          PreparedStatement ss = con.prepareStatement("select Courses.*,section.sec_name  from [Registrations] INNER JOIN [Courses] ON Registrations.Course_id=Courses.Courseid join section on section.s_id= Registrations.sec_id where Registrations.Student_id = ?");
        
          ss.setInt(1,num);
           ResultSet rv = ss.executeQuery();
           
           PreparedStatement ss2 = con.prepareStatement("select Courses.*  from [Subscriptions] INNER JOIN [Courses] ON Subscriptions.Courseid=Courses.Courseid where Subscriptions.Studentid = ?");
        
          ss2.setInt(1,num);
           ResultSet rv2 = ss2.executeQuery();
           
             while (rs.next()) {
               
               s.setId(Integer.parseInt(rs.getString(1)));
               s.setName(rs.getString(2));
               s.setEmail(rs.getString(3));
               s.setPhone((rs.getString(4)));
               s.setMaxcourses(Integer.parseInt(rs.getString(6)));
               s.setNumberofcourses(Integer.parseInt(rs.getString(7)));
               s.setSemester_No(Integer.parseInt(rs.getString(8)));
               s.setNotification(rs.getString(9));
               s.getTrans().setSemesters(Integer.parseInt(rs.getString(8)));
          
       }
            
            while (rv.next()) {
              
              Course demo=new Course();
              demo.setCourseid(Integer.parseInt(rv.getString(1)));
              demo.setCoursecode(rv.getString(2));
              demo.setCourseName(rv.getString(3));
              demo.setCr_hr(rv.getInt(4));
               demo.setSemester_no(rv.getInt(5));
               Section sec = getSectionObject(rv.getString(3),rv.getString(6));
               ArrayList<Attendance> at = getAttendance(rv.getString(6),rv.getString(3));
               sec.setAttendance(at);
              Scourses.add(demo);
              Ssec.add(sec);
              s.getTrans().addCourse(demo);
              PreparedStatement s1 = con.prepareStatement("select grade from Grades where s_id = ? and c_id = ?");
              s1.setInt(1, s.getId());
              s1.setInt(2,demo.getCourseid());
              ResultSet r1 = s1.executeQuery();
              r1.next();
              s.getTrans().addgrade(r1.getString(1));
              
              
             
       }
             s.setCourses(Scourses);
             s.setSec(Ssec);
             
             
            
          while (rv2.next()) {
              
              Course demo=new Course();
              demo.setCourseid(Integer.parseInt(rv2.getString(1)));
              demo.setCoursecode(rv2.getString(2));
              demo.setCourseName(rv2.getString(3));
              demo.setCr_hr(rv2.getInt(4));
               demo.setSemester_no(rv2.getInt(5));
              
              Subcourses.add(demo);
           
       }
          s.setsubCourses(Subcourses);
             
          
        } catch (Exception e) {
            System.out.println(e);
        }
          return s ;
    
     }
     
     
     
   
     
     
     
     public ArrayList<String> ViewListofCourses(int sem,Student S)
     {
         ArrayList<String> stud=new ArrayList<String>();
         
       
         try {
            
             
            st= con.prepareStatement("select [Courseid] , [CourseName] from [Courses] where Semester_no = ? ");
            st.setInt(1,sem);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                 String newstr =   rs.getString(1)+" "+rs.getString(2);
                 stud.add(newstr);
               
            }
           
            
           
        } catch (Exception e) {
            System.out.println(e);
        }
       
       
         return stud;
         
         
         
     }
     
     
     
      public ArrayList<String> getCourseName(int sem)
     {
          ArrayList<String> stud=new ArrayList<String>();
          
            try {
        
             st= con.prepareStatement("select [CourseName] from [Courses] where Semester_no = ? ");
            st.setInt(1,sem);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                 stud.add(rs.getString(1));           
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       
          
          
          return stud;
     }
     
      public ArrayList<String> getCourse(String cours)
      {
          ArrayList<String>  ret = new ArrayList<String>();
          
          try {
              st= con.prepareStatement("select * from Courses where CourseName = ? ");
             
              st.setString(1, cours);
            
             
              ResultSet rs = st.executeQuery();
            
              rs.next();
              ret.add(rs.getString(1));
              ret.add(rs.getString(2));
              ret.add(rs.getString(3));
              ret.add(rs.getString(4));
              ret.add(rs.getString(5));
             
        } catch (Exception e) {
            System.out.println(e);
        }
         
          
          
          return ret;
      }
      
//       public ArrayList<String> getSection(String sec)
//      {
//          ArrayList<String>  ret = new ArrayList<String>();
//          
//          try {
//              st= con.prepareStatement("select * from section where sec_name = ? ");
//             
//              st.setString(1, sec);
//            
//             
//              ResultSet rs = st.executeQuery();
//            
//              rs.next();
//              ret.add(rs.getString(1));
//              ret.add(rs.getString(2));
//             
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//         
//          
//          
//          return ret;
//      }
      
      
      public ArrayList<String> getAvailableSections(String course)
     {
          ArrayList<String> stud=new ArrayList<String>();
          
         try {
        
            st = con.prepareStatement("Select s.sec_name from Available_Section a join Courses c on c.Courseid = a.C_id join section s on s.s_id=a.S_id where c.CourseName = ? ");
            st.setString(1,course);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                 stud.add(rs.getString(1));           
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       
        
          return stud;
         
     }
     
     
//     public int checkAvailableSpace(int cou, int sec)
//     {
//         int result=0;
//         try {
//              st= con.prepareStatement("select * from Available_Section where C_id= ? and S_id= ? and cur_space < total_space");
//             
//              st.setInt(1, cou);
//             st.setInt(2, sec);
//             
//            ResultSet rs = st.executeQuery();
//            
//            
//          if (!rs.next() ) {
//              //System.out.println("no data");
//              result=0;
//           }            
//            else
//           {
//               result=1;
//           }
//           
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//         
//         
//         
//         return result;
//     }
     
     public int checkPreRegistration(int cou,int rol)
     {
         int result=0;
         try {
              st= con.prepareStatement("select * from Registrations where Student_id = ?  and Course_id = ? ");
             
              st.setInt(1, rol);
             st.setInt(2, cou);
             
            ResultSet rs = st.executeQuery();
           if (!rs.next() ) {
             result=1;
           }
            else
           {
               result=0;
           }
            

        } catch (Exception e) {
            System.out.println(e);
        }
         
         
         
         
         return result;
     }
     
     public int checkPreSubscription(int cou,int rol)
     {
         int result=0;
         try {
              st= con.prepareStatement("select * from Subscriptions where Studentid = ?  and Courseid = ? ");
             
              st.setInt(1, rol);
             st.setInt(2, cou);
             
            ResultSet rs = st.executeQuery();
           if (!rs.next() ) {
             result=1;
           }
            else
           {
               result=0;
           }
            

        } catch (Exception e) {
            System.out.println(e);
        }
         
         
         
         
         return result;
     }
     
     
     
     public void registerCourse(int rol, int cour, int sec)
     {
          try {
              st= con.prepareStatement("Insert into [Registrations] (Student_id,Course_id,sec_id) values (?,?,?) ");
             
              st.setInt(1, rol);
             st.setInt(2, cour);
              st.setInt(3, sec);
             
             st.executeUpdate();
              st= con.prepareStatement("Update Available_Section set cur_space=cur_space+1 where C_id = ? and S_id = ? ");
              st.setInt(1, cour);
             st.setInt(2, sec);
             
              st.executeUpdate();
              st= con.prepareStatement("Update student set CurrentCourses = CurrentCourses + 1 where id = ? ");
             st.setInt(1, rol);
             
             st.executeUpdate();
             
           
        } catch (Exception e) {
            System.out.println(e);
        }
         
       
     }
     
     public int checkifYoucanRegister(int rol)
     {
         int result=0;
         
          try {
              st= con.prepareStatement("Select* from student where id = ? and CurrentCourses < MaxCourses  ");
              st.setInt(1,rol);
              
              ResultSet rs = st.executeQuery();
               if (!rs.next() ) {
              result=0;
           }            
            else
           {
               result=1;
           }
           
        } catch (Exception e) {
            System.out.println(e);
        }
         
         
         return result;
     }
     
 
     public ArrayList<String> viewAllCourses()
     {
         ArrayList<String> ret = new ArrayList<String>();
         
          try {
            ResultSet rs = stmt.executeQuery("select * from [Courses]");
            while (rs.next()) {
               ret.add(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3)+" | "+rs.getString(4)+" | "+rs.getString(5));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
     }
     
     public int getSectionId(int stud, int course)
     {
         int retrievedSec = 0;
         
         try
         {
         st = con.prepareStatement(" Select sec_id from Registrations where Course_id = ? and Student_id = ? ");
              st.setInt(1,course);
              st.setInt(2,stud);
              
             ResultSet rs = st.executeQuery();
              
             while(rs.next())
             {
               retrievedSec = Integer.parseInt(rs.getString(1));
             }
             

         } catch (Exception e) {
            System.out.println(e);
        }
         
         return retrievedSec;
         
         
     }
     
     public void deleteRegistration(int stud, int course)
     {
          try {
                st = con.prepareStatement(" delete from Registrations where Course_id = ? and Student_id = ? ");
                st.setInt(1,course);
                st.setInt(2,stud);
             
                st.executeUpdate();
          }
          catch (Exception e) {
            System.out.println(e);
        }
             
     }
     
     
     public void updateRecordsStudent(int stud)
     {
          try {
             
               st = con.prepareStatement("update student set CurrentCourses = CurrentCourses - 1 where id = ? ");
               st.setInt(1,stud);
               
               st.executeUpdate();
   
          
        } catch (Exception e) {
            System.out.println(e);
        }
      
         
     }
     
     public void updateRecordsAvailability(int course, int sec)
     {
         try
         {
                st = con.prepareStatement("update Available_Section set cur_space = cur_space - 1 where C_id = ? and S_id = ? ");
                st.setInt(1,course);
                st.setInt(2,sec);
              
               st.executeUpdate();
               
         } catch (Exception e) { 
             System.out.println(e);
         }
     }
     
     public int addSubscription(int rol,int cour,int sec)
     {
         int rows = -1;
          try
         {
                st = con.prepareStatement("insert into Subscriptions (Identifier,Studentid,Courseid,Secid) values((Select Count(*) from Subscriptions)+1,?,?,?) ",Statement.RETURN_GENERATED_KEYS);
                st.setInt(1,rol);
                st.setInt(2,cour);
                st.setInt(3,sec);
              
               rows = st.executeUpdate();
               
               System.out.println("rows affected: " + rows);
               
         } catch (Exception e) { 
             // System.out.println("exception generated: "+ e);
         }
         
         return rows;
     }
     
     public void incrementCurrentCourses(int ids)
     {
         try
         {
                st = con.prepareStatement("update student set CurrentCourses = CurrentCourses + 1 where id = ? ");
                st.setInt(1,ids);
                
               st.executeUpdate();
               
         } catch (Exception e) { 
             System.out.println(e);
         }
     }
     
     ArrayList<String> getOfficerInfo(int ids)
     {
         ArrayList<String> info = new ArrayList<String>();
          try
         {
                st = con.prepareStatement("select * from officer  where id = ? ");
                st.setInt(1,ids);
                
               ResultSet rs = st.executeQuery();
               while(rs.next())
               {
                   for(int i=1;i<6;i++)
                   {
                     info.add(rs.getString(i));
                   }
               }
               
         } catch (Exception e) { 
             System.out.println(e);
         }
         
         
         
         return info;
        
     }
        
     public int checkWithdrawalDeadline(String date, int sem)
     {
         int ret=0;
          try
         {
                st = con.prepareStatement("select WDate from Reg_Period  where Semester = ? and WDate >= ? ");
                st.setInt(1,sem);
                st.setString(2,date);
                
               ResultSet rs = st.executeQuery();
               if(!rs.next())
               {
                   ret = 0;
               }
               else
               {
                   ret = 1;
               }
               
               
         } catch (Exception e) { 
             System.out.println(e);
         }
          return ret;
     }
     
     public int checkRegistrationPeriod(String date, int sem)
     {
         int ret=0;
          try
         {
                st = con.prepareStatement("select * from Reg_Period where Semester = 1 and  SDate <= ? and EDate >= ?");
                st.setString(1,date);
                st.setString(2,date);
                
               ResultSet rs = st.executeQuery();
               if(!rs.next())
               {
                   ret = 0;
               }
               else
               {
                   ret = 1;
               }
               
               
         } catch (Exception e) { 
             System.out.println(e);
         }
          return ret;
     }
     
     
     public ArrayList<String> getRegistrationInfo(int sem)
     {
         ArrayList<String>  ret = new ArrayList<String>();
          try
         {
                st = con.prepareStatement("select * from Reg_Period  where Semester = ? ");
                st.setInt(1,sem);
               
                
               ResultSet rs = st.executeQuery();
               while(rs.next())
               {
                   for(int i=1;i<4;i++)
                   {
                  ret.add(rs.getString(i));
                   }
               }
               
               
         } catch (Exception e) { 
             System.out.println(e);
         }
          return ret;
     }
     
     public int addaNewCourse(Course add,int n)
     {
          int ret=0;
          try
         {
                st = con.prepareStatement("Insert into Courses (Courseid,CourseCode,CourseName,CreditHr,Semester_no) values (?,?,?,?,?) ");
                st.setInt(1,add.getCourseid());
                st.setString(2,add.getCoursecode());
                st.setString(3,add.getCourseName());
                st.setInt(4,add.getCr_hr());
                st.setInt(5,add.getSemester_no());
                
               st.executeUpdate();
               
               for(int i = 1;i<= n ;i++)
               {
               PreparedStatement ss = con.prepareStatement("Insert into Available_Section (C_id,S_id,total_space,cur_space) values (?,?,?,?) ");
               ss.setInt(1,add.getCourseid());
               ss.setInt(2,i);
               ss.setInt(3,50);
               ss.setInt(4,0);
               
               ss.executeUpdate();
               }
               
         } catch (Exception e) { 
            // System.out.println(e);
             ret =-1;
         }
          return ret;
     }
     
     public Section getSectionObject(String cour, String sec)
     {
         Section secret = new Section();
         ArrayList<Student> regs = new ArrayList<Student>();
         ArrayList<Student> subs = new ArrayList<Student>();
          try
         {
                st = con.prepareStatement("select a.S_id,a.total_space,a.cur_space from Available_Section a join section s on s.s_id = a.S_id join courses c on c.Courseid = a.C_id where s.sec_name = ? and c.CourseName = ? ");
                st.setString(1,sec);
                st.setString(2,cour);
                
               ResultSet rv = st.executeQuery();
               rv.next();
               secret.setname(sec);
               secret.setID(rv.getInt(1));
               secret.setmax(rv.getInt(2));
               secret.setcurrent(rv.getInt(3));
               
               PreparedStatement ss =con.prepareStatement("select s.* from student  s join Registrations r on s.id = r.Student_id join Courses c on c.Courseid = r.Course_id where c.CourseName = ? and r.sec_id= ? ");
               ss.setString(1,cour);
               ss.setInt(2,secret.getID());
               ResultSet rs = ss.executeQuery();
               while(rs.next())
               {
                   Student s=new Student();
                   s.setId(Integer.parseInt(rs.getString(1)));
               s.setName(rs.getString(2));
               s.setEmail(rs.getString(3));
               s.setPhone((rs.getString(4)));
               s.setMaxcourses(Integer.parseInt(rs.getString(6)));
               s.setNumberofcourses(Integer.parseInt(rs.getString(7)));
               s.setSemester_No(Integer.parseInt(rs.getString(8)));
               s.setNotification(rs.getString(9));
          
                   regs.add(s);
               }
               secret.setregs(regs);
               
               PreparedStatement ss2 =con.prepareStatement("select s.* from student  s join Subscriptions r on s.id = r.Studentid join Courses c on c.Courseid = r.Courseid where c.CourseName = ? and r.Secid= ? ");
               ss2.setString(1,cour);
               ss2.setInt(2,secret.getID());
               ResultSet rs2 = ss2.executeQuery();
               while(rs2.next())
               {
                   Student s=new Student();
                   s.setId(Integer.parseInt(rs2.getString(1)));
               s.setName(rs2.getString(2));
               s.setEmail(rs2.getString(3));
               s.setPhone((rs2.getString(4)));
               s.setMaxcourses(Integer.parseInt(rs2.getString(6)));
               s.setNumberofcourses(Integer.parseInt(rs2.getString(7)));
               s.setSemester_No(Integer.parseInt(rs2.getString(8)));
               s.setNotification(rs2.getString(9));
                   subs.add(s);
               }
               secret.setsubs(subs);
               
               
         
         } catch (Exception e) { 
             System.out.println(e);
            
         }
         
         
         return secret;
     }
     
     public ArrayList<Attendance> getAttendance(String sec, String cour)
     {
          ArrayList<Attendance> subs = new ArrayList<Attendance>();
          try
         {
                st = con.prepareStatement("select a.st,a.sem,a.Datee,a.stat from Student_Attend a join Courses c on c.Courseid = a.C_id join section s on s.s_id =a.S_id where c.CourseName = ? and s.sec_name = ? ");
                st.setString(1,cour);
                st.setString(2,sec);
                
               ResultSet rs = st.executeQuery();
              
               while(rs.next())
               {
                   Attendance ad = new Attendance(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4));
                   subs.add(ad);
               }
               
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
          
          return subs;
     }
     
     public void checkForSubscribedStudent(Course c, Section S)
     {
         try
         {
                st = con.prepareStatement("select Studentid from Subscriptions where Identifier = (Select MIN(Identifier) as ide from Subscriptions where Courseid = ? and Secid = ?) ");
                st.setInt(1,c.getCourseid());
                st.setInt(2,S.getID());
                
               ResultSet rs = st.executeQuery();
              
               if(!rs.next())
               { 
               
               }
               else
               {
               
                   String s = "Avail Space in:" + S.getname()+ " "+ c.getCoursecode() + ".";
               
               PreparedStatement ss = con.prepareStatement("Update student Set Notification = ? where id = ? ");
               ss.setString(1, s);
               ss.setInt(2,rs.getInt(1));
               
               ss.executeUpdate();
               
               PreparedStatement ss1 = con.prepareStatement("Update Subscriptions Set Studentid = 0,Courseid=0,Secid=0 where Studentid = ? and Courseid = ? and Secid = ? ");
               ss1.setInt(1,rs.getInt(1));
               ss1.setInt(2,c.getCourseid());
               ss1.setInt(3,S.getID());
               ss1.executeUpdate();
               
               PreparedStatement st1 = con.prepareStatement("update student set CurrentCourses = CurrentCourses - 1 where id = ? ");
                st1.setInt(1,rs.getInt(1));
                
               st1.executeUpdate();
               
             }
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
     }
     
     public String setWithdrawal(int semester)
     {
       PreparedStatement ss;
       String ret="";
         try
         {
                st = con.prepareStatement("select Withdrawal from Reg_Period  where Semester = ? ");
               // st.setString(1,stat);
                st.setInt(1,semester);
                
                ResultSet rs = st.executeQuery();
                rs.next();
                if(rs.getString(1).equals("Open"))
                {
                    ss = con.prepareStatement("Update Reg_Period set Withdrawal = 'Close' where Semester = ? ");
                    ss.setInt(1,semester);
                    ss.executeUpdate();
                    ret = "Close";
                }
                else if(rs.getString(1).equals("Close"))
                {
                    ss = con.prepareStatement("Update Reg_Period set Withdrawal = 'Open' where Semester = ? ");
                    ss.setInt(1,semester);
                    ss.executeUpdate();
                    ret = "Open";
                }
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
         
         return ret;
     }
     
     public Teacher populateFrameTeacher(int tid)
     {
         Teacher ret = new Teacher();
         ArrayList<Course> cou = new ArrayList<Course>();
          ArrayList<Section> sec = new ArrayList<Section>();
          try
         {
                st = con.prepareStatement("select* from teacher where id = ? ");
                st.setInt(1,tid);
                
                ResultSet rs = st.executeQuery();
                rs.next();
                ret.setId(rs.getInt(1));
                ret.setName(rs.getString(2));
                ret.setEmail(rs.getString(4));
                ret.setPhone(rs.getString(5));
                ret.setStatus(rs.getString(6));
                
                PreparedStatement ss = con.prepareStatement("select Courses.*, section.sec_name from TeachingCourse join Courses on courses.Courseid=TeachingCourse.Cid join section on section.s_id=TeachingCourse.secid where TeachingCourse.Tid = ?");
                ss.setInt(1, tid);
                ResultSet rv = ss.executeQuery();
                
                while(rv.next())
                {
                    Course demo=new Course();
              demo.setCourseid(Integer.parseInt(rv.getString(1)));
              demo.setCoursecode(rv.getString(2));
              demo.setCourseName(rv.getString(3));
              demo.setCr_hr(rv.getInt(4));
               demo.setSemester_no(rv.getInt(5));
               cou.add(demo);
               Section S = getSectionObject(rv.getString(3),rv.getString(6));
              ArrayList<Attendance> at = getAttendance(rv.getString(6),rv.getString(3));
              S.setAttendance(at);
               sec.add(S);
                }
                ret.setcourses(cou);
                ret.setsections(sec);
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
         
         
         return ret;
     }
     
      public String setRegistration(int semester)
     {
       PreparedStatement ss;
       String ret="";
         try
         {
                st = con.prepareStatement("select Registration from Reg_Period  where Semester = ? ");
               // st.setString(1,stat);
                st.setInt(1,semester);
                
                ResultSet rs = st.executeQuery();
                rs.next();
                if(rs.getString(1).equals("Active"))
                {
                    ss = con.prepareStatement("Update Reg_Period set Registration = 'Inactive' where Semester = ? ");
                    ss.setInt(1,semester);
                    ss.executeUpdate();
                    ret = "Inactive";
                }
                else if(rs.getString(1).equals("Inactive"))
                {
                    ss = con.prepareStatement("Update Reg_Period set Registration = 'Active' where Semester = ? ");
                    ss.setInt(1,semester);
                    ss.executeUpdate();
                    ret = "Active";
                }
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
         
         return ret;
     }
     
     
     
     
     public void addAttendance(int sid,int sem, int cid,int sec, String d,String stt)
     {
          try
         {
                st = con.prepareStatement("Insert into Student_Attend (st,sem,C_id,S_id,Datee,stat) values (?,?,?,?,?,?) ");
                st.setInt(1,sid);
                st.setInt(2,sem);
                st.setInt(3,cid);
                st.setInt(4,sec);
                st.setString(5,d);
                 st.setString(6,stt);
                
                st.executeUpdate();
              
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
         
     }
     
     public void removeAttend(int cid,int sid)
     {
         try
         {
                st = con.prepareStatement("Delete from Student_Attend where S_id = ? and C_id = ? ");
                st.setInt(1,sid);
                st.setInt(2,cid);
                
                st.executeUpdate();
              
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
     }
     
   
     public void setNoti(int id, String s)
     {
          try
         {
                st = con.prepareStatement("Update student set Notification = ? where id = ?  ");
                st.setString(1,s);
                st.setInt(2,id);
                
                st.executeUpdate();
              
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
     }
     
     
     public void addCourseinGrade(int sid,int sem,int c_id,String gr)
     {
        try
         {
                st = con.prepareStatement("Insert into Grades (s_id,c_id,sem,grade) values (?,?,?,?)  ");
                st.setInt(1,sid);
                st.setInt(2,c_id);
                st.setInt(3,sem);
                st.setString(4,gr);
                
                
                st.executeUpdate();
              
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
      }
     
     public void assignGrade(int SId, int Sem,int cid,String gr)
     {
         try
         {
                st = con.prepareStatement("Update Grades set grade = ? where s_id = ? and c_id = ? and sem = ?  ",Statement.RETURN_GENERATED_KEYS);
                st.setString(1,gr);
                st.setInt(2,SId);
                st.setInt(3,cid);
                st.setInt(4,Sem);
                
                
                int r= st.executeUpdate();
              if(r==0)
              {
                  PreparedStatement ss = con.prepareStatement("Insert into Grades (s_id,c_id,sem,grade) values (?,?,?,?) ");
                  ss.setInt(1, SId);
                  ss.setInt(2,cid);
                  ss.setInt(3,Sem);
                  ss.setString(4,gr);
                  
                  ss.executeUpdate();
              }
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
      }
     
     
     public void setGpas(int sd,int sem ,String sgpa,String cgpa)
     {
          try
         {
                st = con.prepareStatement("Update GPA set sgpa = ? , cgpa = ? where s_id = ? and sem = ?  ",Statement.RETURN_GENERATED_KEYS);
                st.setString(1,sgpa);
                st.setString(2,cgpa);
                st.setInt(3,sd);
                st.setInt(4,sem);
                
                
                int r = st.executeUpdate();
                if(r == 0)
                {
                    PreparedStatement st1 = con.prepareStatement("insert into GPA (s_id,sem,sgpa,cgpa) values (?,?,?,?)");
                     st1.setInt(1,sd);
                st1.setInt(2,sem);
                st1.setString(3,sgpa);
                st1.setString(4,cgpa);
                
                
                st1.executeUpdate();
                }
              
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
     }
     

     public String getGrade(int s, int c, int sem)
     {
         try
         {
                st = con.prepareStatement("Select grade from Grades where s_id =? and c_id =? and sem =? ");
                st.setInt(1,s);
                st.setInt(2,c);
                st.setInt(3,sem);
               
                
                
               ResultSet rs =  st.executeQuery();
               if(!rs.next())
               {
                   return " ";
               }
               else
               {
                   return rs.getString(1);
               }
              
               
         } catch(Exception e)
         {
             System.out.println(e);
         }
         return " ";
     }
 
     
     
}


