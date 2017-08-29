package com.antiphon.xiaomai.common.utils;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile; 
 








public class UploadUtils {
	

	private static final int BUFFER_SIZE = 1024 * 1024;

	public static void copy(MultipartFile src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			 
			try {
				in = new BufferedInputStream(src.getInputStream(),
						(int)src.getSize());
				out = new BufferedOutputStream(new FileOutputStream(dst),
						(int)src.getSize());
				byte[] buffer = new byte[(int)src.getSize()];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static String  saveFile(MultipartFile filename,String path ,String name,HttpServletRequest request) throws Exception {
		
		  String pathdir = path;
		
		  
		File filepage =new File( pathDir(request,pathdir), name);
	
		 UploadUtils.copy(filename,filepage );
		
		return pathdir+"/"+name;
	
	
	}
	/**
	 * 不压缩
	 * @param filename Spring mvc 的文件名
	 * @param path    路径  
	 * @param imagename 新生成的图片名字
	 * @param width  图片宽，如果等于O，表示不压缩
	 * @param ext    图片类型
	 * @param request
	 * @throws Exception
	 */
	
 
	public static void saveImageFile(MultipartFile filename,String path ,String imagename,String ext,HttpServletRequest request) throws Exception {
		
		  String pathdir = path;
		
		File filepage =new File( pathDir(request,pathdir), imagename); 
	 
		 UploadUtils.copy(filename,filepage );
		
	
		
	
	
	}
	
	
 
	

	 
	
	
	/**
	 * 压缩成等比
	 * @param filename Spring mvc 的文件名
	 * @param path    路径  
	 * @param imagename 新生成的图片名字
	 * @param width  图片宽，如果等于O，表示不压缩
	 * @param ext    图片类型
	 * @param request
	 * @throws Exception
	 */
	
	
	
	public static void saveImageFile(MultipartFile filename,String path ,String imagename,String ext,int size,Boolean flag,HttpServletRequest request) throws Exception {
		
		  String pathdir = path;
		
		Image srcFile = ImageIO.read(filename.getInputStream());
		File filepage =new File( pathDir(request,pathdir), imagename); 
		String pathdirWidth=pathdir+"/"+size+"x";
	 
		 UploadUtils.copy(filename,filepage );
		 
				if(srcFile.getWidth(null)>=size||srcFile.getHeight(null)>=size){
					 
					 saveTypeImage(filepage,pathdirWidth,imagename,size,ext,request,true);
					 
				}else {
					
					 
					 File file=new File( pathDir(request,pathdirWidth), imagename);
					 UploadUtils.copy(filename,file );
					
				}  
		 
	
		
	
	
	}
	/**
	 * 根据指定的大小压缩 ，压缩宽
	 * @param filename Spring mvc 的文件名
	 * @param path    路径  
	 * @param imagename 新生成的图片名字
	 * @param size   
	 * @param ext    图片类型
	 * @param request
	 * @throws Exception
	 */
	public static void saveImageFile(MultipartFile filename,String path ,String imagename,String ext,int size,HttpServletRequest request) throws Exception {
		
		  String pathdir = path;
		
		Image srcFile = ImageIO.read(filename.getInputStream());
		File filepage =new File( pathDir(request,pathdir), imagename); 
		String pathdirWidth=pathdir+"/"+size+"x";
	 
		 UploadUtils.copy(filename,filepage );
		 
				if(srcFile.getWidth(null)>=size){
					 
					 saveTypeImage(filepage,pathdirWidth,imagename,size,ext,request,false);
					 
				}else {
					
					 
					 File file=new File( pathDir(request,pathdirWidth), imagename);
					 UploadUtils.copy(filename,file );
					
				}  
		 
	
		
	
	
	}
	
	public static Integer[] saveImageFileToWH(MultipartFile filename,String path ,String imagename,String ext,int size,HttpServletRequest request) throws Exception {
		
		  String pathdir = path;
		  Integer[] wh = new Integer[2];
		  
		Image srcFile = ImageIO.read(filename.getInputStream());
		wh[0]= srcFile.getWidth(null);
		wh[1]= srcFile.getHeight(null);
		File filepage =new File( pathDir(request,pathdir), imagename); 
		String pathdirWidth=pathdir+"/"+size+"x";
	 
		 UploadUtils.copy(filename,filepage );
		 
				if(srcFile.getWidth(null)>=size){
					 
					 saveTypeImage(filepage,pathdirWidth,imagename,size,ext,request,false);
					 
				}else {
					
					 
					 File file=new File( pathDir(request,pathdirWidth), imagename);
					 UploadUtils.copy(filename,file );
					
				}  
		 
	
		
	   return wh;
	
	}
   private  static String pathDir(HttpServletRequest request,String pathdir){
	 //  String realpathdir="D:/server/nginx/webapps"+pathdir;
	   
	 	String realpathdir = request.getSession().getServletContext()
				.getRealPath(pathdir);
		File savedir = new File(realpathdir);
		if (!savedir.exists())
			savedir.mkdirs();
	   return realpathdir;
   }
    

   
   
     private  static void saveTypeImage(File filepage,String pathdir_resize,String imagename,int width,String ext,HttpServletRequest request,Boolean flag){
    	
    	 //String realpathdir_resize="D:/server/nginx/webapps"+pathdir_resize;
 		
 	String realpathdir_resize =request.getSession().getServletContext()
 		.getRealPath(pathdir_resize);
 		File savedir_resize = new File(realpathdir_resize);
 		if (!savedir_resize.exists())
 			savedir_resize.mkdirs();		
 		 
 			 
 		    	 //ImageSizer.resize(filepage, new File(savedir_resize, imagename), width, ext,flag);
 		       
 	 
     }
     
     /**
      * 
      * @param file 文件
      * @param request
      * @param oldPhoto 旧路径
      * @throws Exception
      */
     public static String  saveFile(MultipartFile file,HttpServletRequest request,String zpath,String oldPhoto) throws Exception {
    	String eturnPath="";
    	 if (file!=null&&file.getSize()>0) {// 判断上传的文件是否为空
    		 // 项目在容器中实际发布运行的根路径
    		 String  realPath=request.getSession().getServletContext().getRealPath("/");
             
    		 deletefile(oldPhoto,realPath);//删除旧照片
    		 
              String type=null;// 文件类型
              String path=null;// 文件路径
              String fileName=file.getOriginalFilename();// 文件原名称
              System.out.println("上传的文件原名称:"+fileName);
              // 判断文件类型
              type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
              if (type!=null) {// 判断文件类型是否为空
                  if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())) {
                      // 自定义的文件名称
                      String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
                      // 设置存放图片文件的路径
                      path=realPath+zpath+trueFileName;
                     File temp= new File(realPath);
                      if (!temp.exists()){
                    	  temp.mkdirs();
                      }
                      System.out.println("存放图片文件的路径:"+path);
                    File filePath=new File(path);
                    if (!filePath.exists()){
                    	filePath.mkdirs();
                    }
                      // 转存文件到指定的路径
                      file.transferTo(filePath);
                      eturnPath=zpath+trueFileName;
                      System.out.println(eturnPath);
                      System.out.println("文件成功上传到指定目录下");
                  }else {
                      System.out.println("不是我们想要的文件类型,请按要求重新上传");
                  }
              }else {
                  System.out.println("文件类型为空");
              }
          }
    	 return eturnPath;
	
	}
     
     
     /**
     * 删除单个文件
     * @param filename 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
     public static boolean deletefile(String filename,String realPath) {
    	 if(StringUtils.isNotEmpty(filename)){
    		 File file = new File(realPath+filename);
    		 // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
    		 if(file.exists() && file.isFile()) {
    			 if(file.delete()) {
    				 System.out.println("删除单个文件" + filename + "成功！");
    				 return true;
    			 } else {
    				 System.out.println("删除单个文件" + filename + "失败！");
    				 return false;
    			 }
    		 } else {
    			 System.out.println("删除单个文件失败：" + filename + "不存在！");
    			 return false;
    		 }
    	 }else{
    		 return false;
    	 }
     }
     
     

     /**
     * 删除一对多文件imgs表时使用
     * @param filename 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
     public static boolean deletefile(String module,Long id,String filename) {
    	 if(StringUtils.isNotEmpty(filename)){
    		 File file = new File("E:\\tomcat7\\webapps"+"\\xiaomai-web\\"+"\\images\\"+module+"\\"+id+"\\"+filename);
    		 // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
    		 if(file.exists() && file.isFile()) {
    			 if(file.delete()) {
    				 System.out.println("删除单个文件" + filename + "成功！");
    				 return true;
    			 } else {
    				 System.out.println("删除单个文件" + filename + "失败！");
    				 return false;
    			 }
    		 } else {
    			 System.out.println("删除单个文件失败：" + filename + "不存在！");
    			 return false;
    		 }
    	 }else{
    		 return false;
    	 }
     }
     
    
    

     
     
     
}
