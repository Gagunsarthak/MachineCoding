package Repository;

import Entity.Doctor;
import Entity.Slot;
import utility.Designation;

import java.util.HashMap;
import java.util.Map;

public class DoctorRepo {
    HashMap<Integer, Doctor> doctorMap= new HashMap<Integer, Doctor>();

    private  DoctorRepo(){}
    private static DoctorRepo instance;
    public static DoctorRepo getInstance(){
        if(instance == null){
            instance = new DoctorRepo();
        }
        return instance;
    }
    public Doctor registerDoc(String name, Designation designation){
        Integer id=(int) (Math.random()*10000)+1000;
        if(doctorMap.containsKey(id)){
            return registerDoc(name, designation);
        }
        Doctor doctor=new Doctor(name,designation,id);
        doctorMap.put(id, doctor);
        return doctor;
    }
public Doctor getDoctorById(Integer id){
        return doctorMap.get(id);
}
    }

