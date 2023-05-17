package com.sc.sc_pj.service.register.service;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.MultiStepRescaleOp;
import com.sc.sc_pj.service.register.domain.RegisterDomain;
import com.sc.sc_pj.service.register.domain.RegisterFileDomain;
import com.sc.sc_pj.service.register.dto.RegisterDTO;
import com.sc.sc_pj.service.register.dto.RegisterFileDTO;
import com.sc.sc_pj.service.register.repository.RegisterFileRepository;
import com.sc.sc_pj.service.register.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterService {

    @Value("${custom.path.upload-path}")
    private String uploadPath;
    private final RegisterRepository registerRepository;
    @Autowired
    private RegisterFileRepository registerFileRepository;

    /*
    * 회원가입
    * @param RegisterDTO
    * @return
    */
    public RegisterDTO addRegister(RegisterDTO dto) {
        RegisterDomain result = registerRepository.save(dto.toEntity());

        return result.toDTO();
    }

    public int getRegisterCount(String userId) {
        Long userCount = registerRepository.CountByUserId(userId);
        System.out.println("userCount : "+userCount);
        return userCount.intValue();
    }

    public RegisterDTO getRegister(Long userNo) {
        return registerRepository.findByUserNo(userNo).toDTO();
    }

    public int updateRegister(RegisterDTO dto) {
        return registerRepository.registerUpdate(dto.getUserNo(), dto.getUserPwd(), dto.getUserNickName(), dto.getUserPhone());
    }

    public RegisterFileDTO getRegisterFile(long userNo) {
        return registerFileRepository.findByUserNo(userNo).toDTO();
    }

    public void fileUpload( long userNo, MultipartFile file ) throws Exception {
        String fileUploadPath = uploadPath + "profile/" + userNo + "/";

        File dir = new File(fileUploadPath);

        // 폴더 없으면 생성
        if( !dir.exists() ) {
            dir.mkdirs();
        }

        RegisterFileDomain domain = new RegisterFileDomain();
        String thumbnailDir = dir.toString() + "/" + "thumbnail";

        try{
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + fileExt;

            RegisterFileDTO fileDto = new RegisterFileDTO();
            // set File DTO
            fileDto.setUserNo(userNo);
            fileDto.setFileSavePath(fileUploadPath + newFileName);
            fileDto.setFileOriginNm(file.getOriginalFilename());
            fileDto.setFileSaveNm(newFileName);
            fileDto.setFileExt(fileExt);
            fileDto.setFileSize(file.getSize());

            // 실제 경로에 파일 저장
            File uploadFile = new File(fileDto.getFileSavePath());
            file.transferTo(uploadFile);

            String thumbPath = thumbnailDir;

            // 썸네일 생성
            String thumbFullPath = createThumbNail( fileDto.getFileSavePath(), thumbPath, newFileName, 300 );
            System.out.println("thumbFullPath : " + thumbFullPath);
            if( thumbFullPath != null ) {
                fileDto.setFileThumbPath(thumbFullPath);
                fileDto.setFileThumbNm(newFileName);
                fileDto.setFileThumbExt( thumbFullPath.substring(thumbFullPath.indexOf(".") + 1).toLowerCase() );
            }

            registerFileRepository.save( fileDto.toEntity() );

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    // 썸네일 변환
    public String createThumbNail(String fileSavePath, String thumbFilePath, String newFileName, int width) throws Exception {
        log.info("########## create thumbnail ##########");
        String fullPath = (thumbFilePath + "/" + newFileName).replace("\\", "/");
        String thumbExt = fileSavePath.substring(fileSavePath.lastIndexOf(".") + 1).toLowerCase();
        String ext = "jpg";

        if("png".equals(thumbExt)) ext = thumbExt;
        fullPath = fullPath.substring(0, fullPath.lastIndexOf(".")) + "." + ext;

        System.out.println("thumbPath : " + fullPath);

        //thumbnail 폴더가 없어서 에러
        File save = new File(thumbFilePath);
        // 폴더 생성
        if (!save.exists()){
            save.mkdirs();
        }

        File file = new File(fileSavePath);

        try{
            System.out.println("thumbFile read");
            BufferedImage bufferedImage = ImageIO.read(file);

            int[] thumbWH = imgWidthHeight(bufferedImage.getWidth(), bufferedImage.getHeight(), width);

            int thumbWidth = thumbWH[0];
            int thumbHeight = thumbWH[1];

            MultiStepRescaleOp rescale = new MultiStepRescaleOp(thumbWidth, thumbHeight);
            rescale.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
            BufferedImage thumbImage = rescale.filter(bufferedImage, null);
            ImageIO.write(thumbImage, ext, new FileOutputStream(new File(fullPath)));
            bufferedImage.flush();
            thumbImage.flush();

        } catch (Exception e) {
            log.info(e.getMessage());
            fullPath = null;
        }

        return fullPath;
    }

    public static int[] imgWidthHeight(int width, int height, int thumbSize) throws Exception{

        //Return Array
        int[] imgWH = new int[2];

        //ThumbNail Width, Height
        int thumbWidth = width;
        int thumbHieght = height;

        // 너비가 더 클경우
        if(width >= height){
            //너비가 주어진 사이즈보다 클 경우
            if(width > thumbSize){
                thumbWidth = thumbSize;
                thumbHieght = height * thumbSize / width;
            }
            // 높이가 더 클경우
        }else{
            //높이가 주어진 사이즈보다 클 경우
            if(height > thumbSize){
                thumbHieght = thumbSize;
                thumbWidth = width * thumbSize / height;
            }
        }

        imgWH[0] = thumbWidth;
        imgWH[1] = thumbHieght;

        return imgWH;
    }
}
