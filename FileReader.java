import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileReader {
    public static Map<String, Float> ReadFile(String filename)throws IOException {
        Map<String, Float> balances = new HashMap<>();
        DataInputStream dis = new DataInputStream(new FileInputStream(filename));

        int numPlayers = dis.readInt();

        for (int i = 0; i < numPlayers; i++) {
            String name = dis.readUTF();
            float balance = dis.readFloat();
            balances.put(name, balance);
        }

        dis.close();
        return balances;
    }
    public static void WriteFile(String filename, Map<String, Float> balances) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));
        dos.writeInt(balances.size()); // Write number of players to file

        for (Map.Entry<String, Float> entry : balances.entrySet()) {
            String name = entry.getKey();
            float balance = entry.getValue();
            dos.writeUTF(name);
            dos.writeFloat(balance);
        }

        dos.close();
    }
}
