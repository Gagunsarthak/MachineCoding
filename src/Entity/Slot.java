package Entity;

import utility.Designation;

public class Slot {
    private int id;
    private int startTime;
    private int endTime;
private Doctor doctor;
private Integer bookedBy=null;
private Designation designation;
    public Slot(int id, int startTime, int endTime,Doctor doctor,Designation designation) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor=doctor;
        this.designation=designation;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }



    public Integer getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(Integer bookedBy) {
        this.bookedBy = bookedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
