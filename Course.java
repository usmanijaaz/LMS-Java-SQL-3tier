/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsda;
import java.util.ArrayList;
/**
 *
 * @author Usman
 */
public class Course {
    private int courseid;
    private int cr_hr;
    private int semester_no;
    private String CourseName;
    private String Coursecode;
    ArrayList<Section> availableSections;
    //ArrayList<Attendance> attend;
    
    public Course()
    {
        courseid=0;
        semester_no=0;
        cr_hr=0;
        CourseName=" ";
        Coursecode=" ";
        availableSections=new ArrayList<Section>();
        //attend = new ArrayList<Attendance>();
    }
    
    public Course(int i,String name,String code,int ch,int sm,ArrayList<Section> c)
    {
        cr_hr=ch;
        semester_no=sm;
        courseid=i;
        CourseName=name;
        Coursecode=code;
        availableSections = c;
    }
  
    public Course(int i,String name,String code,int ch,int sm)
    {
        cr_hr=ch;
        semester_no=sm;
        courseid=i;
        CourseName=name;
        Coursecode=code;
    }
  
    

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getCr_hr() {
        return cr_hr;
    }

    public void setCr_hr(int cr_hr) {
        this.cr_hr = cr_hr;
    }

    public int getSemester_no() {
        return semester_no;
    }

    public void setSemester_no(int semester_no) {
        this.semester_no = semester_no;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCoursecode() {
        return Coursecode;
    }

    public void setCoursecode(String Coursecode) {
        this.Coursecode = Coursecode;
    }
    public ArrayList<Section> getSections()
    {
        return this.availableSections;
    }
    
    
    @Override
    public String toString() {
        return ("Course ID: " + String.valueOf(this.courseid) + 
           ", Course Name: " + this.CourseName + ", Course Code: " + this.Coursecode) ;
}
    
}
