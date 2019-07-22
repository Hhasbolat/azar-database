package dbazar;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;


public class MessageInfo {
    private static final String messageInfoQuery="SELECT * FROM message_info";

 public static void messageInfo(Connection conMessageInfo) {
     try (Statement statement = conMessageInfo.createStatement();
          ResultSet resultSet = statement.executeQuery(messageInfoQuery)) {

         while (resultSet.next()) {

             Entry entry = new Entry();

             entry.setValue("ID", resultSet.getInt("id"));
             entry.setValue("Message Thread ID",resultSet.getString("messageThreadID") );
             entry.setValue("Message Type",resultSet.getString("messageType") );
             entry.setValue("Message Sequence No",resultSet.getInt("messageSeqNo") );
             entry.setValue("Sent By Me",getBollean(resultSet.getInt("sentByme")) );
             entry.setValue("Message Content",resultSet.getString("messageContent") );
             entry.setValue("Date Message Sent",date(resultSet.getString("dateMessageSent")) );
             entry.setValue("Title",resultSet.getString("title") );
             entry.setValue("Thumbnail URL",resultSet.getString("thumbnailURL") );
             entry.setValue("Thumbnail Width",resultSet.getInt("thumbnailWidth") );
             entry.setValue("Thumbnail Height",resultSet.getInt("thumbnailHeight") );
             entry.setValue("Image URL",resultSet.getString("imageURL") );
             entry.setValue("Image Width",resultSet.getInt("imageWidth") );
             entry.setValue("Image Height",resultSet.getInt("imageHeight") );
             entry.setValue("Image Is Embedded",getBollean(resultSet.getInt("imageIsEmbedded")) );
             entry.setValue("Button Caption",resultSet.getString("buttonCaption") );
             entry.setValue("Link URL",resultSet.getString("linkURL") );
             entry.setValue("State",resultSet.getString("state") );
             entry.setValue("Is System",getBollean(resultSet.getInt("isSystem")) );
             entry.setValue("Translated Message",resultSet.getString("translatedMessage") );



             int id=resultSet.getInt("id");
             if(resultSet.wasNull()){
                 entry.setValue("ID", "<Value Not Available>");
             }else{
                 entry.setValue("ID",resultSet.getInt("id"));
             }
             int messageSeqNo=resultSet.getInt("messageSeqNo");
             if(resultSet.wasNull()){
                 entry.setValue("MessageSeqNo", "<Value Not Available>");
             }else{
                 entry.setValue("MessageSeqNo",resultSet.getInt("messageSeqNo"));
             }
             int sentByme=resultSet.getInt("sentByme");
             if(resultSet.wasNull()){
                 entry.setValue("SentByme", "<Value Not Available>");
             }else{
                 entry.setValue("SentByme",resultSet.getInt("sentByme"));
             }
             int thumbnailWidth=resultSet.getInt("thumbnailWidth");
             if(resultSet.wasNull()){
                 entry.setValue("ThumbnailWidth", "<Value Not Available>");
             }else{
                 entry.setValue("ThumbnailWidth",resultSet.getInt("thumbnailWidth"));
             }
             int thumbnailHeight=resultSet.getInt("thumbnailHeight");
             if(resultSet.wasNull()){
                 entry.setValue("ThumbnailHeight", "<Value Not Available>");
             }else{
                 entry.setValue("ThumbnailHeight",resultSet.getInt("thumbnailHeight"));
             }
             int imageWidth=resultSet.getInt("imageWidth");
             if(resultSet.wasNull()){
                 entry.setValue("ImageWidth", "<Value Not Available>");
             }else{
                 entry.setValue("ImageWidth",resultSet.getInt("imageWidth"));
             }
             int imageHeight=resultSet.getInt("imageHeight");
             if(resultSet.wasNull()){
                 entry.setValue("ThumbnailWidth", "<Value Not Available>");
             }else{
                 entry.setValue("ThumbnailWidth",resultSet.getInt("imageHeight"));
             }
             int imageIsEmbedded=resultSet.getInt("imageIsEmbedded");
             if(resultSet.wasNull()){
                 entry.setValue("ImageIsEmbedded", "<Value Not Available>");
             }else{
                 entry.setValue("ImageIsEmbedded",resultSet.getInt("imageIsEmbedded"));
             }
             int isSystem=resultSet.getInt("isSystem");
             if(resultSet.wasNull()){
                 entry.setValue("IsSystem", "<Value Not Available>");
             }else{
                 entry.setValue("IsSystem",resultSet.getInt("isSystem"));
             }

             System.out.println(entry.getHashMap());

             System.out.println();

             System.out.println("------------------------------");

         }

     } catch (Exception exception) {
         System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
         System.exit(0);
     }
 }
 public static String getBollean(int integer) {
     String string="";
     if(integer==1){
         string= "YES";

     }else{
         string= "NO";
     }
     return string;
 }
 public static Date date(String source) throws ParseException {
        Date date =AzarDbMain.dateFormat.parse(source);
        return date;
    }

}
