package Service;

import Entity.Doctor;
import Entity.Slot;
import Repository.DoctorRepo;
import Repository.SlotRepo;
import utility.Designation;

import java.util.List;

public class DoctorService  {
    private DoctorRepo docRepo=DoctorRepo.getInstance();
    private SlotRepo slotRepo=SlotRepo.getInstance();
    private DoctorService(){

    }
    private static DoctorService instance;
    public static DoctorService getInstance(){
        if(instance == null){
            instance = new DoctorService();
        }
        return instance;
    }

  public Doctor registerDoc(String name, Designation designation) {
        try{
            Doctor doc=docRepo.registerDoc(name, designation);
            if(doc!=null)
            System.out.println("Welcome Dr "+name+ "!!");

            return doc;
        }
        catch (Exception e){
            System.out.println("Some error occured. Please try again");
        }
return null;

    }
    public void markDocAvail(Integer doctorId,int startTime,int EndTime){
        try{
            if((EndTime-startTime)!=1){
                System.out.println( "Sorry Dr." +docRepo.getDoctorById(doctorId)+ " slots are 60 mins only");
            }
            slotRepo.markDocAvail(doctorId,startTime,EndTime,docRepo.getDoctorById(doctorId).getDesignation());
            System.out.println( " Done Doc!");
        }
        catch (Exception e){
            System.out.println("Some error occured. Please try again");
        }

    }

    public void showAvailByspeciality(Designation designation){
        try{
List<Slot> list=slotRepo.showAvailByspeciality(designation);
for(Slot slot:list){
    System.out.println("Dr "+slot.getDoctor().getName()+ " ("+slot.getStartTime()+":"+slot.getEndTime()+")");
}
        }
        catch(Exception e){
System.out.println("Some error occured. Please try again");
        }
    }
}
