package Business;

/**
 *
 * @author Aaron Lau
 */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    public static Connection getConnection() throws Exception {
        
        String dbPath = new File(
                "database" + File.separator + "ChattBankMDB.mdb").getAbsolutePath();
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        
        return DriverManager.getConnection(
            "jdbc:ucanaccess://" + dbPath);
    }//end getConnection()
}
