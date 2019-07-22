package dbazar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AzarMeta {
    private static final String azarMetaQuery = "SELECT * FROM azar_meta";

    public static void azarMeta(Connection conAzarMeta) {
        try(Statement statement = conAzarMeta.createStatement();
            ResultSet resultSet = statement.executeQuery(azarMetaQuery)){

            HashMap<String,String> hashMap = new HashMap<String, String>(); // We made hashmap object beasuse we have key and a value.

            while(resultSet.next()) {
                hashMap.put(resultSet.getString("key"), resultSet.getString("value"));
            }
            StringBuilder sb= new StringBuilder(); // More efficent than string.
            sb.append(" The metadata applications in the application are kept. \n Synchronization with other applications and how the application is logged in and the application settings are kept.\n\n");
            sb.append(" GENDER KEY= "+ hashMap.get("MATCH_GENDER_KEY")+ "||"); sb.append(" FIRST_LAUNCH= "+ hashMap.get("AZAR_FIRST_LAUNCH")+ "||");
            sb.append(" EULA AGREE= "+ hashMap.get("AZAR_EULA_AGREE")+ "||"); sb.append(" IS NEED TO REPORT INSTALLATION= "+ hashMap.get("AZAR_IS_NEED_TO_REPORT_INSTALLATION")+ "||");
            sb.append(" STORED LOGIN SESSION JSON= "+ hashMap.get("AZAR_STORED_LOGIN_SESSION_JSON")+ "||"); sb.append(" EffectFirstSelected= "+ hashMap.get("isEffectFirstSelected")+ "||");
            sb.append(" BlurDefaultApplied= "+ hashMap.get("isBlurDefaultApplied")+ "||"); sb.append(" BLUR FACE IF NOT RECOGNIZED= "+ hashMap.get("AZAR_BLUR_FACE_IF_NOT_RECOGNIZED")+ "||");
            sb.append(" LanguageBadgeHidden= "+ hashMap.get("isLanguageBadgeHidden")+ "||"); sb.append(" NotificationRequested= "+ hashMap.get("notificationRequested")+ "||");
            sb.append(" IsConnectGuideShown= "+ hashMap.get("isConnectGuideShown")+ "||"); sb.append(" ShowLightWeightGiftTutorial= "+ hashMap.get("showLightWeightGiftTutorial")+ "||");
            sb.append(" DiscoverTalkingModeCoachmarkForThumbsUpShown= "+ hashMap.get("isDiscoverTalkingModeCoachmarkForThumbsUpShown")+ "||");sb.append(" WEB POPUP READ TIME:300gem_promo_iOS= "+ hashMap.get("AZAR_WEB_POPUP_READ_TIME:300gem_promo_iOS")+ "||");
            sb.append(" SETTINGS KEY REQUEST FRIEND USE GEM FOR HISTORY PEER= "+ hashMap.get("AZAR_SETTINGS_KEY_REQUEST_FRIEND_USE_GEM_FOR_HISTORY_PEER")+ "||"); sb.append(" FIRST_LAUNCH= "+ hashMap.get("isSuperDiscoverTabShown")+ "||");
            sb.append(" EffectRebootHighlightShown= "+ hashMap.get("isEffectRebootHighlightShown")+ "||"); sb.append("LATEST COOLSENT DATE= "+ hashMap.get("AZAR_LATEST_COOLSENT_DATE")+ "||");
            sb.append(" COACHMARK_MIRROR_SWIPE= "+ hashMap.get("COACHMARK_MIRROR_SWIPE")+ "||"); sb.append("COACHMARK_MIRROR_GENDER_REGION= "+ hashMap.get("COACHMARK_MIRROR_GENDER_REGION")+ "||");
            sb.append(" COACHMARK_MIRROR_NEW_THUMBS_UP= "+ hashMap.get("COACHMARK_MIRROR_NEW_THUMBS_UP")+ "||"); sb.append("GENDER_KEY= "+ hashMap.get("isDiscoverTalkingModeCoachmarkForFriendRequestShown")+ "||");
            sb.append(" IsDiscoverTalkingModeCoachmarkForReportShown= "+ hashMap.get("isDiscoverTalkingModeCoachmarkForReportShown")+ "||"); sb.append(" IsDiscoverTalkingModeCoachmarkForContentsButtonShown= "+ hashMap.get("isDiscoverTalkingModeCoachmarkForContentsButtonShown")+ "||");
            sb.append(" IsDiscoverTalkingModeCoachmarkForGiftShown= "+ hashMap.get("isDiscoverTalkingModeCoachmarkForGiftShown")+ "||"); sb.append(" IsEasyConnectEnabled= "+ hashMap.get("isEasyConnectEnabled")+ "||");
            sb.append(" AZAR NUMBER OF_SWIPE_FROM_MIRROR_TO_MATCH= "+ hashMap.get("AZAR_NUMBER_OF_SWIPE_FROM_MIRROR_TO_MATCH")+ "||"); sb.append(" IsNoThumbsUpGiftClicked= "+ hashMap.get("isNoThumbsUpGiftClicked")+ "||");
            sb.append(" AZAR RECENT EMOJIS= "+ hashMap.get("AZAR_RECENT_EMOJIS")+ "||"); sb.append(" AzarTipGenderCount= "+ hashMap.get("azarTipGenderCount")+ "||");
            sb.append(" AZAR SCHEMA VERSION= "+ hashMap.get("AZAR_SCHEMA_VERSION")+ "||"); sb.append(" AZAR LAUNCH COUNT= "+ hashMap.get("AZAR_LAUNCH_COUNT")+ "||");
            sb.append(" AZAR USER ID= "+ hashMap.get("AZAR_USER_ID")+ "||"); sb.append(" AZAR FACEBOOK SYNC ENABLED= "+ hashMap.get("AZAR_FACEBOOK_SYNC_ENABLED")+ "||");
            sb.append(" IsBimaxEnabled= "+ hashMap.get("isBimaxEnabled")+ "||"); sb.append(" IsHighResolutionEnabled= "+ hashMap.get("isHighResolutionEnabled")+ "||");
            sb.append(" SelectedFilterID= "+ hashMap.get("selectedFilterID")); sb.append(" SelectedGraphicsID= "+ hashMap.get("selectedGraphicsID")+ "||");
            sb.append(" EffectBimaxIntensity= "+ hashMap.get("effectBimaxIntensity")); sb.append(" AZAR FACEBOOK SYNC= "+ hashMap.get("AZAR_FACEBOOK_SYNC")+ "||");
            sb.append(" IsPopularShown= "+ hashMap.get("isPopularShown")+ "||");

                 System.out.println(sb);

                 System.out.println();

        }catch (Exception exception){
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
    }
}

