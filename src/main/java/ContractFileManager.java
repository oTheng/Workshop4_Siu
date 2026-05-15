import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract) {
        try (FileWriter writer = new FileWriter("src/main/resources/contracts.csv", true)) {
            writer.write(contract.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving contract.");
        }
    }
}