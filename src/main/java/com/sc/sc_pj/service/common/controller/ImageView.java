package com.sc.sc_pj.service.common.controller;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ImageView extends AbstractView {

    public void DownloadFileView() {
        setContentType("applicaiton/download;charset=utf-8");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{
            String fileFullPath = (String) model.get("fileFullPath");
            if(fileFullPath != null){
                File file = new File(fileFullPath);

                String type = Files.probeContentType(Paths.get(fileFullPath));

                // 응답의 타입이 이미지임을 알려줍니다.
                response.setContentType(type);

                // 응답 메시지에 파일의 길이를 넘겨줍니다.
                response.setContentLength((int) file.length());

                // 파일로부터 byte를 읽어옵니다.
                byte[] bytes = readFile(fileFullPath);
                write(response, bytes);
            }
        }catch(FileNotFoundException fnfe){
            //fnfe.printStackTrace();
        }
    }

    /**
     * 파일로부터 byte 배열 읽어오기
     */
    private byte[] readFile(String fileFullPath) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileFullPath));
        int length = bis.available();
        byte[] bytes = new byte[length];
        bis.read(bytes);
        bis.close();

        return bytes;
    }

    /**
     * 응답 OutputStream에 파일 내용 쓰기
     */
    private void write(HttpServletResponse res, byte[] bytes) throws IOException {
        BufferedOutputStream output = new BufferedOutputStream(res.getOutputStream());
        output.write(bytes);
        output.flush();
    }
}