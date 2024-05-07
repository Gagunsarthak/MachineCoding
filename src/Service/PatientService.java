package Service;

import Entity.Doctor;
import Entity.Patient;
import Entity.Slot;
import Repository.PatientRepo;
import Repository.SlotRepo;
import utility.Designation;

public class PatientService {
    private static PatientService instance;
    private PatientRepo patRepo=PatientRepo.getInstance();
    private SlotRepo slotRepo=SlotRepo.getInstance();
    private PatientService(){}
    public static PatientService getInstance(){
        if(instance == null){
            instance = new PatientService();
        }
        return instance;
    }

    public Patient registerPatient(String name) {
        try{
            Patient pat=patRepo.registerPat(name);
            if(pat!=null)
                System.out.println(name+ " registered successfully");

            return pat;
        }
        catch (Exception e){
            System.out.println("Some error occured. Please try again");
        }
        return null;

    }
    public void bookSlot(String name,String doctorName,int startTime){
       try{
           Slot slot=slotRepo.bookSlot(name,doctorName,startTime);
           if(slot!=null){
               System.out.println( "  Booked. Booking id: "+slot.getId());

           }
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }

    }
}

