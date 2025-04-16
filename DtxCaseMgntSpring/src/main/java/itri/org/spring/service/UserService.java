package itri.org.spring.service;

import java.util.Map;
import itri.org.spring.model.User;

public interface UserService {
    User register(String username, String account, String email, String telCell, String password);
    User findByAccount(String account);
    boolean verifyLogin(String account, String password);
    boolean validateCaptcha(String userInput, String sessionCaptcha);
    Map<String, Object> generateUserInfo(User user);
}