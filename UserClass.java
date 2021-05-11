/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsda;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.time.LocalDate;
/**
 *
 * @author Usman
 */
public class UserClass {
    
    
    
    private String name;
    private int id;
    private String email;
    private String password;
    private String phone;
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public UserClass()
    {
        id=0;
        name=" ";
        email=" ";
        password=" ";
        phone=" ";
    }
    
    public UserClass(String n, String e, int a, String pass,String ph)
    {
        id=a;
        name=n;
        email=e;
        password=pass;
        phone=ph;
        
    }
    
  
}

class Student extends UserClass
{
     private DBConnect conobject= DBConnect.getInstance();
     GlobalClass gc = new GlobalClass();
     
    private int numberofcourses;
    private int maxcourses;
    private ArrayList<Course> courses; 
     private ArrayList<Section> sections; 
    private ArrayList<Course> subcourses; 
    private int semester_No;
    private String Notification;
    private Transcript Trans;

    public int getNumberofcourses() {
        return numberofcourses;
    }

    public void setNumberofcourses(int numberofcourses) {
        this.numberofcourses = numberofcourses;
    }

    public int getMaxcourses() {
        return maxcourses;
    }

    public void setMaxcourses(int maxcourses) {
        this.maxcourses = maxcourses;
    }

    public int getSemester_No() {
        return semester_No;
    }

    public void setSemester_No(int semester_No) {
        this.semester_No = semester_No;
    }

    public String getNotification() {
        return Notification;
    }

    public void setNotification(String Notification) {
        this.Notification = Notification;
    }
    public void setCourses(ArrayList<Course> c)
    {
        courses = c;
    }
     public void setSec(ArrayList<Section> c)
    {
        sections = c;
    }
    public void setsubCourses(ArrayList<Course> c)
    {
        subcourses = c;
    }
    
     public ArrayList<Course> getCourses()
    {
        return courses;
    }
     public ArrayList<Section> getSec()
    {
        return sections;
    }
     public Course getCourses(int i)
    {
        return courses.get(i);
    }
     
    
    public Student()
    {
        super();
        semester_No=0;
        Trans=new Transcript();
        courses=new ArrayList<Course>();
        subcourses=new ArrayList<Course>();
        
    }
    
    public Student(int c,int m,String n, String e, int a,String pass,String ph,String note,int sem)
    {
        super(n,e,a,pass,ph);
        numberofcourses=c;
        maxcourses=m;
        courses=new ArrayList<Course>();
        sections = new ArrayList<Section>();
        subcourses=new ArrayList<Course>();
        semester_No= sem;
        Trans=new Transcript();
        Notification=note;
    }
    
    public void Print()
    {
        System.out.println(getName() + "," + getEmail() + "," );
        System.out.println(courses);
    }
    
    public Transcript getTrans()
    {
        return this.Trans;
    }
    
    public ArrayList<String> viewCourses()
    {
        ArrayList<String> crs =  conobject.ViewListofCourses(this.getSemester_No(),this);
        return crs;
    }
    
    public int addCourse(Course c_add,Section S)
    {
        int sec_id = S.getID();
    
       int register = conobject.checkifYoucanRegister(this.getId());
           if(register == 1)
           {
        
        int result = conobject.checkPreRegistration(c_add.getCourseid(),this.getId());
        if(result == 1)
        {
            int result2 = conobject.checkPreSubscription(c_add.getCourseid(),this.getId());
            if(result2 == 1)
            {
            //int r2 = conobject.checkAvailableSpace(c_add.getCourseid(),sec_id);
            if(S.getcurrent() >= S.getmax())
            {
                 JOptionPane.showMessageDialog(null,"No more Space available in this Course's section !! \n You can Still Subscribe to this section .. :)  ");
                 return -1;
            }
            else //if(r2 == 1)
            {
               conobject.registerCourse(this.getId(),c_add.getCourseid(),sec_id);
               JOptionPane.showMessageDialog(null,"You are registered in this Course ! ");
               this.courses.add(c_add);
               this.sections.add(S);
               S.setcurrent(S.getcurrent()+1);
               S.registrations.add(this);
               this.Trans.addCourse(c_add);
               this.Trans.addgrade("I");
               conobject.addCourseinGrade(this.getId(),this.getSemester_No(),c_add.getCourseid(),"I");
               return 1;
            }
            }
            else if(result2 == 0)
            {
                JOptionPane.showMessageDialog(null,"You have already subscribed to this Course ! ");
               return 1;
            }
                 
        }
        else if(result == 0)
        {
             JOptionPane.showMessageDialog(null,"You are already registered in this Course !"); 
             return 1;    
        }
       
           }
           else if(register == 0)
           {
                JOptionPane.showMessageDialog(null,"You have reached your course limit ... \n SORRY :( ");
                return 1;
           }
       
       
        return 0;
   }
    public void addSubscription(Course csub,Section S )
    {
         int rows = conobject.addSubscription(this.getId(),csub.getCourseid(),S.getID());
           this.subcourses.add(csub);
           this.setNumberofcourses(this.getNumberofcourses()+1);
               JOptionPane.showMessageDialog(null,"You are added to subscription list of this course !!! ");
               //conobject.incrementCurrentCourses(gc.currentUser.getId());
             //  gc.currentUser.setNumberofcourses( gc.currentUser.getNumberofcourses()+1);
               S.sub_students.add(this);
    }
    
