package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.HomePageDAO;

@Controller
public class HomePageController {
 
	private HomePageDAO hpDAO;
	
	public HomePageController(HomePageDAO hpDAO) {
		this.hpDAO = hpDAO;
	}
	@RequestMapping("home")
	public String getHomePage(Model model) {
		System.out.println("getHomePage begin");
        model.addAttribute("leads", hpDAO.getListOfSomePLsMyBatis());
		return "casePage.html";
	}
	@RequestMapping("/callServer")
	public @ResponseBody String getPLbyId() {
		System.out.println("called getPLbyId");
		return "success";
	}
}
