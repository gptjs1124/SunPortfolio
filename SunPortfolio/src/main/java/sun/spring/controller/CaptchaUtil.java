package sun.spring.controller;

import nl.captcha.Captcha;
import nl.captcha.audio.AudioCaptcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.NumbersAnswerProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class CaptchaUtil {
    private static int width = 150;	/*보안문자 이미지 가로크기*/
    private static int height = 50; /*보안문자 이미지 세로크기*/

    /*CaptCha Image 생성*/
    public void getImgCaptCha(HttpServletRequest req, HttpServletResponse res) {

        Captcha captcha = new Captcha.Builder(width,  height)
                // .addText() 또는 아래와 같이 정의 : 6자리 숫자와 폰트 및 컬러 설정
                .addText(new NumbersAnswerProducer(6))
                .addNoise().addBorder()
                .addBackground(new GradiatedBackgroundProducer())
                .build();

        /*JSP에서 Captcha 객체에 접근할 수 있도록 session에 저장*/
        req.getSession().setAttribute(Captcha.NAME, captcha);
        CaptchaServletUtil.writeImage(res,  captcha.getImage());
    }

    /*CaptCha Audio 생성*/
    public void getAudioCaptCha(HttpServletRequest req, HttpServletResponse res, String answer) throws IOException {
        HttpSession session = req.getSession();

        Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
        String getAnswer = answer;

        if(getAnswer == null || getAnswer.equals("")) getAnswer = captcha.getAnswer();

        AudioCaptcha audiocaptcha = new AudioCaptcha.Builder()
                .addAnswer(new SetTextProducer(getAnswer))
                .addNoise()	/*잡음 추가*/
                .build();

        CaptchaServletUtil.writeAudio(res,  audiocaptcha.getChallenge());
    }
}
