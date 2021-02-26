import config.ApiConfiguration;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramFollowRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import service.InstagramUserInfo;

import java.io.IOException;

public class Bot{
    public static void main(String[] args) throws IOException {

        ApiConfiguration apiConfiguration=new ApiConfiguration();
        Instagram4j instagram = apiConfiguration.instagram4j("username", "password");
        InstagramSearchUsernameRequest instagramSearchUsernameRequest = apiConfiguration.instagramSearchUsernameRequest("username");
        InstagramSearchUsernameResult instagramSearchUsernameResult = apiConfiguration.instagramSearchUsernameResult(instagram, instagramSearchUsernameRequest);
        InstagramFeedResult instagramFeedResult = apiConfiguration.instagramFeedRequest(instagram,instagramSearchUsernameResult);


        InstagramUserInfo instagramUserInfo = new InstagramUserInfo(
                instagramSearchUsernameResult,
                instagramFeedResult
        );

        instagramUserInfo.getUserInfoPage();




    }
}
