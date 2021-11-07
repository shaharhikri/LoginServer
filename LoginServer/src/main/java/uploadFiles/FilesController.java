package uploadFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import errors.FileDidntUploadException;

@Controller
public class FilesController {
	private final String UPLOAD_DIRECTORY = ".\\UsersUpload\\";
	
	@Autowired
	private FileService fileService;
	
	
	@PostMapping("/uploadFile")
	public String uploadFile(@CurrentSecurityContext(expression = "authentication?.name") String username,@RequestParam("file") MultipartFile file[], RedirectAttributes redirectAttributes) throws IOException {
		try {
			String fileNames=fileService.uploadFile(file, UPLOAD_DIRECTORY+username+"\\");
			redirectAttributes.addFlashAttribute("successMessage", "File upload successfully, uploaded file names: " + fileNames);
		} catch (FileDidntUploadException e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Please select a file to upload.");
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/showFiles")
	public String showUserFiles(@CurrentSecurityContext(expression = "authentication?.name") String username, RedirectAttributes redirectAttributes) throws IOException {
		String[] names;
		try {
			names = fileService.getAllFileNames(UPLOAD_DIRECTORY+username+"\\");
			String s = "YourFiles:";
			for (String n : names)
				s+=("\r\n "+n);
			redirectAttributes.addFlashAttribute("filesMessage", s);
		} catch (FileDidntUploadException e) {
			redirectAttributes.addFlashAttribute("filesMessage", "Your dir isn't exists.");
		}
		
		return "redirect:/user";
	}
}
