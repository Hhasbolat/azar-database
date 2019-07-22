package dbazar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FriendInfoCachev2 {
    private static final String friendInfoCacheV2Query = "SELECT * FROM friend_info_cache_v2";

    public static void friendInfoCacheV2(Connection conFriendInfoCachev2) {
        try (Statement statement = conFriendInfoCachev2.createStatement();
             ResultSet resultSet = statement.executeQuery(friendInfoCacheV2Query)) {


             while(resultSet.next()){
                 Entry entry = new Entry();

                 entry.setValue("FriendID",resultSet.getString("friendID"));
                 entry.setValue("SimpleName",resultSet.getString("simpleName"));
                 entry.setValue("Gender",resultSet.getString("gender"));
                 entry.setValue("Friend State",resultSet.getString("friendState"));
                 entry.setValue("Friend Type",resultSet.getString("friendType"));
                 entry.setValue("Is Friend Hidden",getBooleanValue(resultSet.getInt("friendHidden")));
                 entry.setValue("Recently Added",getBooleanValue(resultSet.getInt("recentlyAdded")));
                 entry.setValue("Is Deleted",getBooleanValue(resultSet.getInt("deleted")));
                 entry.setValue("Is Blocked",getBooleanValue(resultSet.getInt("nonBlockable")));
                 entry.setValue("Country",resultSet.getString("locationCountry"));
                 entry.setValue("Country Code",resultSet.getString("locationCountryCode"));
                 entry.setValue("Country City",resultSet.getString("locationCity"));
                 entry.setValue("Country State",resultSet.getString("locationState"));
                 entry.setValue("Time/ZoneID",resultSet.getString("locationTimeZoneId"));
                 entry.setValue("Cool Point",resultSet.getInt("coolPoint"));
                 entry.setValue("SmallPicture URL",resultSet.getString("smallPictureURL"));
                 entry.setValue("Large Picture URL",resultSet.getString("largePictureURL"));
                 entry.setValue("Small Profile ImageU RL",resultSet.getString("smallProfileImageURL"));
                 entry.setValue("Large Profile Image URL",resultSet.getString("largeProfileImageURL"));
                 entry.setValue("Message Thread ID",resultSet.getInt("messageThreadID"));
                 entry.setValue("Profile Message",resultSet.getString("profileMessage"));
                 entry.setValue("Cool Point Sent",resultSet.getInt("coolPointSent"));
                 entry.setValue("Favorite",getBooleanValue(resultSet.getInt("favorite")));
                 entry.setValue("Gift Points Info",resultSet.getString("virtualLocation"));
                 entry.setValue("Virtual Thumbnail Url",resultSet.getString("virtualThumbnailUrl"));
                 entry.setValue("Gif tPoints Info",resultSet.getString("lightweightGiftPointsInfo"));

                 int friendID=resultSet.getInt("friendID");
                 if(resultSet.wasNull()){
                     entry.setValue("FriendID", "<Value Not Available>");
                 }else{
                     entry.setValue("FriendID",resultSet.getInt("friendID"));
                 }
                 int friendHidden=resultSet.getInt("friendHidden");
                 if(resultSet.wasNull()){
                     entry.setValue("FriendHidden", "<Value Not Available>");
                 }else{
                     entry.setValue("FriendHidden",resultSet.getInt("friendHidden"));
                 }
                 int recentlyAdded=resultSet.getInt("recentlyAdded");
                 if(resultSet.wasNull()){
                     entry.setValue("RecentlyAdded", "<Value Not Available>");
                 }else{
                     entry.setValue("RecentlyAdded",resultSet.getInt("recentlyAdded"));
                 }
                 int deleted=resultSet.getInt("deleted");
                 if(resultSet.wasNull()){
                     entry.setValue("IsDeleted", "<Value Not Available>");
                 }else{
                     entry.setValue("IsDeleted",resultSet.getInt("deleted"));
                 }
                 int nonBlockable=resultSet.getInt("nonBlockable");
                 if(resultSet.wasNull()){
                     entry.setValue("NonBlockable", "<Value Not Available>");
                 }else{
                     entry.setValue("NonBlockable",resultSet.getInt("nonBlockable"));
                 }
                 int coolPoint=resultSet.getInt("coolPoint");
                 if(resultSet.wasNull()){
                     entry.setValue("CoolPoint", "<Value Not Available>");
                 }else{
                     entry.setValue("CoolPoint",resultSet.getInt("coolPoint"));
                 }
                 int messageThreadID=resultSet.getInt("messageThreadID");
                 if(resultSet.wasNull()){
                     entry.setValue("MessageThreadID", "<Value Not Available>");
                 }else{
                     entry.setValue("MessageThreadID",resultSet.getInt("messageThreadID"));
                 }
                 int favorite=resultSet.getInt("favorite");
                 if(resultSet.wasNull()){
                     entry.setValue("Favorite", "<Value Not Available>");
                 }else{
                     entry.setValue("Favorite",resultSet.getInt("favorite"));
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

    public static String getBooleanValue(int integer) {
        String string="";
        if(integer==1){
            string += "YES";
        }else {
            string += "NO";
        }
        return string;
    }


}