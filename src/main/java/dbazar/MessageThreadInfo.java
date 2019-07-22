package dbazar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;

public class MessageThreadInfo {
    private static final String messageThreadInfoQuery="SELECT * FROM message_thread_info";

    public static void messageThreadInfo(Connection conMessageThreadInfo1) {
    try (Statement statement = conMessageThreadInfo1.createStatement();
         ResultSet resultSet = statement.executeQuery(messageThreadInfoQuery)) {

         while (resultSet.next()) {
             Entry entry = new Entry();

             entry.setValue("MessageThreadID",resultSet.getInt("messageThreadID"));
             entry.setValue("Friend ID",resultSet.getInt("friendID"));
             entry.setValue("Last Message Seq No",resultSet.getInt("lastMessageSeqNo"));
             entry.setValue("Last Message",resultSet.getString("lastMessage"));
             entry.setValue("Last Message Sent Date",date(resultSet.getString("dateLastMessageSent")));
             entry.setValue("Message Seq No User Read",resultSet.getInt("messageSeqNoUserRead"));
             entry.setValue("Message Seq No Peer Read",resultSet.getInt("messageSeqNoPeerRead"));
             entry.setValue("Close",resultSet.getInt("closed"));
             entry.setValue("Is Text Only",resultSet.getInt("textOnly"));
             entry.setValue("Is Notification Enabled",resultSet.getInt("notificationEnabled"));
             entry.setValue("Read Only",getBoolean(resultSet.getInt("readOnly")));
             entry.setValue("First Message Seq No",resultSet.getInt("firstMessageSeqNo"));
             entry.setValue("Last Message Sent ByMe",resultSet.getInt("lastMessageSentByMe"));
             entry.setValue("Broker Channel Name",resultSet.getString("brokerChannelName"));
             entry.setValue("Is Tranlation Supported",resultSet.getInt("translationSupported"));
             entry.setValue("Is Translation Enabled",resultSet.getInt("translationEnabled"));

             int messageThreadID=resultSet.getInt("messageThreadID");
             if(resultSet.wasNull()){
                 entry.setValue("MessageThreadID", "<Value Not Available>");
             }else{
                 entry.setValue("MessageThreadID",resultSet.getInt("messageThreadID"));
             }
             int friendID=resultSet.getInt("friendID");
             if(resultSet.wasNull()){
                 entry.setValue("Friend ID", "<Value Not Available>");
             }else{
                 entry.setValue("Friend ID",resultSet.getInt("friendID"));
             }
             int lastMessageSeqNo=resultSet.getInt("lastMessageSeqNo");
             if(resultSet.wasNull()){
                 entry.setValue("Last Message Seq No", "<Value Not Available>");
             }else{
                 entry.setValue("Last Message Seq No",resultSet.getInt("lastMessageSeqNo"));
             }
             int messageSeqNoUserRead=resultSet.getInt("messageSeqNoUserRead");
             if(resultSet.wasNull()){
                 entry.setValue("MessageSeqNoUserRead", "<Value Not Available>");
             }else{
                 entry.setValue("MessageSeqNoUserRead",resultSet.getInt("messageSeqNoUserRead"));
             }
             int messageSeqNoPeerRead=resultSet.getInt("messageSeqNoPeerRead");
             if(resultSet.wasNull()){
                 entry.setValue("MessageSeqNoPeerRead", "<Value Not Available>");
             }else{
                 entry.setValue("MessageSeqNoPeerRead",resultSet.getInt("messageSeqNoPeerRead"));
             }
             int closed=resultSet.getInt("closed");
             if(resultSet.wasNull()){
                 entry.setValue("Close", "<Value Not Available>");
             }else{
                 entry.setValue("Close",resultSet.getInt("closed"));
             }
             int textOnly=resultSet.getInt("textOnly");
             if(resultSet.wasNull()){
                 entry.setValue("IsTextOnly", "<Value Not Available>");
             }else{
                 entry.setValue("IsTextOnly",resultSet.getInt("textOnly"));
             }
             int notificationEnabled=resultSet.getInt("notificationEnabled");
             if(resultSet.wasNull()){
                 entry.setValue("IsNotificationEnabled", "<Value Not Available>");
             }else{
                 entry.setValue("IsNotificationEnabled",resultSet.getInt("notificationEnabled"));
             }
             int readOnly=resultSet.getInt("readOnly");
             if(resultSet.wasNull()){
                 entry.setValue("ReadOnly", "<Value Not Available>");
             }else{
                 entry.setValue("ReadOnly",resultSet.getInt("readOnly"));
             }
             int firstMessageSeqNo=resultSet.getInt("firstMessageSeqNo");
             if(resultSet.wasNull()){
                 entry.setValue("FirstMessageSeqNo", "<Value Not Available>");
             }else{
                 entry.setValue("FirstMessageSeqNo",resultSet.getInt("firstMessageSeqNo"));
             }
             int lastMessageSentByMe=resultSet.getInt("lastMessageSentByMe");
             if(resultSet.wasNull()){
                 entry.setValue("LastMessageSentByMe", "<Value Not Available>");
             }else{
                 entry.setValue("LastMessageSentByMe",resultSet.getInt("lastMessageSentByMe"));
             }
             int translationSupported=resultSet.getInt("translationSupported");
             if(resultSet.wasNull()){
                 entry.setValue("IsTranlationSupported", "<Value Not Available>");
             }else{
                 entry.setValue("IsTranlationSupported",resultSet.getInt("translationSupported"));
             }
             int translationEnabled=resultSet.getInt("translationEnabled");
             if(resultSet.wasNull()){
                 entry.setValue("IsTranslationEnabled", "<Value Not Available>");
             }else{
                 entry.setValue("IsTranslationEnabled",resultSet.getInt("translationEnabled"));
             }



             System.out.println(entry.getHashMap());

             System.out.println();

             System.out.println("------------------------------");
        }


    }catch (Exception exception){
        System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
        System.exit(0);
    }
     }
        public static String getBoolean(int integer) {
        String string="";
        if(integer==1){
            string= "YES";

        }else{
            string= "NO";
        }
        return string;
    }
    public static Date date(String source) throws ParseException {
        Date date = AzarDbMain.dateFormat.parse(source);
        return date;
    }
}
