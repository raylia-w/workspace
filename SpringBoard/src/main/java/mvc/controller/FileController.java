package mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import mvc.dao.FileDao;
import mvc.dto.UploadFile;

@Controller
public class FileController {
	
	@Autowired ServletContext context;
	@Autowired FileDao fileDao;
	
	@RequestMapping(value="/file/fileForm.do", method=RequestMethod.GET)
	public void fileForm() {
		
	}
	
	@RequestMapping(value="/file/fileup.do", method=RequestMethod.POST)
	public String fileUpLoad(MultipartFile file) {
//		File dest = new File("경로+파일");
//		File dest = new File("경로", "파일");
		
		String uID = UUID.randomUUID().toString().split("-")[0];
		//파일이 저장될 경로
		String realpath = context.getRealPath("upload");
		//파일이 저장될 이름
		String stored = file.getOriginalFilename()+"-"+uID;
		System.out.println(realpath);
		File dest = new File(realpath, stored);
		
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UploadFile uploadFile = new UploadFile();
		uploadFile.setOriginal_filename(file.getOriginalFilename());
		uploadFile.setStored_filename(stored);
		uploadFile.setFile_size(file.getSize());
		
		fileDao.insert(uploadFile);
		
		return null;
	}
}
