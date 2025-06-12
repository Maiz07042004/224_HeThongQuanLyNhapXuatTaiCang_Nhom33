/*	
*	(C) Copyright 2021 Fresher56. All Rights Reserved
*
* @author tuand
* @date May 8, 2021
* @ version 1.0
*/

package doan.movietheater.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import doan.movietheater.entity.Movie;
import doan.movietheater.model.ThongkeSLVDTO;
import doan.movietheater.service.impl.MovieServiceImpl;
import doan.movietheater.service.impl.ScheduleSeatServiceImpl;

@Controller
public class ThongkeController {
	@Autowired
	ScheduleSeatServiceImpl scheduleSeatServiceImpl;
	
	@Autowired
	MovieServiceImpl movieService;
	
	@GetMapping(value="/thongke")
	public String getThongkeSLV(Model model) {
		List<Movie> listMovie = movieService.getListMovie();
		model.addAttribute("listMovie", listMovie);
		return "thongkeVetheoPhim";
	}
	
	@GetMapping(value="/thongkeSLV")
	public String postThongkeSLV(@RequestParam("movieID") String movieID, Model model) {
		int tienveloai1 = 0;
		int tienveloai2 = 0;
		List<Object[]> listThongke = scheduleSeatServiceImpl.listThongkeSLV(movieID);
		List<Movie> listMovie = movieService.getListMovie();
		for(Object[] obj : listThongke) {
			if(((Integer) obj[2])==1) {
				tienveloai1 = ((Integer) obj[3])*60000;
			}
			if(((Integer) obj[2])==2) {
				tienveloai2 = ((Integer) obj[3])*45000;
			}
		}
		int tongtien = tienveloai1+tienveloai2;
		System.out.println("tienve1" + tienveloai1);
		System.out.println("tienve2" + tienveloai2);
		model.addAttribute("listMovie", listMovie);
		model.addAttribute("listThongke",listThongke);
		model.addAttribute("tienveloai1",tienveloai1);
		model.addAttribute("tienveloai2",tienveloai2);
		model.addAttribute("tongtien",tongtien);
		return "thongkeVetheoPhim";
	}
	
//	@GetMapping(value="/thongkeThang")
//	public String getThongkeSLVThang(Model model) {
//		List<Movie> listMovie = movieService.getListMovie();
//		model.addAttribute("listMovie", listMovie);
//		return "thongkeSLVThang";
//	}
//	
//	@GetMapping(value="/thongkeSLVThang")
//	public String postThongkeSLVThang(@RequestParam("movieID") String movieID, Model model) {
//		List<Movie> listMovie = movieService.getListMovie();
//		model.addAttribute("listMovie", listMovie);
//		List<Object[]> listThongke = movieService.listThongkeSLVThang(movieID);
//		ThongkeSLVDTO slvdto;
//		List<ThongkeSLVDTO> listThongkeSLVDTO = new ArrayList<ThongkeSLVDTO>();
//		for(Object[] obj : listThongke) {
//			slvdto = new ThongkeSLVDTO();
//			slvdto.setMovieID(movieID);
//			slvdto.setMovieName(obj[1].toString());
//			int giatien = 0;
//			if(obj[2].toString().equals("1")) {
//				int a = Integer.parseInt(obj[3].toString());
//				giatien = a*60000;
//			}
//			if(obj[2].toString().equals("2")) {
//				int a = Integer.parseInt(obj[3].toString());
//				giatien = a*45000;
//			}
//			slvdto.setSlV(Integer.parseInt(obj[3].toString()));
//			slvdto.setDoanhThu(giatien);
//			slvdto.setMonth(Integer.parseInt(obj[4].toString()));
//			listThongkeSLVDTO.add(slvdto);
//		}
//		model.addAttribute("listThongkeSLVDTO",listThongkeSLVDTO);
//		for(ThongkeSLVDTO slvdto2 : listThongkeSLVDTO) {
//			slvdto2.getMovieID();
//			slvdto2.getMovieName();
//			slvdto2.getSlV();
//			slvdto2.getMonth();
//			slvdto2.getDoanhThu();
//		}
//		return "thongkeSLVThang";
//	}
}
