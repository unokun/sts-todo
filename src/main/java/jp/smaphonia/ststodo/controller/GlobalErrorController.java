package jp.smaphonia.ststodo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GlobalErrorController implements ErrorController {

	private static final String PATH = "/error";

	@Override
	public String getErrorPath() {
		return PATH;
	}

//	@RequestMapping("/404")
//	String notFoundError() {
//		log.error("404");
//		return "error/404";
//	}

	@RequestMapping("/error")
	String home() {
		return "error/general";
	}
}