    public int  dropCourse(Course cd, Section S)
    {
        int sec = S.getID();
         
        
        if(gc.registration.getWdate().equals("Open"))
        {
            // courses.remove(cd);
             for(int i=0;i<courses.size();i++)
             {
                if(courses.get(i).getCourseid() == cd.getCourseid())
                 {
                    courses.remove(i);
                    sections.remove(i);
                 }
             }
            
        conobject.deleteRegistration(this.getId(),cd.getCourseid());
        for(int i=0;i<S.getregs().size();i++)
             {
                if(S.getregs().get(i).getId() == S.getID())
                 {
                    S.registrations.remove(i);
                    S.setcurrent(S.getcurrent()-1);
                 }
             }
        conobject.updateRecordsStudent(this.getId());
        conobject.updateRecordsAvailability(cd.getCourseid(),sec);
        JOptionPane.showMessageDialog(null,"You have dropped the course Successfully  !! ");
        return 1;
        
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Sorry! You can't drop a course. \n The withdrawal of courses has been stopped!  ");
            return 0;
        }
        
      
    }
    
    
    public ArrayList<Attendance> viewAttendance(Course crs)
    {
        System.out.println(this.getCourses().size());
        
        ArrayList<Attendance>  atd = new ArrayList<Attendance>();
        
        for(int i=0;i<this.getCourses().size();i++)
             {
                 if(this.getCourses().get(i).getCourseName().equals(crs.getCourseName()))
                 {
                    atd = this.getSec().get(i).getAttendance();
                   // System.out.println("We are herererere !");
                 }
             } 
        
        return atd;
    }
    
    
    
    @Override
    public String toString() {
        return (String.valueOf(this.getId()) + " "+
          this.getName() ) ;
   
}
    
    
}


class Teacher extends UserClass
{
    private DBConnect conobject= DBConnect.getInstance();
    
    String status;
    ArrayList<Course> courses;
    ArrayList<Section> sections;
    
    public Teacher()
    {
        super();
        status="";
        courses = new ArrayList<Course>();
        sections = new ArrayList<Section>();
    }
    
    public Teacher(String n, String e, int a,String pass,String ph,String st)
    {
         super(n,e,a,pass,ph);
         status = st;
          courses = new ArrayList<Course>();
        sections = new ArrayList<Section>();
    }
    public void setStatus(String s)
    {
        status = s;
    }
    public String getStatus()
    {
        return status;
    }
    
    public void setcourses(ArrayList<Course> c)
    {
        this.courses = c;
    }
    
    public ArrayList<Course>  getCourses()
    {
        return this.courses;
    }
     public void setsections(ArrayList<Section> c)
    {
        this.sections = c;
    }
    
    public ArrayList<Section>  getsections()
    {
        return this.sections;
    }
    
     public void  addAttendance(Student S,Course co,Section se,String stat,String dat)
     {
         for(int i=0;i<S.getCourses().size();i++)
         {
             if(S.getCourses().get(i).getCourseid() == co.getCourseid())
             {
                S.getSec().get(i).getAttendance().add(new Attendance(S.getId(),S.getSemester_No(),dat,stat));
                break;
             }
         }
         
         conobject.addAttendance(S.getId(),S.getSemester_No(),co.getCourseid(),se.getID(),dat,stat);
         
     }
    
     public void assignGrade(Student S,Course c,Section se,String gr)
     {
         for(int i=0;i<S.getTrans().getCourses().size();i++)
         {
             if(S.getTrans().getCourses().get(i).getCourseid() == c.getCourseid())
             {
                 S.getTrans().getGrades().set(i,gr);
             }
         }
         
         conobject.assignGrade(S.getId(),S.getSemester_No(),c.getCourseid(),gr);
       
         
     }
    
    
    
    @Override
    public String toString() {
        return (" ID: " + String.valueOf(this.getId()) + 
           ",  Name: " + this.getName()); }
   
    
    
}


class Academic_Officer extends UserClass
{
    
    public Academic_Officer(String n, String e, int a,String pass,String ph)
    {
         super(n,e,a,pass,ph);
    }
    
    
}
