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
public class Subscription {
    Course course;
    Student std;
    Section se;
    
    public Subscription(Course c, Student s, Section sec)
    {
        course=c;
        std=s;
        se=sec;
    }
    
}
