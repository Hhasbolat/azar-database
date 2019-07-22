package dbazar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DownloadableContents  {
    private static final String downloadableContentsQuery = "SELECT * FROM downloadable_contents";

    public static void downloadableContents(Connection conDownloadableContents) {
        try(Statement statement = conDownloadableContents.createStatement();
            ResultSet resultSet = statement.executeQuery(downloadableContentsQuery)){

            while(resultSet.next()){
                Entry entry = new Entry();

                entry.setValue("ID",resultSet.getString("id"));
                entry.setValue("URL" ,resultSet.getString("urlString"));
                entry.setValue("File Md5Hash",resultSet.getString("md5Hash"));
                entry.setValue("Next MD5Hash",resultSet.getString("nextMD5Hash"));
                entry.setValue("Is Available",isAvaliable(resultSet.getInt("isAvailable")));

                int isAvailable=resultSet.getInt("isAvailable");
                if(resultSet.wasNull()){
                    entry.setValue("IsAvailable", "<Value Not Available>");
                }else{
                    entry.setValue("IsAvailable",resultSet.getInt("isAvailable"));
                }

                System.out.println(entry.getHashMap());


            }

        }catch (Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
    }
    public static String isAvaliable(int integer) {
        String string="";
        if(integer==1){
           string ="File is exist ";
        }else {
            string= "File not exist ";
        }
        return string;
    }

}

