/**
 * 
 */
package com.taotao.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**
 * @author 追梦人
 *图片上传处理
 */
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureServiceImpl;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map resultMap = pictureServiceImpl.uploadPicture(uploadFile);
		//为了提高兼容性需要把resultMap转换成json字符串
		String json = JsonUtils.objectToJson(resultMap);
		return json;
	}
}
