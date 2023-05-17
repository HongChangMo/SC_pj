package com.sc.sc_pj.service.common.controller;

import org.springframework.web.servlet.view.AbstractView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Map;

public class ListImageView extends AbstractView {
    public void DownloadFileView() {
        setContentType("applicaiton/download;charset=utf-8");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileFullPath = (String) model.get("fileFullPath");
        File file = new File(fileFullPath);

        // 응답의 타입이 이미지임을 알려줌
        response.setContentType(getContentType());

        double width = 80;
        double height = 30;

        double imageWidth = 0;
        double imageHeight = 0;
        BufferedImage image1 = null;

        String ext = fileFullPath.substring(fileFullPath.lastIndexOf(".") + 1).toUpperCase();

        if (ext.equals("GIF") ||  ext.equals("PNG")||  ext.equals("BMP")){
            BufferedImage bimg = ImageIO.read(new File(fileFullPath));
            imageWidth = bimg.getWidth();
            imageHeight = bimg.getHeight();
        }else{
            image1 = ImageIO.read(file);
            imageWidth = image1.getWidth();
            imageHeight = image1.getHeight();
        }

        // 최대 가로 사이즈
        double maxWidth = 80d;
        //width가 최대 가로사이즈를 넘으면 사이즈 제한
        if (imageWidth > maxWidth) {
            imageHeight = maxWidth * imageHeight / imageWidth;
            imageWidth = maxWidth;
        }

        //대상 이미지 사이즈 조회
        double calcWidth = imageHeight * width / height;
        double calcHeight = imageWidth * height / width;
        double marginWidth = 0;
        double marginHeight = 0;
        if (calcWidth < imageWidth) {
            calcWidth = imageWidth;
        } else if (calcWidth > imageWidth) {
            marginWidth = (calcWidth - imageWidth) / 2;
        }
        if (calcHeight < imageHeight) {
            calcHeight = imageHeight;
        } else if (calcHeight > imageHeight) {
            marginHeight = (calcHeight - imageHeight) / 2;
        }

        BufferedImage mergedImage = new BufferedImage(Double.valueOf(calcWidth).intValue(), Double.valueOf(calcHeight).intValue(), BufferedImage.TYPE_INT_ARGB);

        //대상 이미지 그리기
        Graphics2D graphics = (Graphics2D) mergedImage.getGraphics();
        //graphics.fillRect(0, 0, Double.valueOf(calcWidth).intValue(), Double.valueOf(calcHeight).intValue());

        //graphics.setComposite(AlphaComposite.Clear);
        //graphics.fillRect(0, 0, 200, 200);
        graphics.drawImage(image1, Double.valueOf(marginWidth).intValue(), Double.valueOf(marginHeight).intValue(), Double.valueOf(imageWidth).intValue(), Double.valueOf(imageHeight).intValue(), null);

        OutputStream output = response.getOutputStream();
        ImageIO.write(mergedImage, "png", output);
        output.flush();

    }
}
