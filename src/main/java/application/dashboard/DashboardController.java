package application.dashboard;

import application.BaseController;
import application.user.PaceUser;
import application.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by allarviinamae on 16/05/16.
 * <p>
 * Main controller for Dashboard tab.
 */
@RestController
public class DashboardController extends BaseController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/dashboard")
    public ResponseEntity<Object> getUserShortTeamView(@RequestParam(value = "facebookId") String facebookId,
                                                       @RequestParam(value = "teamView") String teamView,
                                                       @RequestParam(value = "token") String token) {

        Connection<Facebook> connection = getFacebookConnection(token);

        if (connection == null) {
            return new ResponseEntity<>(new PaceUser().getShortTeamViewMap(), HttpStatus.UNAUTHORIZED);
        }

        if (teamView.equals("short")) {
            PaceUser paceUser = getPaceUser(facebookId);

            return new ResponseEntity<>(paceUser.getShortTeamViewMap(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
