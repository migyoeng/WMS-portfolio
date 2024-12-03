package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;

@Controller
public class office_Controller {
	
	@Resource(name="office_DTO")
	office_DTO odto;
	
	@Autowired
	office_service os;
	
	
	//지점 현황 페이지 출력
	@GetMapping("/office_main.do")
	public String office_main(Model m) {
		List<office_DTO> all = os.office_list();
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		return null;
	}
}
