package user;


import java.io.IOException;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import errors.FileDidntUploadException;

@Controller // changed from RestController
public class HomeController {

	// what happen when you connect
	@RequestMapping(
			path = "/"
			, method = RequestMethod.GET)
	public String index(
			@CurrentSecurityContext(expression = "authentication?.name") String username
			,@RequestParam(value="username", required=false, defaultValue="World") String name
			, Model model) {
		model.addAttribute("username", "Hello " + username);
		return "index";
	}

	@GetMapping("/login")
	public String login(@CurrentSecurityContext(expression = "authentication?.name") String username) {
		if (username.equals("anonymousUser"))
			return "login";
		return "redirect:/";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup3";
	}
	
//	@PostMapping("/signup")
//	public String addUser() {
//		//user pass
//		return "redirect:/signup";
//	}

	
	//**********Not using*********
	@GetMapping("/user")
	public String user() {
		return "user.html";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin.html";
	}
}
