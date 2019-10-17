package com.crazyplay.highwan.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/ueditor")
public class UeditorController {
	
	@Value("${com.crazyplay.highwan.web.file_root_path}")
	public String fileRootPath;
	
	@Value("${com.crazyplay.highwan.web.file_project_path}")
	public String fileProjectPtath;
	
	@Value("${com.crazyplay.highwan.web.file_server}")
	private String imgServer;
	
	@RequestMapping(value="config")
	@ResponseBody
	public String getUeditorConfig(String action,MultipartFile upfile)throws IOException{
		if(StringUtils.isNotBlank(action) && action.equals("config")){
			InputStream is = this.getClass().getResourceAsStream("/ueditor.conf");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer sb = new StringBuffer();
			String s;
			while((s =br.readLine()) != null) {
				 sb.append(s);  
			}
			String str = sb.toString();
			str = str.replace("${imgServer}", imgServer);
			str = str.replace("${fileRootPath}", fileRootPath);
			str = str.replace("${fileProjectPtath}", fileProjectPtath);
			return str;
		}else if(StringUtils.isNotBlank(action) && upfile!=null) {
			String ex = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
			/* 获得文件前缀	*/
			String projectPath = fileProjectPtath+LocalDate.now().toString();
			String proPath = fileRootPath+projectPath;
			String newFileName = UUID.randomUUID().toString().replaceAll("-", "") + ex;
			File fp = new File(proPath);
			if (!fp.exists()) {
				fp.mkdirs();
			}
			String filepath = proPath + newFileName;
			File localFile = new File(filepath);
			try {
				upfile.transferTo(localFile);
				JSONObject state = new JSONObject();
				state.put("state", "SUCCESS");
				state.put("title", newFileName);
				state.put("url", projectPath+newFileName);
				state.put("original", newFileName);
				return  state.toJSONString();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
