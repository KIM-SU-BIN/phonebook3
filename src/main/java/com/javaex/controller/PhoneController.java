package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
//@RequestMapping(value = "/guest")
public class PhoneController {

	// 필드

	// 생성자

	// 메소드 gs

	// 메소드 일반
	//전화번호 수정폼
	@RequestMapping(value="/modifyForm/{no}", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@PathVariable("no") int num, Model model) {
		
		System.out.println("PhoneController>modifyForm()");
		
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(num);
		System.out.println(personVo);
		
		model.addAttribute("personVo" , personVo);
		
		
		return"/WEB-INF/views/modifyForm.jsp";
	}
	
	
	
	
	
	//전화번호 수정
	@RequestMapping(value="/modify", method={RequestMethod.GET, RequestMethod.POST})
	public String modify(PersonVo personVo) {
		System.out.println("PhoneController>modify()");
		
		//파라미타 꺼내기 +vo로 묶기를 DS해서 메소드의 파라미타로 보내줌
		System.out.println(personVo);
		
		//dao로 저장하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personUpdate(personVo);
		System.out.println(count);

		
		//리다이렉트		
		return "redirect:/list";
		
	}
	
	
	
	//전화번호 삭제 => value,String 뒤의 이름 달라도 됨!
	@RequestMapping(value="/delete/{no}", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("no") int num) {
		System.out.println("PhoneController>delete()");
		
		//주소에서 값 꺼내기
		System.out.println(num);
		
		//Dao로 처리하기/삭제
		PhoneDao phoneDao = new PhoneDao();
		int count =phoneDao.personDelete(num);
		System.out.println(count);
		
		return "redirect:/list";
	}
	
	
	
	
	//전화번호 리스트
	@RequestMapping(value = "/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list()");
		
		
		//Dao를 통해 PhoneList()를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		//ds데이터 보내기 --> request attribute에 넣는다.
		model.addAttribute("personList", personList);
	
		return "/WEB-INF/views/list.jsp";
	
	}
	
	
	
	//전화번호 등록
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})

	public String write(@ModelAttribute PersonVo personVo) {
	
		System.out.println("PhoneController>write");
		
		//파라미터 꺼내기+vo로 묶기를 DS해서 메소드의 파라미타로 보내줌
		System.out.println(personVo);
	
		
		//dao로 저장하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		
		
		//리다이렉트
		//리스트로 리다이렉트 시킬 예정 "" 사이는 무조건 때려 죽어도 포워드 자리. 
		//인터넷 주소 치면 jsp파일로 인식하여 오류 발생 -> 
		return "redirect:/list";
		
	}

	
	
	
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("writeForm()");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	
	

	// 테스트ver : jsp가 없을 경우에 method는 get,post 둘 다 쳐야함!
	@RequestMapping(value = "/test", method = { RequestMethod.GET, RequestMethod.POST })
	public String test() {

		System.out.println("PhoneController>test()");

		// 다오
		return "/WEB-INF/views/test.jsp";

	}

	// 등록메소드
	// 수정메소드
	// 삭제메소드
	// 리스트메소드

}
