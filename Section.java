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
public class Section {
    private String sec;
    private int id;
    private int totalSpace;
    private int currentStrength;
    ArrayList<Student> registrations;
    ArrayList<Student> sub_students;
    ArrayList<Attendance> attend;
    
    public Section()
    {
        sec=" ";
        id =0;
        totalSpace=currentStrength=0;
        sub_students=new ArrayList<Student>();
        registrations=new ArrayList<Student>();
        attend = new ArrayList<Attendance>();
        
    }
    
    public Section(int ids,String s, int max,int cur)
    {
        id =ids;
        sec=s;
        totalSpace= max;
        currentStrength=cur;
         sub_students=new ArrayList<Student>();
        registrations=new ArrayList<Student>();
        attend = new ArrayList<Attendance>();
       
    }
    
    public void setAttendance(ArrayList<Attendance> at)
    {
        attend = at;
    }
    
    public ArrayList<Attendance> getAttendance()
    {
        return attend;
    }
    
    public void setID(int n)
    {
        id = n;
    }
    public void setname(String n)
    {
        sec = n;
    }
    public void setmax(int n)
    {
        totalSpace = n;
    }
    public void setcurrent(int n)
    {
        currentStrength = n;
    }
    public void setregs(ArrayList<Student> n)
    {
        registrations = n;
    }
    public void setsubs(ArrayList<Student> n)
    {
        sub_students = n;
    }
    public int getID()
    {
        return id;
    }
    public String getname()
    {
        return sec;
    }
    public int getmax()
    {
        return totalSpace;
    }
    public int getcurrent()
    {
        return currentStrength;
    }
    public ArrayList<Student> getregs()
    {
        return registrations;
    }
    public ArrayList<Student> getsubs()
    {
        return sub_students ;
    }
   
    
    
     @Override
    public String toString() {
        return (" ID: " + String.valueOf(this.id) + 
           ",  Name: " + this.sec + ",  str : " + this.currentStrength + " Teacher: " ) ;
   
}
}
