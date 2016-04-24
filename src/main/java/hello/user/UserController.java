package hello.user;

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
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user")
    public PaceUser user(@RequestParam(value = "facebookId") String facebookId) {
        PaceUser result = null;
        for (PaceUser paceUser : userRepository.findByFacebookId(facebookId)) {
            result = paceUser;
        }
        return result;
    }
}

