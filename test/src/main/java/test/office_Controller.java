package test;

import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletResponse;

@Controller
public class office_Controller {
	
	@Resource(name="office_DTO")
	office_DTO odto;
	
	@Autowired
	office_service os;
	
	
	//지점 삭제
	@GetMapping("/office_delete.do")
	public String office_delete(@RequestParam("oidx")String oidx, @RequestParam("key")String key, ServletResponse res) {
		System.out.println(oidx);
		System.out.println(key);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
			System.out.println(oidx);
			
			Decoder decoder = Base64.getDecoder();
			byte[] keycheck = decoder.decode(key);
			String keycode = new String(keycheck);
			if(keycode.equals("wms.test")) {
				byte[] oidxcheck = decoder.decode(oidx);
				String no = new String(oidxcheck);
				int result = os.delete_office(no);
				if(result > 0) {
					pw.print("<script>"
							+ "alert('해당 지점이 삭제 되었습니다.');"
							+ "location.href='./office_main.do';"
							+ "</script>");
				}
				else {
					pw.print("<script>"
							+ "alert('해당 게시물의 정보가 올바르지 않습니다.');"
							+ "location.href='./office_main.do';"
							+ "</script>");
				}
			}
			else {
				pw.print("<script>"
						+ "alert('해당 페이지에 접근이 잘 못 되었습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		} catch (Exception e) {
			System.out.println("삭제 실패");
			System.out.println(e.getMessage());
		} finally {
			pw.close();
		}
		return null;
	}
	
	//지점 검색
	@CrossOrigin("*")
	@GetMapping("/search_ok.do")
	public String search_ok(@RequestParam("search") String search, Model m) {
		List<office_DTO> result = os.search_office(search);
		
		
		return null;
	}
	
	//지점 현황 페이지 출력
	@GetMapping("/office_main.do")
	public String office_main(Model m) {
		List<office_DTO> all = os.office_list();
		m.addAttribute("all", all);
		m.addAttribute("total", all.size());
		return null;
	}
}
