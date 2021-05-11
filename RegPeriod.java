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
public class RegPeriod {
    private String Registration;
   private  String Withdrawal;
   private int semester;
    
    public RegPeriod()
    {
        this.Registration = " ";
        this.Withdrawal = " ";
      
        semester = 0;
    }
     public RegPeriod(String rg, String wd, int s)
    {
        this.Registration = rg;
        this.Withdrawal = wd;
        semester = s;
    }
    
     String getReg()
     {
         return this.Registration;
     }
     
     String getWdate()
     {
         return this.Withdrawal;
     }
     int getSemester()
     {
         return semester;
     }
     
     
     
     
}
