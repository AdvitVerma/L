
package content;

/**
 *
 * @author Advit
 */
public class Student {
    private String ID;
    
    private double grade1;
    
     private double grade2;
     
      private double grade3;
      
       private double grade4;
       
        private double grade5;
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public double getGrade4() {
        return grade4;
    }

    public void setGrade4(double grade4) {
        this.grade4 = grade4;
    }

    public double getGrade5() {
        return grade5;
    }

    public void setGrade5(double grade5) {
        this.grade5 = grade5;
    }
    
    public double Average(){
    
        double Average;
        
        Average=(grade1+grade2+grade3+grade4+grade5)/5;
        
        
        
        
        return Average;
        
    
    }
    
}
