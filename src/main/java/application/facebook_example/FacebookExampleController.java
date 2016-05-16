package application.facebook_example;

import application.BaseController;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacebookExampleController extends BaseController {

    @RequestMapping("/api/test_facebook")
    public String authorize(@RequestParam("token") String token) {
        Connection<Facebook> connection = getFacebookConnection(token);

        if (connection == null) {
            return "connection failed";
        }

        UserProfile userProfile = connection.fetchUserProfile();
        return userProfile.getName();
    }

}