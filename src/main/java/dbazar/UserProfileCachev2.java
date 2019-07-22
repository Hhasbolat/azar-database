package dbazar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserProfileCachev2 {
    private static final String userProfileCacheV2Query = "SELECT * FROM user_profile_cache_v2";


    public static void userProfileCacheV2(Connection conUserProfileCacheV2) {
        try (Statement statement = conUserProfileCacheV2.createStatement();
             ResultSet resultSet = statement.executeQuery(userProfileCacheV2Query)) {

            while (resultSet.next()) {
                Entry entry = new Entry();

                entry.setValue("UserIID",resultSet.getInt("userID"));
                entry.setValue("Login Type",resultSet.getString("loginType"));
                entry.setValue("Username",resultSet.getString("username"));
                entry.setValue("Simple Name",resultSet.getString("simpleName"));
                entry.setValue("Gender",resultSet.getString("gender"));
                entry.setValue("Birth Year",resultSet.getInt("birthYear"));
                entry.setValue("Location Country",resultSet.getString("locationCountry"));
                entry.setValue("Location Country Code",resultSet.getString("locationCountryCode"));
                entry.setValue("Location City",resultSet.getString("locationCity"));
                entry.setValue("Location State",resultSet.getString("locationState"));
                entry.setValue("Location TimeZone ID",resultSet.getString("locationTimeZoneID"));
                entry.setValue("Virtual Location",resultSet.getString("virtualLocation"));
                entry.setValue("Virtual Thumbnail Url",resultSet.getString("virtualThumbnailUrl"));
                entry.setValue("Thumbnail ImageURL",resultSet.getString("thumbnailImageURL"));
                entry.setValue("Profile Image URL",resultSet.getString("profileImageURL"));
                entry.setValue("Profile Image State",resultSet.getString("profileImageState"));
                entry.setValue("Cool Point",resultSet.getInt("coolPoint"));
                entry.setValue("Cool Point Changed",resultSet.getInt("coolPointChanged"));
                entry.setValue("Profile Message",resultSet.getString("profileMessage"));
                entry.setValue("Azar ID",resultSet.getString("azarID"));
                entry.setValue("Original Name",resultSet.getString("originalName"));
                entry.setValue("Nickname Review State",resultSet.getString("nicknameReviewState"));
                entry.setValue("Unique Profile",resultSet.getInt("uniqueProfile"));
                entry.setValue("UserLanguage Entries",resultSet.getString("userLanguageEntries"));
                entry.setValue("Lightweight Gift Points Info",resultSet.getString("lightweightGiftPointsInfo"));
                entry.setValue("Cover Profile Image URL",resultSet.getString("coverProfileImageURL"));

                int userID=resultSet.getInt("userID");
                if(resultSet.wasNull()){
                    entry.setValue("UserIID", "<Value Not Available>");
                }else{
                    entry.setValue("UserIID",resultSet.getInt("userID"));
                }
                int birthYear=resultSet.getInt("birthYear");
                if(resultSet.wasNull()){
                    entry.setValue("BirthYear", "<Value Not Available>");
                }else{
                    entry.setValue("BirthYear",resultSet.getInt("birthYear"));
                }
                int coolPoint=resultSet.getInt("coolPoint");
                if(resultSet.wasNull()){
                    entry.setValue("CoolPoint", "<Value Not Available>");
                }else{
                    entry.setValue("CoolPoint",resultSet.getInt("coolPoint"));
                }
                int coolPointChanged=resultSet.getInt("coolPointChanged");
                if(resultSet.wasNull()){
                    entry.setValue("CoolPointChanged", "<Value Not Available>");
                }else{
                    entry.setValue("CoolPointChanged",resultSet.getInt("coolPointChanged"));
                }
                int uniqueProfile=resultSet.getInt("uniqueProfile");
                if(resultSet.wasNull()){
                    entry.setValue("UniqueProfile", "<Value Not Available>");
                }else{
                    entry.setValue("UniqueProfile",resultSet.getInt("uniqueProfile"));
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
}
