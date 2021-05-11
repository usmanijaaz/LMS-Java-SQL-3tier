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
public class Transcript {
    private ArrayList<Course> courses;
    private int no_of_semesters;
    private float Sgpa;
    private float Cgpa;
    private ArrayList<String> Grades;
    
    public void addgrade(String g)
    {
        Grades.add(g);
    }
    
    public void addCourse(Course c)
    {
        this.courses.add(c);
    }
    public ArrayList<Course> getCourses()
    {
        return this.courses;
    }
    public ArrayList<String> getGrades()
    {
        return this.Grades;
    }
    
    public Transcript()
    {
        no_of_semesters=0;Cgpa=Sgpa=0;
        courses=new ArrayList<Course>();
        Grades=new ArrayList<String>();
    }
 
    public Transcript(int sem,float s,float c,ArrayList<Course> crs, ArrayList<String> grd)
    {
        no_of_semesters = sem;
        Sgpa=s;
        Cgpa=c;
        courses=crs;
        Grades =grd;
    }
    
    public void setSemesters(int s)
    {
        this.no_of_semesters=s;
    }
    public void setsgpa(int s)
    {
        this.Sgpa=s;
    }
    public void setcgpa(int s)
    {
        this.Cgpa=s;
    }
    public void setGrades(ArrayList<String> s)
    {
        this.Grades=s;
    }
    public void setcourses(ArrayList<Course> s)
    {
        this.courses=s;
    }
}
