package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        model.addAttribute("leads", hpDAO.getListofAllPLsRowMapper());
		return "index.html";
	}
}
