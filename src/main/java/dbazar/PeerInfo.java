package dbazar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;

public class PeerInfo {
    private static final String peerInfoQuery = "SELECT * FROM peer_info";

    public static void peerInfo(Connection conPeerInfo) {
        try (Statement statement = conPeerInfo.createStatement();
             ResultSet resultSet = statement.executeQuery(peerInfoQuery)) {

            while (resultSet.next()) {
                Entry entry = new Entry();

                entry.setValue("ID",resultSet.getInt("id"));
                entry.setValue("Match ID",resultSet.getString("matchID"));
                entry.setValue("Simple Name",resultSet.getString("simpleName"));
                entry.setValue("Gender",resultSet.getString("gender"));
                entry.setValue("Country",resultSet.getString("locationCountry"));
                entry.setValue("Country Code",resultSet.getString("locationCountryCode"));
                entry.setValue("City",resultSet.getString("locationCity"));
                entry.setValue("State",resultSet.getString("locationState"));
                entry.setValue("Location TimeZone ID",resultSet.getString("locationTimeZoneID"));
                entry.setValue("Profile Image URL",resultSet.getString("profileImageURL"));
                entry.setValue("Capture Image URL",resultSet.getString("captureImageURL"));
                entry.setValue("Report Image URL",resultSet.getString("reportImageURL"));
                entry.setValue("No Capture Reason",resultSet.getString("noCaptureReason"));
                entry.setValue("Friend Requested",resultSet.getInt("friendRequested"));
                entry.setValue("Matched Date",date(resultSet.getString("matchedDate")));
                entry.setValue("Cool Point Sent",resultSet.getInt("coolPointSent"));
                entry.setValue("Cool Point",resultSet.getInt("coolPoint"));
                entry.setValue("GiftSent",resultSet.getInt("giftSent"));
                entry.setValue("Gift Received",resultSet.getInt("giftReceived"));
                entry.setValue("Virtual Location",resultSet.getString("virtualLocation"));
                entry.setValue("Virtual ThumbnailUrl",resultSet.getString("virtualThumbnailUrl"));
                entry.setValue("Peer Category",resultSet.getString("peerCategory"));
                entry.setValue("Super DiscoverCard ID",resultSet.getString("superDiscoverCardID"));
                entry.setValue("Cover ProfileImage URL",resultSet.getString("coverProfileImageURL"));

                int id=resultSet.getInt("id");
                if(resultSet.wasNull()){
                    entry.setValue("ID", "<Value Not Available>");
                }else{
                    entry.setValue("ID",resultSet.getInt("id"));
                }
                int friendRequested=resultSet.getInt("friendRequested");
                if(resultSet.wasNull()){
                    entry.setValue("FriendRequested", "<Value Not Available>");
                }else{
                    entry.setValue("FriendRequested",resultSet.getInt("friendRequested"));
                }
                int coolPointSent=resultSet.getInt("coolPointSent");
                if(resultSet.wasNull()){
                    entry.setValue("CoolPointSent", "<Value Not Available>");
                }else{
                    entry.setValue("CoolPointSent",resultSet.getInt("coolPointSent"));
                }
                int coolPoint=resultSet.getInt("coolPoint");
                if(resultSet.wasNull()){
                    entry.setValue("CoolPoint", "<Value Not Available>");
                }else{
                    entry.setValue("CoolPoint",resultSet.getInt("coolPoint"));
                }
                int giftSent=resultSet.getInt("giftSent");
                if(resultSet.wasNull()){
                    entry.setValue("GiftSent", "<Value Not Available>");
                }else{
                    entry.setValue("GiftSent",resultSet.getInt("giftSent"));
                }
                int giftReceived=resultSet.getInt("giftReceived");
                if(resultSet.wasNull()){
                    entry.setValue("GiftReceived", "<Value Not Available>");
                }else{
                    entry.setValue("GiftReceived",resultSet.getInt("giftReceived"));
                }

                System.out.println(entry.getHashMap());

                System.out.println();

                System.out.println("------------------------------");


            }
        } catch (Exception excepiton) {
            System.err.println(excepiton.getClass().getName() + ": " + excepiton.getMessage());
            System.exit(0);
        }
    }

    public static Date date(String source) throws ParseException {
        Date date = AzarDbMain.dateFormat.parse(source);
        return date;
    }

    public static String getBoolean(int integer) {
        String string = "";
        if (integer == 1) {
            string = "YES";

        } else {
            string = "NO";
        }
        return string;
    }

}
