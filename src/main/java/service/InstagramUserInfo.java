package service;

import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

public class InstagramUserInfo {

    private final InstagramFeedResult instagramFeedResult;
    private final InstagramSearchUsernameResult instagramSearchUsernameResult;


    public InstagramUserInfo(final InstagramSearchUsernameResult instagramSearchUsernameResult,
                             final InstagramFeedResult instagramFeedResult) {
        this.instagramSearchUsernameResult = instagramSearchUsernameResult;
        this.instagramFeedResult = instagramFeedResult;
    }


    public void getUserInfoPage() {
        System.out.println(instagramSearchUsernameResult.getUser().biography);
        System.out.println(instagramSearchUsernameResult.getUser().username);
        System.out.println(instagramSearchUsernameResult.getUser().getFollower_count());

        for(InstagramFeedItem post : instagramFeedResult.getItems()) {
            System.out.println(post.caption.getText());
            System.out.println(post.getLike_count());
        }
    }



}
