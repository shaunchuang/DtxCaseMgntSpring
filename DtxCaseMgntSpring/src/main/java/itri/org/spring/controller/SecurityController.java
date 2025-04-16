package itri.org.spring.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import itri.org.spring.model.User;
import itri.org.spring.service.CaptchaService;
import itri.org.spring.service.UserService;

@RestController
@RequestMapping("/security/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"}, allowCredentials = "true")
public class SecurityController {

    private static final String CAPTCHA_SESSION_KEY = "CAPTCHA_SESSION_KEY";

    @Autowired
    private UserService userService;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 處理用戶註冊
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(
            @RequestBody Map<String, String> registerData,
            HttpSession session) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            // 驗證驗證碼
            String userCaptcha = registerData.get("captcha");
            String sessionCaptcha = (String) session.getAttribute(CAPTCHA_SESSION_KEY);
            
            if (!captchaService.validateCaptcha(userCaptcha, sessionCaptcha)) {
                response.put("success", false);
                response.put("message", "驗證碼不正確");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            
            // 清除驗證碼，避免重複使用
            session.removeAttribute(CAPTCHA_SESSION_KEY);
            
            // 註冊用戶
            User newUser = userService.register(
                    registerData.get("username"),
                    registerData.get("account"),
                    registerData.get("email"),
                    registerData.get("telCell"),
                    registerData.get("password")
            );
            
            response.put("success", true);
            response.put("message", "註冊成功，請等待管理員審核");
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * 處理用戶登入
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody Map<String, String> loginData,
            HttpSession session) {
        
        Map<String, Object> response = new HashMap<>();
        
        try {
            String account = loginData.get("account");
            String password = loginData.get("password");
            String userCaptcha = loginData.get("captcha");
            
            // 驗證驗證碼
            String sessionCaptcha = (String) session.getAttribute(CAPTCHA_SESSION_KEY);
            if (!captchaService.validateCaptcha(userCaptcha, sessionCaptcha)) {
                response.put("success", false);
                response.put("message", "驗證碼不正確");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            
            // 清除驗證碼，避免重複使用
            session.removeAttribute(CAPTCHA_SESSION_KEY);
            
            // 進行身份驗證
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account, password));
            
            // 存儲認證信息到 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            // 獲取用戶信息
            User user = userService.findByAccount(account);
            
            // 檢查用戶狀態
            if (user.getStatus() != User.UserStatus.APPROVED) {
                response.put("success", false);
                response.put("message", "您的賬號尚未通過審核，請聯繫管理員");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
            
            // 生成用戶信息
            Map<String, Object> userInfo = userService.generateUserInfo(user);
            
            response.put("success", true);
            response.put("message", "登入成功");
            response.put("user", userInfo);
            response.put("dailyLoginPoints", 5); // 示例積分獎勵
            response.put("dailyLoginMessage", "恭喜獲得每日登入獎勵 5 積分！");
            response.put("currentPoints", 100); // 示例總積分
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "登入失敗，請檢查帳號密碼");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    /**
     * 生成並返回驗證碼
     */
    @GetMapping("/captcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        // 清除之前的驗證碼
        session.removeAttribute(CAPTCHA_SESSION_KEY);
        
        // 生成新的驗證碼
        Object[] captchaData = captchaService.generateCaptcha();
        BufferedImage captchaImage = (BufferedImage) captchaData[0];
        String captchaText = (String) captchaData[1];
        
        // 將驗證碼保存到 Session
        session.setAttribute(CAPTCHA_SESSION_KEY, captchaText);
        
        // 設置響應類型
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        // 輸出驗證碼圖片
        ImageIO.write(captchaImage, "png", response.getOutputStream());
    }

    /**
     * 處理用戶登出
     */
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        // 清除認證信息
        SecurityContextHolder.clearContext();
        
        // 使 session 失效
        session.invalidate();
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "登出成功");
        
        return ResponseEntity.ok(response);
    }
}