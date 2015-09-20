package com.best.btr.wanma.system;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.jinhe.tss.framework.web.servlet.AfterUpload;
import com.jinhe.tss.util.FileHelper;

/**
 * 上传员工身份证、头像等
 */
public class GetEmployeePhoto implements AfterUpload {

	Logger log = Logger.getLogger(this.getClass());

	public String processUploadFile(HttpServletRequest request,
			String filepath, String oldfileName) throws Exception {

		String contextPath = request.getParameter("contextPath");
		File baseDir = null;
		if (contextPath != null) {
			baseDir = new File(contextPath);
		}

		File targetFile = new File(filepath);
		if (baseDir != null && targetFile != null) {
			FileHelper.copyFile(baseDir, targetFile);
		}

		return " parent.alert('上传成功!'); ";
	}
}
