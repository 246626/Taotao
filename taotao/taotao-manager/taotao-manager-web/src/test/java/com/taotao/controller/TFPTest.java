/**
 * 
 */
package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

/**
 * @author 追梦人 测试ftp服务
 */
public class TFPTest {

	@Test
	public void testFTP() throws SocketException, IOException {
		// 创建FTPClient对象
		FTPClient ftpClient = new FTPClient();
		// 创建ftp连接默认21端口
		ftpClient.connect("192.168.127.130", 21);
		// 登录
		ftpClient.login("ftpuser", "246626ftp");
		/**
		 * 上传文件 ftpClient.storeFile(remote, local) 第一个参数（remote）：上传到ftp服务器时的文件名
		 * 第二个参数（local）：要上传的文档的inputStream
		 */
		// 设置上传路径,若没有这个路径，则上传失败
		ftpClient.changeWorkingDirectory("/home/ftpuser/images");
		// 把要上传的文件输入到FileInputStream
		FileInputStream inputStream = new FileInputStream(new File("D:\\3.jpg"));
		// 这个方法是每次数据连接之前，ftp client告诉 ftp server开通一个端口来传输数据
		ftpClient.enterLocalPassiveMode();
		// 设置上传格式
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		boolean index = ftpClient.storeFile("211.jpg", inputStream);
		if (index == true) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		} // 关闭连接
		ftpClient.logout();
	}

	/**
	 * 使用工具类来实现图片上传 可以设置上传路径，没有则创建
	 * @throws FileNotFoundException
	 */
	@Test
	public void testFTPUtil() throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream(new File("D:\\3.jpg"));
		FtpUtil.uploadFile("192.168.127.130", 21, "ftpuser", "246626ftp", "/home/ftpuser", "/images", "hello112.jpg",
				inputStream);
	}

}