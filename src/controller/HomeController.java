package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Author;
import service.BookAuthorService;

@Controller
public class HomeController {
	
	@Autowired
	private BookAuthorService bookAuthorServiceDao;
	
	@RequestMapping(value="/")
	public String WelcomeLibrary(){
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String WelcomeLibraryHome(Model model){
		List<Author> authorList = bookAuthorServiceDao.getAllAuthors();
		model.addAttribute("authorList", authorList);
		return "home";
	}
	
}
