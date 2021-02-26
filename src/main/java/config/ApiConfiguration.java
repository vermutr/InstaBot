package config;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUserFeedRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

import java.io.IOException;

public class ApiConfiguration {

    public Instagram4j instagram4j(final String username, final String password) throws IOException {
        Instagram4j instagram = new Instagram4j(username,password);
        instagram.setup();
        instagram.login();
        return instagram;
    }

    public InstagramSearchUsernameResult instagramSearchUsernameResult(final Instagram4j instagram,
                                                                       final InstagramSearchUsernameRequest instagramSearchUsernameRequest) throws IOException {
        return instagram.sendRequest(instagramSearchUsernameRequest);
    }

    public InstagramFeedResult instagramFeedRequest(final Instagram4j instagram,
                                                        final InstagramSearchUsernameResult instagramSearchUsernameResult) throws IOException {
        return instagram.sendRequest(new InstagramUserFeedRequest(instagramSearchUsernameResult.getUser().getPk()));
    }

    public InstagramSearchUsernameRequest instagramSearchUsernameRequest(final String username){
        return new InstagramSearchUsernameRequest(username);
    }
}
