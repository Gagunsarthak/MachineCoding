package Repository;

import Entity.Doctor;
import Entity.Slot;
import utility.Designation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlotRepo {
    private HashMap<Integer, Slot> slotMap=new HashMap<>();
    private SlotRepo(){}
    private static SlotRepo instance;
    private static  DoctorRepo docRepo=DoctorRepo.getInstance();
    private static  PatientRepo patRepo=PatientRepo.getInstance();
    public static SlotRepo getInstance(){
        if(instance == null){
            instance = new SlotRepo();
        }
        return instance;
    }

    public Slot markDocAvail(Integer doctorId, int startTime, int EndTime, Designation designation) {
        Integer id=(int) (Math.random()*10000)+1000;
        if(slotMap.containsKey(id)){
          return markDocAvail(doctorId,startTime,EndTime,designation);
        }else{
            Slot slot=new Slot(id,startTime,EndTime,docRepo.getDoctorById(doctorId),designation);
            slotMap.put(id,slot);
            return slot;
        }



    }

    public List<Slot> showAvailByspeciality(Designation designation){
        List<Slot> slotList=new ArrayList<>();
        for(Slot slot:slotMap.values()){
            if(slot.getDesignation().equals(designation) && slot.getBookedBy()==null){
                slotList.add(slot);
            }

        }
        return slotList;
    }
   public Slot bookSlot(String name,String doctorName,int startTime) throws Exception{
        Slot out=null;
        for(Slot slot:slotMap.values()){
            if(slot.getBookedBy()!=null){
                throw new Exception("Slot Already booked");
            }
            if(slot.getStartTime()==startTime && slot.getDoctor().getName()!=doctorName && slot.getBookedBy()!=null){
                throw new Exception("Concurrent bookings not allowed");
            }
            if(slot.getStartTime()==startTime && slot.getDoctor().getName()==doctorName  ){
                slot.setBookedBy(patRepo.getPatientByName(name).getId());
                out= slot;

            }
        }
        return out;
   }

}
