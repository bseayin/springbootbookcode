package com.xsz.util;
import java.io.*;

import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Encoder;

public class ImageUtils {
	
//	String  fileDirectory="C:\\Users\\jiyu\\Documents\\home_company_desc";
	
	
//	static File file = new File("/data/docker/docker-volumns/tomcat/userfiles");
	static File file = new File("C:\\bsea\\bsea2019\\project\\zhdj\\tmp");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sizeEnhancement(file);
	}
	public static File singleFileEnhancement(File f) {
		String thumbnailPathName = "";
		File thumbnailFile = null;
		if(f.isFile()) {
           long size = f.length();
           System.out.println("size--2---->"+(size/1024));
           double scale = 1.0d ;
           if(size >= 400*1024){
               if(size > 0){
                   scale = (400*1024f) / size  ;
               }
           }
           
           System.out.println("scale--->"+scale);
           
         thumbnailPathName = f.getPath();
         if(thumbnailPathName.contains(".png")){
           thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
         }
         System.out.println("thumbnailPathName--->"+thumbnailPathName);
           
//           if(size>0){
        	   if(size < 200*1024){
               try {
					Thumbnails.of(f.getPath()).scale(1f).outputFormat("jpg").toFile(thumbnailPathName);
					thumbnailFile = new File(thumbnailPathName);
               } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           }else{
               try {
					Thumbnails.of(f.getPath()).scale(1f).outputQuality(scale).outputFormat("jpg").toFile(thumbnailPathName);
					thumbnailFile = new File(thumbnailPathName);
               } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           }
		}
		return thumbnailFile;
	}
	public static void sizeEnhancement(File path) {
		
        File[] tempList = path.listFiles();
        for(File f:tempList) {
        	if(f.isFile()) {
        		 //????????????????????????
                System.out.println("path--->"+f.getPath());
                System.out.println("getName--->"+f.getName());
                System.out.println("getParent---->"+f.getParent());
//                if(f.getPath().contains(".png")){
//                    thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
//                }
                long size = f.length();
                System.out.println("size--->"+size);
//                System.out.println("length--->"+f.length());
                System.out.println("size--2---->"+(size/1024));
                double scale = 1.0d ;
                if(size >= 400*1024){
                    if(size > 0){
                        scale = (400*1024f) / size  ;
                    }
                }
                
                System.out.println("scale--->"+scale);
                
                //????????????????????????
                
               
                	
//              String thumbnailPathName = f.getParent()+File.separator+"small"+f.getName();
              String thumbnailPathName = f.getPath();
              if(thumbnailPathName.contains(".png")){
                thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
              }
              System.out.println("thumbnailPathName--->"+thumbnailPathName);
//              //added by yangkang 2016-3-30 ????????????????????????.png????????? 
//              if(thumbnailPathName.contains(".png")){
//                  thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
//              }
                
                if(size < 160*1024){
//                    try {
//						Thumbnails.of(f.getPath()).scale(1f).outputFormat("jpg").toFile(thumbnailPathName);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
                }else{
                    try {
						Thumbnails.of(f.getPath()).scale(1f).outputQuality(scale).outputFormat("jpg").toFile(thumbnailPathName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                
                
                
                
        	}else if(f.isDirectory()) {
        		sizeEnhancement(f);
        	}
        }



	}
    //???????????????base64???

    public static  String getImageBase(String src) {
        if(src==null||src==""){
            return "";
        }
        File file = new File(src);
        if(!file.exists()) {
            return "";
        }
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
//	/**
//     * 
//     * @Description:?????????????????????????????????
//     * @param imageFile ????????????
//     * @param request ????????????
//     * @param uploadPath ????????????
//     * @return
//     */
//    public static BaseResult uploadFileAndCreateThumbnail() {
//    	String  fileDirectory="C:\\Users\\jiyu\\Documents\\home_company_desc";
//
//
//    	File file = new File(fileDirectory);
//        File[] tempList = file.listFiles();
//        for(File f:tempList) {
//        	if(f.isFile()) {
//        		 //????????????????????????
//                System.out.println("path--->"+f.getPath());
//                System.out.println("getName--->"+f.getName());
////                if(f.getPath().contains(".png")){
////                    thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
////                }
//                long size = f.getTotalSpace();
//                System.out.println("size--->"+size);
//                double scale = 1.0d ;
//                if(size >= 200*1024){
//                    if(size > 0){
//                        scale = (200*1024f) / size  ;
//                    }
//                }
//        	}else if(f.isDirectory()) {
//
//        	}
//        }
//
//        //????????????????????????
//        String pathName = fileDirectory + File.separator + uuid + "."
//                            + FilenameUtils.getExtension(imageFile.getOriginalFilename());
//        //????????????????????????
//        //2016-5-6 yangkang ?????????????????????????????????
//        String realPath = request.getServletContext().getRealPath("uploadPath");
//        //??????????????????????????? linux ???????????????  ???????????????????????????????????????
//        //String urlString=PropertiesUtil.getInstance().getSysPro("uploadPath");
//        //??????????????????
//        String filePathName = realPath + File.separator + pathName;
//        log.info("?????????????????????"+filePathName);
//        //??????????????????????????????
//        File file = new File(filePathName);
//        if (file.getParentFile() != null || !file.getParentFile().isDirectory()) {
//            //????????????
//            file.getParentFile().mkdirs();
//        }
//
//        InputStream inputStream = null;
//        FileOutputStream fileOutputStream = null;
//        try {
//            inputStream = imageFile.getInputStream();
//            fileOutputStream = new FileOutputStream(file);
//            //????????????
//            //2016-05-12 yangkang ??????????????????
////            IOUtils.copy(inputStream, fileOutputStream);
//            byte[] buffer = new byte[2048];
//            IOUtils.copyLarge(inputStream, fileOutputStream, buffer);
//            buffer = null;
//
//        } catch (IOException e) {
//            filePathName = null;
//            return new BaseResult(false, "????????????", e.getMessage());
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.flush();
//                    fileOutputStream.close();
//                }
//            } catch (IOException e) {
//                filePathName = null;
//                return new BaseResult(false, "????????????", e.getMessage());
//            }
//         }
//
//
//        //        String fileId = FastDFSClient.uploadFile(file, filePathName);
//
//        /**
//         * ?????????begin
//         */
//
//        //????????????????????????
//        String thumbnailPathName = fileDirectory + File.separator + uuid + "small."
//                                    + FilenameUtils.getExtension(imageFile.getOriginalFilename());
//        //added by yangkang 2016-3-30 ????????????????????????.png?????????
//        if(thumbnailPathName.contains(".png")){
//            thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
//        }
//        long size = imageFile.getSize();
//        double scale = 1.0d ;
//        if(size >= 200*1024){
//            if(size > 0){
//                scale = (200*1024f) / size  ;
//            }
//        }
//
//
//        //??????????????????
//        String thumbnailFilePathName = realPath + File.separator + thumbnailPathName;
//        try {
//            //added by chenshun 2016-3-22 ?????????????????????????????????????????????
////            Thumbnails.of(filePathName).size(width, height).toFile(thumbnailFilePathName);
//            if(size < 200*1024){
//                Thumbnails.of(filePathName).scale(1f).outputFormat("jpg").toFile(thumbnailFilePathName);
//            }else{
//                Thumbnails.of(filePathName).scale(1f).outputQuality(scale).outputFormat("jpg").toFile(thumbnailFilePathName);
//            }
//
//        } catch (Exception e1) {
//            return new BaseResult(false, "????????????", e1.getMessage());
//        }
//        /**
//         * ?????????end
//         */
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        //????????????
//        map.put("originalUrl", pathName);
//        //???????????????
//        map.put("thumbnailUrl", thumbnailPathName);
//        return new BaseResult(true, "????????????", map);
//    }
	
	
	
	
	
//	/**
//     * 
//     * @Description:?????????????????????????????????
//     * @param imageFile ????????????
//     * @param request ????????????
//     * @param uploadPath ????????????
//     * @return
//     */
//    public static BaseResult uploadFileAndCreateThumbnail(MultipartFile imageFile,HttpServletRequest request,String uploadPath) {
//        if(imageFile == null ){
//            return new BaseResult(false, "imageFile????????????");
//        }
//        
//        if (imageFile.getSize() >= 10*1024*1024)
//        {
//            return new BaseResult(false, "??????????????????10M");
//        }
//        String uuid = UUID.randomUUID().toString();
//        
//        String fileDirectory = CommonDateUtils.date2string(new Date(), CommonDateUtils.YYYY_MM_DD);
//        
//        //????????????????????????
//        String pathName = fileDirectory + File.separator + uuid + "."
//                            + FilenameUtils.getExtension(imageFile.getOriginalFilename());
//        //????????????????????????
//        //2016-5-6 yangkang ????????????????????????????????? 
//        String realPath = request.getServletContext().getRealPath("uploadPath");
//        //??????????????????????????? linux ???????????????  ???????????????????????????????????????
//        //String urlString=PropertiesUtil.getInstance().getSysPro("uploadPath");
//        //??????????????????
//        String filePathName = realPath + File.separator + pathName;
//        log.info("?????????????????????"+filePathName);
//        //??????????????????????????????
//        File file = new File(filePathName);
//        if (file.getParentFile() != null || !file.getParentFile().isDirectory()) {
//            //????????????
//            file.getParentFile().mkdirs();
//        }
//        
//        InputStream inputStream = null;
//        FileOutputStream fileOutputStream = null;
//        try {
//            inputStream = imageFile.getInputStream();
//            fileOutputStream = new FileOutputStream(file);
//            //????????????
//            //2016-05-12 yangkang ??????????????????
////            IOUtils.copy(inputStream, fileOutputStream);
//            byte[] buffer = new byte[2048];
//            IOUtils.copyLarge(inputStream, fileOutputStream, buffer);
//            buffer = null;
//
//        } catch (IOException e) {
//            filePathName = null;
//            return new BaseResult(false, "????????????", e.getMessage());
//        } finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
//                if (fileOutputStream != null) {
//                    fileOutputStream.flush();
//                    fileOutputStream.close();
//                }
//            } catch (IOException e) {
//                filePathName = null;
//                return new BaseResult(false, "????????????", e.getMessage());
//            } 
//         }
//    
//        
//        //        String fileId = FastDFSClient.uploadFile(file, filePathName);
//        
//        /**
//         * ?????????begin
//         */
//        
//        //????????????????????????
//        String thumbnailPathName = fileDirectory + File.separator + uuid + "small."
//                                    + FilenameUtils.getExtension(imageFile.getOriginalFilename());
//        //added by yangkang 2016-3-30 ????????????????????????.png????????? 
//        if(thumbnailPathName.contains(".png")){
//            thumbnailPathName = thumbnailPathName.replace(".png", ".jpg");
//        }
//        long size = imageFile.getSize();
//        double scale = 1.0d ;
//        if(size >= 200*1024){
//            if(size > 0){
//                scale = (200*1024f) / size  ;
//            }
//        }
//        
//        
//        //??????????????????
//        String thumbnailFilePathName = realPath + File.separator + thumbnailPathName;
//        try {
//            //added by chenshun 2016-3-22 ?????????????????????????????????????????????
////            Thumbnails.of(filePathName).size(width, height).toFile(thumbnailFilePathName);
//            if(size < 200*1024){
//                Thumbnails.of(filePathName).scale(1f).outputFormat("jpg").toFile(thumbnailFilePathName);
//            }else{
//                Thumbnails.of(filePathName).scale(1f).outputQuality(scale).outputFormat("jpg").toFile(thumbnailFilePathName);
//            }
//            
//        } catch (Exception e1) {
//            return new BaseResult(false, "????????????", e1.getMessage());
//        }
//        /**
//         * ?????????end
//         */
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        //????????????
//        map.put("originalUrl", pathName);
//        //???????????????
//        map.put("thumbnailUrl", thumbnailPathName);
//        return new BaseResult(true, "????????????", map);
//    }

}
