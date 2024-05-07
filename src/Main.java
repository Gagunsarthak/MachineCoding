import Entity.Doctor;
import Entity.Patient;
import Service.DoctorService;
import Service.PatientService;
import utility.Designation;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        DoctorService doctorService=DoctorService.getInstance();
        PatientService patientService=PatientService.getInstance();

        Doctor doc=doctorService.registerDoc("Curious", Designation.Cardiologist);
        Doctor doc2=doctorService.registerDoc("Furious", Designation.Dermatologist);
        doctorService.markDocAvail(doc.getId(),9,10);
        doctorService.markDocAvail(doc.getId(),12,13);
        doctorService.markDocAvail(doc.getId(),16,17);

        doctorService.markDocAvail(doc2.getId(),12,13);
        doctorService.showAvailByspeciality(Designation.Cardiologist);
        Patient pat=patientService.registerPatient("PatientA");
        patientService.bookSlot("PatientA","Curious",12);
        patientService.bookSlot("PatientA","Curious",12);
        patientService.bookSlot("PatientA","Furious",12);

    }
}