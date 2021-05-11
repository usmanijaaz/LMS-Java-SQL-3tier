/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsda;

/**
 *
 * @author Usman
 */
public class Attendance {
    private int stdId;
    private int semester;
    private String Date;
    private String Status;
    
    public Attendance()
    {
        Date = Status = " ";
    }
    public Attendance(int st,int sm,String d, String s)
    {
        stdId = st;
        semester =sm;
        Date = d;
        Status = s;
    }
    
    public int getStid()
    {
        return stdId;
    }
    
    public String getDate()
    {
        return Date;
    }
    public String getstatus()
    {
        return Status;
    }
    public void setDate(String d)
    {
        Date = d;
    }
    public void setStatus(String s)
    {
        Status = s;
    }
    
     public int getsem()
    {
        return this.semester;
    }
    public void setsem(int d)
    {
        semester = d;
    }
    
}
