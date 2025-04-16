package itri.org.spring.service;

import java.awt.image.BufferedImage;

public interface CaptchaService {
    /**
     * 生成驗證碼圖片
     * @return 包含驗證碼圖片和驗證碼文本的數組
     */
    Object[] generateCaptcha();
    
    /**
     * 驗證用戶輸入的驗證碼
     * @param userInput 用戶輸入的驗證碼
     * @param storedCaptcha 存儲的驗證碼
     * @return 驗證結果
     */
    boolean validateCaptcha(String userInput, String storedCaptcha);
}