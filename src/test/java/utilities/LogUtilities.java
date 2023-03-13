package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LogUtilities {
    private static String logFile="src/test/resources/testdata/PatientCreationLog.txt";
    public static void savePatientCreationInfo(String patientId, Boolean appendMode){
        try{

            FileWriter fileWriter = new FileWriter(logFile, appendMode);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            if(patientId.length()>0) {writer.append("Patient Id = "+patientId+"\n");}
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void savePatientCreationInfo(List<String> patientsList, Boolean appendMode){
        try{

            FileWriter fileWriter = new FileWriter(logFile, appendMode);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            String data="";
            for(String patientId:patientsList){
                if(patientId.length()>0) {  data+="Patient Id = "+patientId+"\n"; }
            }
            writer.append(data);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<String> getAllCreatedPatientIds(){
        List<String> ids=new ArrayList<>();
        try{
            //identify file location
            FileReader fileReader = new FileReader(logFile);

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            while(line != null){
                String[] parts=line.split("=");
                if(parts.length==2){
                    ids.add(parts[1].trim());
                }
                line = br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ids;
    }
    public static String getFirstCreatedPatientId(){
        String id="";
        try{
            //identify file location
            FileReader fileReader = new FileReader(logFile);

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            if(line!=null && line.split("=").length==2){
                id=line.split("=")[1].trim();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

}
