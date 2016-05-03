package application.user;

import application.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by allarviinamae on 15/04/16.
 * <p>
 * Example.
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/api/user")
    public PaceUser user(@RequestParam(value = "facebookId", required = false) String facebookId) {
        if (facebookId != null) {
            return getPaceUser(facebookId);
        }
        return new PaceUser();
    }

    @RequestMapping("/api/users")
    public Iterable<PaceUser> users() {
        return userRepository.findAll();
    }

    private PaceUser getPaceUser(@RequestParam(value = "facebookId") String facebookId) {
        PaceUser result = null;
        for (PaceUser paceUser : userRepository.findByFacebookId(facebookId)) {
            result = paceUser;
        }
        return result;
    }

}

