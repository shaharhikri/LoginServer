package login;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uploadFiles.FileService;

@Controller // changed from RestController
public class HomeResource {

	// what happen when you connect
	@RequestMapping("/")
	public String index() {
		return "redirect:/uploader";
	}

	
	@GetMapping("/user")
	public String user(@CurrentSecurityContext(expression = "authentication?.name") String username,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("filesMessage", "Please select a file to upload.");
		return "user.html";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin.html";
	}
}
