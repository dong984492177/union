package com.dong.util;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;


public class PicUploadUtil {
	/**
	 * 图片上传
	 */
	public static String getNewPicName( MultipartFile picFile){
		String newPicName = null;
		if(picFile!=null){
			String oldPicName = picFile.getOriginalFilename();
			if(!"".equals(oldPicName) && oldPicName!=null){
				//System.out.println("old:"+oldPicName);
				String uuidStr = UUID.randomUUID().toString();
				//System.out.println(uuidStr);
				String sufPicType = oldPicName.substring(oldPicName.lastIndexOf("."));
				//System.out.println(".最后个字符之后文件类型:"+sufPicType));
				newPicName =uuidStr+sufPicType;
				//System.out.println("new:"+newPicName);
			   
				//图上传到服务器路径地址
				File dirImg = new File(FileContext.PICURL);
				//判定如果不存在，则创建
				if(!dirImg.exists()){
					dirImg.mkdirs();//创建文件夹
				}
				//组装路径地址+新图片名称
				File newDirPic = new File(dirImg+"\\"+newPicName);
				
				//图片真正上传到Context.PICURL
				try {
					//存储
					picFile.transferTo(newDirPic);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return newPicName;
	}

}
