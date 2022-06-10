package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/guest")
public class PhoneController {

	// 필드

	// 생성자

	// 메소드 gs

	// 메소드 일반

	// 테스트:jsp가 없을 경우에 method는 get,post 둘 다 쳐야함!
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
