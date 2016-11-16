package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.FilmDAO;

@Controller
public class FilmController {
	@Autowired
	FilmDAO dao;
	
	@RequestMapping("FilmLookup.do")
		public ModelAndView filmById(@RequestParam(name="id") Integer id) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			List<String> film = dao.getFilmByID(id);
			mv.addObject("film", film);
			return mv;
		}
}
