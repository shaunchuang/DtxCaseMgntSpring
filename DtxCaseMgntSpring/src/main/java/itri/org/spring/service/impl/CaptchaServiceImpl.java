package itri.org.spring.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.springframework.stereotype.Service;

import itri.org.spring.service.CaptchaService;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int CODE_LENGTH = 4;
    private static final String CHARS = "0123456789";
    private static final Random RANDOM = new Random();

    @Override
    public Object[] generateCaptcha() {
        // 創建一個空白的圖片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 設置背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 繪製干擾線
        drawInterferenceLines(g);

        // 生成隨機驗證碼
        String code = generateRandomCode();

        // 繪製驗證碼
        drawCode(g, code);

        // 釋放資源
        g.dispose();

        // 返回圖片和驗證碼
        return new Object[]{image, code};
    }

    @Override
    public boolean validateCaptcha(String userInput, String storedCaptcha) {
        return userInput != null && storedCaptcha != null && 
               userInput.trim().equalsIgnoreCase(storedCaptcha.trim());
    }

    private String generateRandomCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARS.length());
            sb.append(CHARS.charAt(index));
        }
        return sb.toString();
    }

    private void drawInterferenceLines(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 10; i++) {
            int x1 = RANDOM.nextInt(WIDTH);
            int y1 = RANDOM.nextInt(HEIGHT);
            int x2 = RANDOM.nextInt(WIDTH);
            int y2 = RANDOM.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    private void drawCode(Graphics2D g, String code) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        // 計算字符間距
        int x = 10;
        for (int i = 0; i < code.length(); i++) {
            // 隨機傾斜角度
            int angle = RANDOM.nextInt(30) - 15;
            // 保存當前的轉換
            g.rotate(Math.toRadians(angle), x, HEIGHT / 2);
            g.drawString(String.valueOf(code.charAt(i)), x, HEIGHT / 2 + 8);
            // 恢復轉換
            g.rotate(Math.toRadians(-angle), x, HEIGHT / 2);
            // 移動到下一個字符的位置
            x += 20 + RANDOM.nextInt(10);
        }
    }
}