/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsenHelper;

/**
 *
 * @author Haydar Dzaky S
 */
public class AbsentFiqih {
    
    private String  StudentId, Student, Date, Time;
    
    public AbsentFiqih( String mStudentId, String mStudent, String mTime, String mDate) {
    
        this.StudentId = mStudentId;
        this.Student = mStudent;
        this.Date = mDate;
        this.Time = mTime;
        
}
  
    public String getStudentId(){
        return StudentId;
    }
    
    public String getStudent(){
        return Student;
    }
    
    public String getTime(){
        return Time;
    }
    
    public String getDate(){
        return Date;
    }
    
}
