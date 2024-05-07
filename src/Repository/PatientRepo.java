package Repository;

import Entity.Doctor;
import Entity.Patient;
import Entity.Slot;

import java.util.HashMap;

public class PatientRepo {
    private HashMap<Integer, Patient> patientMap=new HashMap<>();
    private PatientRepo(){};
    private static PatientRepo instance;
    public static PatientRepo getInstance(){
        if(instance == null){
            instance = new PatientRepo();
        }
        return instance;
    }
    public Patient registerPat(String name){
        Integer id=(int) (Math.random()*10000)+1000;
        if(patientMap.containsKey(id)){
            return registerPat(name);
        }else{
            Patient pat=new Patient(name,id);
            patientMap.put(id,pat);
            return pat;
        }
    }
    public Patient getPatientById(Integer id){
        return patientMap.get(id);
    }
    public Patient getPatientByName(String name){
        for(Patient pat:patientMap.values()){
            if(pat.getName().equals(name)){
                return pat;
            }
        }
        return null;

    }

}
