import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramPostCommentRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

import java.io.IOException;

public class Bot{
    public static void main(String[] args) throws IOException {

        Instagram4j instagram = Instagram4j.builder().username("username").password("password").build();
        instagram.setup();
        instagram.login();
        InstagramSearchUsernameResult usernameResult = instagram.sendRequest(new InstagramSearchUsernameRequest("vermut.r"));
        System.out.println(usernameResult.getUser().biography);
        System.out.println(usernameResult.getUser().username);
        System.out.println(usernameResult.getUser().getFollower_count());

        InstagramFeedResult postList = instagram.sendRequest(new InstagramUserFeedRequest(usernameResult.getUser().getPk()));
        for(InstagramFeedItem post : postList.getItems()) {
            System.out.println(post.caption.getText());
            System.out.println(post.getLike_count());
        }



    }
}
