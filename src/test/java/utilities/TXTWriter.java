package utilities;

import api.pojos.US02_API_Register;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;


public class TXTWriter {


    public static void saveRegisterData(US02_API_Register[] us02_api_registers) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_all_registrant_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);


            for (int i = 0; i < us02_api_registers.length; i++) {
                writer.append(us02_api_registers[i].getFirstName() + "," + us02_api_registers[i].getLastName() + "," + us02_api_registers[i].getSsn() + "," + us02_api_registers[i].getLogin() +
                        "," + us02_api_registers[i].getId() + "," + us02_api_registers[i].getEmail() + "\n");
            }

            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
