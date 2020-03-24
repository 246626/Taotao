/**
 * 
 */
package com.taotao.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

/**
 * @author 追梦人
 *图片上传服务
 */
@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_USERNAME}")
	private String username;
	@Value("${FTP_PASSWORD}")
	private String password;
	@Value("${FTP_ADDRESS}")
	private String host;
	@Value("${FTP_PORT}")
	private Integer port; 
	@Value("${FTP_BASE_PATH}")
	private String ftpBasePath;
	@Value("${IMAGE_BASE_URL}")
	private String image_base_url;

	@Override
	public Map uploadPicture(MultipartFile file)  {
		//获取原来的文件名
		String oldName = file.getOriginalFilename();
		//生产的新的唯一的文件名
		String newName=IDUtils.genImageName()+oldName.substring(oldName.lastIndexOf("."));
		//存储图片上传结果
		boolean result=false;
		//存储返回结果
		Map<String, Object > resultMap=new HashMap<String, Object>();
		//图片存储的路径
		String imagePath=new DateTime().toString("/yyyy/MM/dd");
		try {
			result = FtpUtil.uploadFile(host, port,username , password, 
					ftpBasePath, imagePath, newName, file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			resultMap.put("error", 1);
			resultMap.put("message", "sorry,Upload fail!");
			e.printStackTrace();
		}
		
		if(result) {
			resultMap.put("error", 0);
			resultMap.put("url", image_base_url+imagePath+"/"+newName);
		}else {
			resultMap.put("error", 1);
			resultMap.put("message", "sorry,Upload fail!");
		}
		return resultMap;
	}

}
