/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.movietheater.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
//lan sau thay loi ni thi bo s
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import doan.movietheater.entity.Account;
import doan.movietheater.entity.CinemaRoom;
import doan.movietheater.entity.Member;
import doan.movietheater.entity.Movie;
import doan.movietheater.entity.MovieDate;
import doan.movietheater.entity.MovieDateId;
import doan.movietheater.entity.MovieSchedule;
import doan.movietheater.entity.MovieScheduleId;
import doan.movietheater.entity.Schedule;
import doan.movietheater.entity.ScheduleSeat;
import doan.movietheater.entity.Seat;
import doan.movietheater.entity.ShowDates;
import doan.movietheater.entity.Ticket;
import doan.movietheater.service.impl.AccountServiceImpl;
import doan.movietheater.service.impl.CinemaRoomServiceImpl;
import doan.movietheater.service.impl.MemberServiceImpl;
import doan.movietheater.service.impl.MovieDateServiceImpl;
import doan.movietheater.service.impl.MovieScheduleServiceImpl;
import doan.movietheater.service.impl.MovieServiceImpl;
import doan.movietheater.service.impl.ScheduleSeatServiceImpl;
import doan.movietheater.service.impl.ScheduleServiceImpl;
import doan.movietheater.service.impl.SeatServiceImpl;
import doan.movietheater.service.impl.ShowDateServiceImpl;
import doan.movietheater.service.impl.TicketServiceImpl;

@Controller
@RequestMapping(value = { "/", "Ticket_Selling" })
public class TicketSellingController {

	@Autowired
	ShowDateServiceImpl showDateService;

	@Autowired
	MovieDateServiceImpl movieDateService;

	@Autowired
	MovieScheduleServiceImpl movieScheduleService;

	@Autowired
	SeatServiceImpl seatService;

	@Autowired
	ScheduleSeatServiceImpl scheduleSeatService;

	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	MemberServiceImpl memberService;

	@Autowired
	MovieServiceImpl movieService;
	@Autowired
	CinemaRoomServiceImpl cinemaRoomService;

	@Autowired
	ScheduleServiceImpl scheduleService;

	@Autowired
	TicketServiceImpl ticketService;

	/* Gọi home page */
	@RequestMapping(value = { "/", "homePage"  })
	public String homePage(Model model) {

		return "homePage";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Movie */

	/* Goi man hinh hien thi danh sach phim */
	@RequestMapping(value = { "/movieList" })
	public String movieList(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<Movie> listMovie = movieService.getListMovie();
		model.addAttribute("listMovie", listMovie);
		return "danhSachPhim";

	}

	/* Goi man hinh them moi phim */
	@RequestMapping(value = { "/themMoi" })
	public String themMoi(@ModelAttribute("movie") Movie movie, Model model) {
		Map<Integer, String> mapRoom = new HashMap<Integer, String>();
		List<CinemaRoom> listRoom = cinemaRoomService.getListMovie();
		for (CinemaRoom cinemaRoom : listRoom) {
			mapRoom.put(cinemaRoom.getCinemaRoomID(), cinemaRoom.getCinemaRoomName());
		}
		model.addAttribute("listRoom", mapRoom);
		model.addAttribute("movie", new Movie());
		return "themMoiPhim";

	}

	/* Thuc hien them moi phim */
	@RequestMapping(value = { "/thucHienThemMoi" })
	public String thucHienThemMoi(@ModelAttribute("movie") Movie movie, Model model) {
		if (movieService.getAllMovieByID(movie.getMovieID()) == null) {
			movieService.addOrEditMovie(movie);
			model.addAttribute("insert", true);
			return "redirect:/movieList";
		} else {
			model.addAttribute("exits", true);
			return "redirect:/themMoi";
		}

	}

	/* Goi man hinh update phim */
	@RequestMapping(value = { "/updatePhim/{movieID}" })
	public String updatePhim(Model model, @PathVariable String movieID) {
		Movie movie = movieService.getMovieById(movieID);
		Map<Integer, String> mapRoom = new HashMap<Integer, String>();
		List<CinemaRoom> listRoom = cinemaRoomService.getListMovie();
		for (CinemaRoom cinemaRoom : listRoom) {
			mapRoom.put(cinemaRoom.getCinemaRoomID(), cinemaRoom.getCinemaRoomName());
		}
		model.addAttribute("listRoom", mapRoom);
		model.addAttribute("movie", movie);
		return "updatePhim";

	}

	/* Thuc hien update phim */
	@RequestMapping(value = { "/thucHienUpdatePhim" })
	public String thucHienUpdatePhim(@ModelAttribute("movie") Movie movie, Model model) {
		movieService.addOrEditMovie(movie);
		model.addAttribute("update", true);
		return "redirect:/movieList";

	}

	/* Thuc hien delete phim */
	@RequestMapping(value = { "/deletePhim/{movieID}" })
	public String thucHienDeletePhim(Model model, @PathVariable String movieID) {
		movieService.deleteMovie(movieID);
		model.addAttribute("delete", true);
		return "redirect:/movieList";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Room */

	/* Goi man hinh hien thi danh sach phòng chiếu */
	@RequestMapping(value = { "/listPhongChieu" })
	public String listPhongChieu(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<CinemaRoom> listRoom = cinemaRoomService.getListMovie();
		model.addAttribute("listRoom", listRoom);
		return "danhSachPhongChieu";

	}

	/* Goi man hinh them moi phòng chiếu */
	@RequestMapping(value = { "/themMoiPhongChieu" }, method = RequestMethod.GET)
	public String themMoiPhongChieu(Model model) {
		model.addAttribute("room", new CinemaRoom());
		return "themMoiPhongChieu";

	}

	/* Thuc hien them mới phòng chiếu */
	@RequestMapping(value = { "/thucHienThemMoiPhongChieu" }, method = RequestMethod.GET)
	public String thucHienThemMoiPhongChieu(@ModelAttribute("room") CinemaRoom room, Model model) {
		cinemaRoomService.addOrEditMovie(room);

		/* Thêm ghế vào bảng Seat, theo column: A B C D E F G H I J */
		for (int i = 1; i <= room.getSeatQuantity() / 10; i++) {
			Seat seat1 = new Seat();
			seat1.setSeatID(0);
			seat1.setSeatRow(i);
			seat1.setSeatColumn("A");
			seat1.setCinemaRoom(room);
			seatService.addOrEditSeat(seat1);

			Seat seat2 = new Seat();
			seat2.setSeatID(0);
			seat2.setSeatRow(i);
			seat2.setSeatColumn("B");
			seat2.setCinemaRoom(room);
			seatService.addOrEditSeat(seat2);

			Seat seat3 = new Seat();
			seat3.setSeatID(0);
			seat3.setSeatRow(i);
			seat3.setSeatColumn("C");
			seat3.setCinemaRoom(room);
			seatService.addOrEditSeat(seat3);

			Seat seat4 = new Seat();
			seat4.setSeatID(0);
			seat4.setSeatRow(i);
			seat4.setSeatColumn("D");
			seat4.setCinemaRoom(room);
			seatService.addOrEditSeat(seat4);

			Seat seat5 = new Seat();
			seat5.setSeatID(0);
			seat5.setSeatRow(i);
			seat5.setSeatColumn("E");
			seat5.setCinemaRoom(room);
			seatService.addOrEditSeat(seat5);

			Seat seat6 = new Seat();
			seat6.setSeatID(0);
			seat6.setSeatRow(i);
			seat6.setSeatColumn("F");
			seat6.setCinemaRoom(room);
			seatService.addOrEditSeat(seat6);

			Seat seat7 = new Seat();
			seat7.setSeatID(0);
			seat7.setSeatRow(i);
			seat7.setSeatColumn("G");
			seat7.setCinemaRoom(room);
			seatService.addOrEditSeat(seat7);

			Seat seat8 = new Seat();
			seat8.setSeatID(0);
			seat8.setSeatRow(i);
			seat8.setSeatColumn("H");
			seat8.setCinemaRoom(room);
			seatService.addOrEditSeat(seat8);

			Seat seat9 = new Seat();
			seat9.setSeatID(0);
			seat9.setSeatRow(i);
			seat9.setSeatColumn("I");
			seat9.setCinemaRoom(room);
			seatService.addOrEditSeat(seat9);

			Seat seat10 = new Seat();
			seat10.setSeatID(0);
			seat10.setSeatRow(i);
			seat10.setSeatColumn("J");
			seat10.setCinemaRoom(room);
			seatService.addOrEditSeat(seat10);

		}

		model.addAttribute("insert", true);
		return "redirect:/listPhongChieu";
	}

	/* Goi man hinh update phòng chiếu */
	@RequestMapping(value = { "/updatePhongChieu/{cinemaRoomID}" })
	public String updatePhongChieu(Model model, @PathVariable int cinemaRoomID) {
		CinemaRoom room = cinemaRoomService.getMovieById(cinemaRoomID);
		model.addAttribute("room", room);
		return "updatePhongChieu";

	}

	/* Thuc hien update phòng chiếu */
	@RequestMapping(value = { "/thucHienUpdatePhongChieu" })
	public String thucHienUpdatePhongChieu(@ModelAttribute("room") CinemaRoom room, Model model) {
		CinemaRoom roomOld = cinemaRoomService.getMovieById(room.getCinemaRoomID());
		int seatQuantityOld = roomOld.getSeatQuantity();
		cinemaRoomService.addOrEditMovie(room);

		if (seatQuantityOld < room.getSeatQuantity()) {
			/* Thêm ghế vào bảng Seat, theo column: A B C D E F G H I J */
			for (int i = seatQuantityOld / 10 + 1; i <= room.getSeatQuantity() / 10; i++) {
				Seat seat1 = new Seat();
				seat1.setSeatID(0);
				seat1.setSeatRow(i);
				seat1.setSeatColumn("A");
				seat1.setCinemaRoom(room);
				seatService.addOrEditSeat(seat1);

				Seat seat2 = new Seat();
				seat2.setSeatID(0);
				seat2.setSeatRow(i);
				seat2.setSeatColumn("B");
				seat2.setCinemaRoom(room);
				seatService.addOrEditSeat(seat2);

				Seat seat3 = new Seat();
				seat3.setSeatID(0);
				seat3.setSeatRow(i);
				seat3.setSeatColumn("C");
				seat3.setCinemaRoom(room);
				seatService.addOrEditSeat(seat3);

				Seat seat4 = new Seat();
				seat4.setSeatID(0);
				seat4.setSeatRow(i);
				seat4.setSeatColumn("D");
				seat4.setCinemaRoom(room);
				seatService.addOrEditSeat(seat4);

				Seat seat5 = new Seat();
				seat5.setSeatID(0);
				seat5.setSeatRow(i);
				seat5.setSeatColumn("E");
				seat5.setCinemaRoom(room);
				seatService.addOrEditSeat(seat5);

				Seat seat6 = new Seat();
				seat6.setSeatID(0);
				seat6.setSeatRow(i);
				seat6.setSeatColumn("F");
				seat6.setCinemaRoom(room);
				seatService.addOrEditSeat(seat6);

				Seat seat7 = new Seat();
				seat7.setSeatID(0);
				seat7.setSeatRow(i);
				seat7.setSeatColumn("G");
				seat7.setCinemaRoom(room);
				seatService.addOrEditSeat(seat7);

				Seat seat8 = new Seat();
				seat8.setSeatID(0);
				seat8.setSeatRow(i);
				seat8.setSeatColumn("H");
				seat8.setCinemaRoom(room);
				seatService.addOrEditSeat(seat8);

				Seat seat9 = new Seat();
				seat9.setSeatID(0);
				seat9.setSeatRow(i);
				seat9.setSeatColumn("I");
				seat9.setCinemaRoom(room);
				seatService.addOrEditSeat(seat9);

				Seat seat10 = new Seat();
				seat10.setSeatID(0);
				seat10.setSeatRow(i);
				seat10.setSeatColumn("J");
				seat10.setCinemaRoom(room);
				seatService.addOrEditSeat(seat10);

			}
		}

		/* Có lỗi khi thực hiện update với số ghế nhỏ hơn */
		/*
		 * if(seatQuantityOld > room.getSeatQuantity()) {
		 * seatService.deleteSeatRow(room.getCinemaRoomID()); }
		 */

		model.addAttribute("update", true);
		return "redirect:/listPhongChieu";

	}

	// Thuc hien delete phòng chiếu
	@RequestMapping(value = { "/deletePhongChieu/{cinemaRoomID}" })
	public String thucHienDeletePhongChieu(Model model, @PathVariable int cinemaRoomID) {
		cinemaRoomService.deleteMovie(cinemaRoomID);
		/* seatService.deleteSeatRow(cinemaRoomID); */ // Đang lỗi không xóa ghế được
		model.addAttribute("delete", true);
		return "redirect:/listPhongChieu";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Seat */

	/* Goi man hinh hien thi danh sach ghế ngồi */
	@RequestMapping(value = { "/listGheNgoi" })
	public String listGheNgoi(Model model) {
		List<CinemaRoom> listSeat = cinemaRoomService.getListMovie();
		model.addAttribute("listSeat", listSeat);
		return "danhSachGheNgoi";
	}
	//Onchange COmbobox
	@GetMapping(value="/thongtinghe")
	public String getlistGheNgoi(Model model, @RequestParam("roomID") String roomID) {
		List<CinemaRoom> listSeat = cinemaRoomService.getListMovie();
		List<Seat> listSeatRoom = seatService.listSeatByRoomID(roomID);
		model.addAttribute("listSeat", listSeat);
		model.addAttribute("listSeatRoom", listSeatRoom);
		return "danhSachGheNgoi";
	}
	
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Showdate */

	/* Goi man hinh hien thi danh sach ngay chieu */
	@RequestMapping(value = { "/listNgayChieu" })
	public String listNgayChieu(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<ShowDates> listShowdate = showDateService.getListShowDates();
		model.addAttribute("listShowdate", listShowdate);
		return "danhSachNgayChieu";

	}

	// Goi man hinh them moi ngay chieu
	@RequestMapping(value = { "/themMoiNgayChieu" })
	public String themMoiNgayChieu(Model model) {
		model.addAttribute("showdate", new ShowDates());
		return "themMoiNgayChieu";

	}

	// Thuc hien them moi ngay chieu
	@RequestMapping(value = { "/thucHienThemMoiNgayChieu" })
	public String thucHienThemMoiNgayChieu(@ModelAttribute("showdate") ShowDates showdate, Model model) {
		if (showDateService.checkShowDates(showdate.getShowDate()) == null) {
			showDateService.addOrEditShowDates(showdate);
			model.addAttribute("insert", true);
		} else {
			model.addAttribute("showdate", showdate);
			model.addAttribute("error", "Ngày chiếu này đã tồn tại!");
			return "themMoiNgayChieu";
		}
		return "redirect:/listNgayChieu";

	}

	// Goi man hinh update ngay chieu
	@RequestMapping(value = { "/updateNgayChieu/{showDateID}" })
	public String updateNgayChieu(Model model, @PathVariable int showDateID) {
		ShowDates showdate = showDateService.getShowDatesById(showDateID);
		model.addAttribute("showdate", showdate);
		return "updateNgayChieu";

	}

	// Thuc hien update ngay chieu
	@RequestMapping(value = { "/thucHienUpdateNgayChieu" })
	public String thucHienUpdateNgayChieu(@ModelAttribute("showdate") ShowDates showdate, Model model) {
		if (showDateService.checkShowDates(showdate.getShowDate()) == null) {
			showDateService.addOrEditShowDates(showdate);
			model.addAttribute("update", true);
		} else {
			model.addAttribute("showdate", showdate);
			model.addAttribute("error", "Ngày chiếu này đã tồn tại!");
			return "updateNgayChieu";
		}
		return "redirect:/listNgayChieu";

	}

	// Thuc hien delete ngày chiếu
	@RequestMapping(value = { "/deleteNgayChieu/{showDateID}" })
	public String thucHienDeleteNgayChieu(Model model, @PathVariable int showDateID) {
		showDateService.deleteShowDates(showDateID);
		model.addAttribute("delete", true);
		return "redirect:/listNgayChieu";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Schedule */

	/* Goi man hinh hien thi danh sach gio chieu */
	@RequestMapping(value = { "/listGioChieu" })
	public String listGioChieu(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<Schedule> listSchedule = scheduleService.getListSchedule();
		model.addAttribute("listSchedule", listSchedule);
		return "danhSachGioChieu";

	}
	
	@GetMapping(value="/themmoive")
	public String themMoiVe(Model model) {
		model.addAttribute("ticket", new Ticket());
		return"themMoiVe";
	}
	
	@PostMapping(value="/Ticket_Selling/themmoive")
	public String postthemMoiVe(@ModelAttribute("ticket")Ticket ticket) {
		ticket.setDeleteFlag(0);
		ticketService.addOrEditMovie(ticket);
		return "redirect:/listTicket";
	}
	@GetMapping(value="/Ticket_Selling/updateVe/{ticketID}")
	public String manghinhUpdateVe(Model model, @PathVariable int ticketID) {
		Ticket ticket = ticketService.getMovieById(ticketID);
		model.addAttribute("ticket",ticket);
		return "updateVe";
	}
	
	@PostMapping(value="/Ticket_Selling/thuchienupdateVe")
	public String thuchienUpdateVe(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticketService.addOrEditMovie(ticket);
		model.addAttribute("update",true);
		return "redirect:/listTicket";
	}
	
	/* Goi man hinh them moi giờ chiếu */
	@RequestMapping(value = { "/themMoiGioChieu" })
	public String themMoiGioChieu(Model model) {
		model.addAttribute("schedule", new Schedule());
		return "themMoiGioChieu";

	}
	
	// Thuc hien them moi giờ chieu
	@RequestMapping(value = { "/thucHienThemMoiGioChieu" })
	public String thucHienThemMoiGioChieu(@ModelAttribute("schedule") Schedule schedule, Model model) {
		scheduleService.addOrEditSchedule(schedule);
		model.addAttribute("insert", true);
		return "redirect:/listGioChieu";

	}

	// Goi man hinh update giờ chieu
	@RequestMapping(value = { "/updateGioChieu/{scheduleID}" })
	public String updateGioChieu(Model model, @PathVariable int scheduleID) {
		Schedule schedule = scheduleService.getScheduleById(scheduleID);
		model.addAttribute("schedule", schedule);
		return "updateGioChieu";

	}

	// Thuc hien update giờ chieu
	@RequestMapping(value = { "/thucHienUpdateGioChieu" })
	public String thucHienUpdateGioChieu(@ModelAttribute("schedule") Schedule schedule, Model model) {
		scheduleService.addOrEditSchedule(schedule);
		model.addAttribute("update", true);
		return "redirect:/listGioChieu";

	}

	// Thuc hien delete giờ chiếu
	@RequestMapping(value = { "/deleteGioChieu/{scheduleID}" })
	public String thucHienDeleteGioChieu(Model model, @PathVariable int scheduleID) {
		scheduleService.deleteSchedule(scheduleID);
		model.addAttribute("delete", true);
		return "redirect:/listGioChieu";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Movie_Date */

	/* Goi man hinh hien thi danh sach phim - ngay */
	@RequestMapping(value = { "/listPhim_Ngay" })
	public String listPhim_Ngay(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<MovieDate> listMovieDate = movieDateService.getListMovieDate();
		model.addAttribute("listMovieDate", listMovieDate);
		return "danhSachPhim_Ngay";

	}

	/* Goi man hinh them moi phim ngay chiếu */
	@RequestMapping(value = { "/themMoiPhim_Ngay" })
	public String themMoiPhim_Ngay(Model model) {
		Map<String, String> listMovieID = new HashMap<String, String>();
		List<Movie> listMovie = movieService.getListMovie();
		for (Movie movie : listMovie) {
			listMovieID.put(movie.getMovieID(), movie.getMovieNameVN());
		}
		Map<Integer, LocalDate> mapShowdate = new HashMap<Integer, LocalDate>();
		List<ShowDates> listShowdate = showDateService.getListShowDates();
		for (ShowDates showDates : listShowdate) {
			mapShowdate.put(showDates.getShowDateID(), showDates.getShowDate());
		}
		model.addAttribute("movieDate", new MovieDate());
		model.addAttribute("listMovieID", listMovieID);
		model.addAttribute("listShowdateID", mapShowdate);
		return "themMoiPhim_Ngay";

	}

	/* Thuc hien them moi phim ngày chiếu */
	@RequestMapping(value = { "/thucHienThemMoiPhim_Ngay" })
	public String thucHienThemMoiPhim_Ngay(@ModelAttribute("movieDate") MovieDate movieDate, Model model) {
		MovieDateId id = movieDate.getId();
		if (id != null && movieDateService.getMovieDateById(id) == null) {
			movieDateService.addOrEditMovieDate(movieDate);
			model.addAttribute("insert", true);
			return "redirect:/listPhim_Ngay";
		} else {
			model.addAttribute("error", true);
			return "redirect:/themMoiPhim_Ngay";
		}
	}

	/* Thuc hien delete phim ngày chiếu */

	@RequestMapping(value = { "/deletePhim_Ngay/{movieID}/{showDateID}" })
	public String thucHienDeletePhim_NgayChieu(Model model, @PathVariable String movieID,
			@PathVariable int showDateID) {
		MovieDateId id = new MovieDateId(movieID, showDateID);
		movieDateService.deleteMovieDate(id);
		model.addAttribute("delete", true);
		return "redirect:/listPhim_Ngay";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Movie_Schedule */

	// Goi man hinh hien thi danh sach phim - giờ
	@RequestMapping(value = { "/listPhim_Gio" })
	public String listPhim_Gio(Model model) {
		List<MovieSchedule> listMovieSchedule = movieScheduleService.getListMovieSchedule();
		model.addAttribute("listMovieSchedule", listMovieSchedule);
		return "danhSachPhim_Gio";

	}

	// Goi man hinh them moi phim giờ chiếu
	@RequestMapping(value = { "/themMoiPhim_Gio" })
	public String themMoiPhim_Gio(Model model) {
		Map<String, String> mapMovie = new HashMap<String, String>();
		List<Movie> listMovie = movieService.getListMovie();
		for (Movie movie : listMovie) {
			mapMovie.put(movie.getMovieID(), movie.getMovieNameVN());
		}
		Map<Integer, String> mapSchedule = new HashMap<Integer, String>();
		List<Schedule> listSchedule = scheduleService.getListSchedule();
		for (Schedule schedule : listSchedule) {
			mapSchedule.put(schedule.getScheduleID(), schedule.getScheduleTime());
		}
		model.addAttribute("movieSchedule", new MovieSchedule());
		model.addAttribute("mapMovie", mapMovie);
		model.addAttribute("listScheduleID", mapSchedule);
		return "themMoiPhim_Gio";

	}

	/* Thuc hien them moi phim giờ chiếu */
	@RequestMapping(value = { "/thucHienThemMoiPhim_Gio" })
	public String thucHienThemMoiPhim_Gio(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule, Model model) {
		Movie movie = movieService.getMovieById(movieSchedule.getMovie().getMovieID());
		Schedule schedule = scheduleService.getScheduleById(movieSchedule.getSchedule().getScheduleID());
		MovieScheduleId id = new MovieScheduleId(movie.getMovieID(), schedule.getScheduleID());
		movieSchedule.setId(id);
		if (movieScheduleService.getMovieScheduleById(id) == null) {
			movieScheduleService.addOrEditMovieSchedule(movieSchedule);
			model.addAttribute("insert", true);
			return "redirect:/listPhim_Gio";
		} else {
			model.addAttribute("error", true);
			return "redirect:/themMoiPhim_Gio";
		}
	}

	/* Thuc hien delete phim giờ chiếu */

	@RequestMapping(value = { "/deletePhim_Gio/{movieID}/{scheduleID}" })
	public String thucHienDeletePhim_GioChieu(Model model, @PathVariable String movieID, @PathVariable int scheduleID) {
		MovieScheduleId id = new MovieScheduleId(movieID, scheduleID);
		movieScheduleService.deleteMovieSchedule(id);
		model.addAttribute("delete", true);
		return "redirect:/listPhim_Gio";

	}

	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	/* Màn hình Schedule_Seat */

	// Goi man hinh hien thi danh sach lich chieu
	@RequestMapping(value = { "/listLichChieu" })
	public String listLichChieu(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<ScheduleSeat> listScheduleSeat = scheduleSeatService.getListMovie();
		model.addAttribute("listScheduleSeat", listScheduleSeat);
		return "danhSachLichChieu";

	}

	// Goi man hinh them moi lịch chiếu
	@RequestMapping(value = { "/themMoiLichChieu" })
	public String themMoiLichChieu(Model model) {
		Map<String, String> listMovieID = new HashMap<String, String>();
		List<Movie> listMovie = movieService.getListMovie();
		for (Movie movie : listMovie) {
			listMovieID.put(movie.getMovieID(), movie.getMovieNameVN());
		}

		Map<Integer, LocalDate> listShowdateID = new HashMap<Integer, LocalDate>();
		List<ShowDates> listShowdate = showDateService.getListShowDates();
		for (ShowDates showdate : listShowdate) {
			listShowdateID.put(showdate.getShowDateID(), showdate.getShowDate());
		}

		Map<Integer, String> listScheduleID = new HashMap<Integer, String>();
		List<Schedule> listSchedule = scheduleService.getListSchedule();
		for (Schedule schedule : listSchedule) {
			listScheduleID.put(schedule.getScheduleID(), schedule.getScheduleTime());
		}

		List<Integer> listSeatID = new ArrayList<Integer>();
		List<Seat> listSeat = seatService.getListSeat();
		for (Seat seat : listSeat) {
			listSeatID.add(seat.getSeatID());
		}

		List<Integer> listTicketID = new ArrayList<Integer>();
		List<Ticket> listTicket = ticketService.getListMovie();
		for (Ticket ticket : listTicket) {
			listTicketID.add(ticket.getTicketID());
		}

		model.addAttribute("scheduleSeat", new ScheduleSeat());
		model.addAttribute("listMovieID", listMovieID);
		model.addAttribute("listShowdateID", listShowdateID);
		model.addAttribute("listScheduleID", listScheduleID);
		model.addAttribute("listSeatID", listSeatID);
		model.addAttribute("listTicketID", listTicketID);

		return "themMoiLichChieu";

	}

	// Thuc hien them moi lịch chiếu
	@RequestMapping(value = { "/thucHienThemMoiLichChieu" })
	public String thucHienThemMoiLichChieu(@ModelAttribute("scheduleSeat") ScheduleSeat scheduleSeat, Model model) {
		String b = scheduleSeat.getScheduleSeatID();
		int a=scheduleSeat.getSeat().getSeatID();
		Seat seat = seatService.getSeatById(a);
		CinemaRoom cinemaRoom = cinemaRoomService.getMovieById(seat.getCinemaRoom().getCinemaRoomID());
		Ticket ticket = ticketService.getMovieById(2);
		Seat seat1;
		for(int i=1;i<=cinemaRoom.getSeatQuantity();i++) {			
			seat1 = seatService.getSeatById(a);
			scheduleSeat.setScheduleSeatID(b+i);
			scheduleSeat.setSeatRow(seat1.getSeatRow());
			scheduleSeat.setSeatColumn(seat1.getSeatColumn());
			if(i>cinemaRoom.getSeatQuantity()-20) {
				scheduleSeat.setTicket(ticket);
				scheduleSeat.setSeatType(1);
			}
			scheduleSeatService.addOrEditMovie(scheduleSeat);
			a++;
		}
		
		
		
		List<ScheduleSeat> listScheduleSeat = scheduleSeatService.getListMovie();
		model.addAttribute("listScheduleSeat", listScheduleSeat);
		model.addAttribute("messageInsert", "Thêm mới lịch chiếu thành công!");
		return "redirect:/listLichChieu";

	}

	// Goi man hinh update lịch chieu
	@RequestMapping(value = { "/updateLichChieu/{scheduleSeatID}" })
	public String updateLichChieu(Model model, @PathVariable String scheduleSeatID) {
		ScheduleSeat scheduleSeat = scheduleSeatService.getScheduleSeatById(scheduleSeatID);
		List<String> listMovieID = new ArrayList<String>();
		List<Movie> listMovie = movieService.getListMovie();
		for (Movie movie : listMovie) {
			listMovieID.add(movie.getMovieID());
		}

		List<Integer> listShowdateID = new ArrayList<Integer>();
		List<ShowDates> listShowdate = showDateService.getListShowDates();
		for (ShowDates showdate : listShowdate) {
			listShowdateID.add(showdate.getShowDateID());
		}

		List<Integer> listScheduleID = new ArrayList<Integer>();
		List<Schedule> listSchedule = scheduleService.getListSchedule();
		for (Schedule schedule : listSchedule) {
			listScheduleID.add(schedule.getScheduleID());
		}

		List<Integer> listSeatID = new ArrayList<Integer>();
		List<Seat> listSeat = seatService.getListSeat();
		for (Seat seat : listSeat) {
			listSeatID.add(seat.getSeatID());
		}

		List<Integer> listTicketID = new ArrayList<Integer>();
		List<Ticket> listTicket = ticketService.getListMovie();
		for (Ticket ticket : listTicket) {
			listTicketID.add(ticket.getTicketID());
		}
		model.addAttribute("scheduleSeat", scheduleSeat);
		model.addAttribute("listMovieID", listMovieID);
		model.addAttribute("listShowdateID", listShowdateID);
		model.addAttribute("listScheduleID", listScheduleID);
		model.addAttribute("listSeatID", listSeatID);
		model.addAttribute("listTicketID", listTicketID);
		return "updateLichChieu";

	}

	// Thuc hien update lịch chieu
	@RequestMapping(value = { "/thucHienUpdateLichChieu" })
	public String thucHienUpdateLichChieu(@ModelAttribute("scheduleSeat") ScheduleSeat scheduleSeat, Model model) {
		scheduleSeatService.addOrEditMovie(scheduleSeat);
		
		List<ScheduleSeat> listScheduleSeat = scheduleSeatService.getListMovie();
		model.addAttribute("listScheduleSeat", listScheduleSeat);
		model.addAttribute("messageUpdate", "Cập nhật lịch chiếu thành công!");
		return "redirect:/listLichChieu";

	}

	// Thuc hien delete lịch chiếu
	@RequestMapping(value = { "/deleteLichChieu/{scheduleSeatID}" })
	public String thucHienDeleteLichChieu(Model model, @PathVariable String scheduleSeatID) {
		scheduleSeatService.deleteMovie(scheduleSeatID);
		List<ScheduleSeat> listScheduleSeat = scheduleSeatService.getListMovie();
		model.addAttribute("listScheduleSeat", listScheduleSeat);
		model.addAttribute("messageUpdate", "Lịch chiếu đã được xóa!");
		return "redirect:/listLichChieu";

	}
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	// Goi man hinh hien thi danh sach ve
	@RequestMapping(value = { "/listTicket" })
	public String listTicket(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<Ticket> listTicket = ticketService.getListMovie();
		model.addAttribute("listTicket", listTicket);
		return "danhSachVe";

	}
	
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/

	// Goi man hinh hien thi danh sach lich chieu
	@RequestMapping(value = { "/listKhachHang" })
	public String listMember(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<Account> listAccount = accountService.getListCustomer();
		model.addAttribute("listAccount", listAccount);
		if(listAccount.isEmpty()) {
			System.out.println("list rong");
		}
		return "danhSachKhachHang";

	}
	
	@RequestMapping(value = { "/listNhanVien" })
	public String listNhanVien(Model model, HttpSession httpSession) {
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		List<Account> listAccount = accountService.getListNV();
		model.addAttribute("listAccount", listAccount);
		return "danhSachNhanVien";

	}
	
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/**
	 * The function retrieves data from the Show Date, Movie Date, Movie, Schedule
	 * Seat, Schedule tables on the Show Time screen.
	 * 
	 * @param model
	 * @return showTime.jsp
	 */
	@RequestMapping(value = { /* "/", */ "Show_Time" })
	public String showTime(Model model) {
		String id;
		String nullMovieMessage = "";
		String btnNormal = "btn-show-date";
		String btnChoose = "btn-show-date-choose";

		List<MovieDate> listMovieDate = null;
		List<ShowDates> listShowDates = null;
		List<MovieSchedule> listMovieSchedule = null;

		// Get the current day and the current day +6
		LocalDate dateNow = LocalDate.now();
		LocalDate dateEnd = dateNow.plusDays(6);

		// Get the current time
		LocalTime timeNow = LocalTime.now();
		int hourNow = timeNow.getHour();
		int minuteNow = timeNow.getMinute();

		listShowDates = showDateService.listShowDate(dateNow, dateEnd);

		// If listShowDate is empty, there is definitely no movie show times
		int dateID = 0;
		if (!listShowDates.isEmpty()) {
			dateID = listShowDates.get(0).getShowDateID();
			listMovieDate = movieDateService.listMovieDate(listShowDates.get(0).getShowDateID());

			/*
			 * If listMovieDate is empty, the movie will not be able to link to the release
			 * date, resulting in no movie show times
			 */
			if (listMovieDate.isEmpty()) {
				nullMovieMessage = "Không tồn tại dữ liệu tương ứng!...";

			} else {

				// Get the show times assigned to each movie by movieID
				for (int i = 0; i < listMovieDate.size(); i++) {
					id = listMovieDate.get(i).getMovie().getMovieID();
					listMovieSchedule = movieScheduleService.listMovieSchedule(id);

					// If the show times are empty, remove the movie from the list
					if (listMovieSchedule.isEmpty()) {
						listMovieDate.remove(i);
					}

					listMovieDate.get(i).getMovie().setListMovieSchedule(listMovieSchedule);
				}
			}
		} else {
			nullMovieMessage = "Không tồn tại dữ liệu tương ứng!.";
		}

		model.addAttribute("dateID", dateID);
		model.addAttribute("dateNowID", dateID);
		model.addAttribute("btnNormal", btnNormal);
		model.addAttribute("btnChoose", btnChoose);
		model.addAttribute("hourNow", hourNow);
		model.addAttribute("minuteNow",minuteNow);
		model.addAttribute("listShowDates", listShowDates);
		model.addAttribute("listMovieDate", listMovieDate);
		model.addAttribute("nullMovieMessage", nullMovieMessage);

		return "showTime";
	}

	/**
	 * 
	 * The function retrieves data from Display Date, Movie Date, Movie, Schedule
	 * Seat, Schedule Table on the Display of time with the corresponding projection
	 * date.
	 * 
	 * @param model
	 * @param dateID
	 * @param session
	 * @return showTime.jsp
	 */
	@RequestMapping(value = { "Show_Date/{dateID}" })
	public String showTimeByDate(Model model, @PathVariable int dateID, HttpSession session) {
		String id;
		String nullMovieMessage = "";
		String btnNormal = "btn-show-date";
		String btnChoose = "btn-show-date-choose";
		int dateNowID = 0;

		List<MovieDate> listMovieDate = null;
		List<ShowDates> listShowDates = null;
		List<MovieSchedule> listMovieSchedule = null;

		// Get the current day and the current day +6
		LocalDate dateNow = LocalDate.now();
		LocalDate dateEnd = dateNow.plusDays(6);

		// Get the current time
		LocalTime timeNow = LocalTime.now();
		int hourNow = timeNow.getHour();
		int minuteNow = timeNow.getMinute();

		listShowDates = showDateService.listShowDate(dateNow, dateEnd);
		dateNowID = listShowDates.get(0).getShowDateID();

		/*
		 * If the user intentionally entered a projection date smaller than the current
		 * date, a value equal to the current date is required
		 */
		if (dateID < listShowDates.get(0).getShowDateID()) {
			dateID = listShowDates.get(0).getShowDateID();
		}

		/*
		 * If the user intentionally entered a projection date greater than the current
		 * date +5, assign the value equal to the current date +5
		 */
		if (dateID > listShowDates.get(listShowDates.size() - 1).getShowDateID()) {
			dateID = listShowDates.get(listShowDates.size() - 1).getShowDateID();
		}

		// If listShowDate is empty, there is definitely no movie showtimes
		if (!listShowDates.isEmpty()) {
			listMovieDate = movieDateService.listMovieDate(dateID);

			/*
			 * If listMovieDate is empty, the movie will not be able to link to the release
			 * date, resulting in no movie show times
			 */
			if (listMovieDate.isEmpty()) {
				nullMovieMessage = "There are no showtimes for this day.";

			} else {

				// Get the show times assigned to each movie by movieID
				for (int i = 0; i < listMovieDate.size(); i++) {
					id = listMovieDate.get(i).getMovie().getMovieID();
					listMovieSchedule = movieScheduleService.listMovieSchedule(id);

					// If the show times are empty, remove the movie from the list
					if (listMovieSchedule.isEmpty()) {
						listMovieDate.remove(i);
					}

					listMovieDate.get(i).getMovie().setListMovieSchedule(listMovieSchedule);
				}
			}
		} else {
			nullMovieMessage = "There are no showtimes for this day.";
		}

		/*
		 * Delete account so that when users continue to book information is not
		 * duplicated
		 */
		session.removeAttribute("member");

		model.addAttribute("dateID", dateID);
		model.addAttribute("dateNowID", dateNowID);
		model.addAttribute("btnNormal", btnNormal);
		model.addAttribute("btnChoose", btnChoose);
		model.addAttribute("hourNow", hourNow);
		model.addAttribute("minuteNow",minuteNow);
		model.addAttribute("listShowDates", listShowDates);
		model.addAttribute("listMovieDate", listMovieDate);
		model.addAttribute("nullMovieMessage", nullMovieMessage);

		return "showTime";
	}

	/**
	 * 
	 * The function of taking a seat list from the Seats table to display the seat
	 * list on the Select a seat screen for the user to select.
	 * 
	 * @param model
	 * @param showDateID
	 * @param movieID
	 * @param scheduleID
	 * @param session
	 * @return selectSeat.jsp
	 */
	@RequestMapping(value = { "Selecting_Seat/{showDateID}/{movieID}/{scheduleID}" })
	public String selectingSeat(Model model, @PathVariable int showDateID, @PathVariable String movieID,
			@PathVariable int scheduleID, HttpSession session) {
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "redirect:/login";
		}
		int sizeColumn = 0;
		int sizeRow = 0;

		MovieSchedule movieSchedule = new MovieSchedule();
		MovieDate movieDate = new MovieDate();

		List<ScheduleSeat> listSeatOfMovie = null;
		List<String> listSeatColumn = null;
		List<Integer> listSeatRow = null;

		// Get schedule information by movieID, scheduleID and showDateID
		movieSchedule = movieScheduleService.movieScheduleChoose(movieID, scheduleID);
		movieDate = movieDateService.movieDateChoose(movieID, showDateID);

		// Get a list of seats of the user-selected movie
		listSeatOfMovie = scheduleSeatService.listSeat(movieID, showDateID, scheduleID);

		// Get a list of chair columns
		listSeatColumn = scheduleSeatService.listSeatColumn(movieID, showDateID, scheduleID);
		sizeColumn = listSeatColumn.size() - 1;

		// Get a list of rows of seats
		listSeatRow = scheduleSeatService.listSeatRow(movieID, showDateID, scheduleID);
		sizeRow = listSeatRow.size() - 1;

		// If there is no seat, go to the error page
		if (listSeatOfMovie.isEmpty()) {
			String error = "There is no seat to view.";

			model.addAttribute("errorData", error);

			return "selectSeat";
		}

		model.addAttribute("listSeatOfMovie", listSeatOfMovie);
		model.addAttribute("sizeColumn", sizeColumn);
		model.addAttribute("sizeRow", sizeRow);

		/*
		 * Delete account so that when users continue to book information is not
		 * duplicated
		 */
		session.removeAttribute("member");

		/*
		 * Save the selected user's projection schedule to the session to reuse for
		 * booking
		 */
		session.setAttribute("movieDate", movieDate);
		session.setAttribute("movieSchedule", movieSchedule);

		return "selectSeat";
	}

	/**
	 * 
	 * The function takes a list of seats that have been selected by the user to
	 * display information on the Confirm booking ticket screen.
	 * 
	 * @param model
	 * @param listSeat
	 * @param session
	 * @return confirmBookingTicket.jsp
	 */
	@RequestMapping(value = { "Booking_Ticket" })
	public String bookingTicket(Model model, @RequestParam("listSeat") List<String> listSeat, HttpSession session) {

		List<ScheduleSeat> listSeatChoose = new ArrayList<>();
		String totalPriceString = "";

		// Retrieve information about user selected seats by Id
		for (int i = 0; i < listSeat.size(); i++) {
			listSeatChoose.add(scheduleSeatService.getMovieById(listSeat.get(i)));
		}

		// Calculate the total amount
		int totalPrice = 0;
		for (int i = 0; i < listSeatChoose.size(); i++) {
			totalPrice += listSeatChoose.get(i).getTicket().getPrice();
		}

		totalPriceString = String.format("%,d", totalPrice);
		totalPriceString = totalPriceString.replace(",", ".");

		session.setAttribute("totalPriceString", totalPriceString);

		session.removeAttribute("member");
		session.removeAttribute("searchAccount");

		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("listSeat", listSeatChoose);

		return "confirmBookingTicket";
	}

	/**
	 * 
	 * The function checks customer information according to the information entered
	 * by the user.
	 * 
	 * @param model
	 * @param searchAccount
	 * @param session
	 * @return confirmBookingTicket.jsp
	 */
	@RequestMapping(value = { "Check_Member" }, method = RequestMethod.POST, params = "checkAccount")
	public String checkAccount(Model model, @RequestParam("searchAccount") String searchAccount, HttpSession session) {
		String checkAccountMessage = "";
		String scoreString = "";

		Account account = new Account();
		Member member = new Member();

		// Get member information by accountID

			System.out.println(searchAccount);
			account = accountService.getAccountByPhoneNumber(searchAccount);
			if(account == null) {
				checkAccountMessage = "No member has found.";
				session.removeAttribute("member");

				session.setAttribute("searchAccount", searchAccount);

				model.addAttribute("checkAccountMessage", checkAccountMessage);

				return "confirmBookingTicket";
			}
			member = memberService.getMemberByAccountId(account.getAccountID());

		// If the corresponding account cannot be found, notify the user
		if (member == null) {
			checkAccountMessage = "No member has found.";

			/*
			 * Delete account so that when users continue to book information is not
			 * duplicated
			 */
			session.removeAttribute("member");

			session.setAttribute("searchAccount", searchAccount);

			model.addAttribute("checkAccountMessage", checkAccountMessage);

			return "confirmBookingTicket";
		}

		scoreString = String.format("%,d", member.getScore());
		scoreString = scoreString.replace(",", ".");

		session.setAttribute("scoreString", scoreString);

		session.setAttribute("member", member);

		session.setAttribute("searchAccount", searchAccount);

		return "confirmBookingTicket";
	}

	/**
	 * 
	 * The function to check the accumulated scores of customers is enough to redeem
	 * tickets or not.
	 * 
	 * @param model
	 * @param searchAccount
	 * @param convertTicket
	 * @param session
	 * @return Test.jsp
	 */
	//Screen confirm ticket no member
	@SuppressWarnings("unchecked")
	@GetMapping(value="Confirm_Booking_Ticket")
	public String getconfirmBookingTicket(Model model,
			HttpSession session) {

		List<ScheduleSeat> listScheduleSeat = new ArrayList<>();
		listScheduleSeat = (List<ScheduleSeat>) session.getAttribute("listSeat");
		Seat seat = seatService.getSeatById(listScheduleSeat.get(0).getSeat().getSeatID());
		/*
		 * If the user's accumulated points are not enough to redeem the ticket, the
		 * notice will be displayed on the screen
		 */

		if (!listScheduleSeat.isEmpty()) {
			for (int i = 0; i < listScheduleSeat.size(); i++) {
				listScheduleSeat.get(i).setSeatStatus(1);
				scheduleSeatService.addOrEditMovie(listScheduleSeat.get(i));
			}
		}
		model.addAttribute("cinemaRoom", seat.getCinemaRoom().getCinemaRoomName());
		return "ticketInformation";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "Confirm_Booking_Ticket" }, method = RequestMethod.POST, params = "cofirm")
	public String confirmBookingTicket(Model model, @RequestParam("convertTicket") String convertTicket,
			HttpSession session) {

		List<ScheduleSeat> listScheduleSeat = new ArrayList<>();

		int price;
		String scoreMassage = "";
		Member member = new Member();

		listScheduleSeat = (List<ScheduleSeat>) session.getAttribute("listSeat");
		Seat seat = seatService.getSeatById(listScheduleSeat.get(0).getSeat().getSeatID());
		member = (Member) session.getAttribute("member");
		price = (int) session.getAttribute("totalPrice");

		/*
		 * If the user's accumulated points are not enough to redeem the ticket, the
		 * notice will be displayed on the screen
		 */
		if (convertTicket.equals("Agree")) {
			if (member.getScore() < price) {
				scoreMassage = "Member score is not enough to convert into ticket.";

				model.addAttribute("scoreMassage", scoreMassage);

				return "confirmBookingTicket";
			} else {
				member.setScore(member.getScore() - price);
				memberService.addOrEditMovie(member);
			}
		}else {
			member.setScore(member.getScore() + price/10);
			memberService.addOrEditMovie(member);
		}

		if (!listScheduleSeat.isEmpty()) {
			for (int i = 0; i < listScheduleSeat.size(); i++) {
				listScheduleSeat.get(i).setSeatStatus(1);
				scheduleSeatService.addOrEditMovie(listScheduleSeat.get(i));
			}
		}
		model.addAttribute("cinemaRoom", seat.getCinemaRoom().getCinemaRoomName());
		return "ticketInformation";
	}

	@RequestMapping(value = { "errorPage" })
	public String errorPage(Model model) {

		String error = "This function does not exist!";

		model.addAttribute("errorData", error);

		return "error404";
	}
	
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	
	/*Màn hình chi tiết Phim*/
	
	@RequestMapping(value = { "movieDetail/{movieID}" })
	public String movieDetail(Model model, @PathVariable String movieID) {
		Movie movie = movieService.getMovieById(movieID);
		model.addAttribute("movie", movie);
		return "movieDetail";
	}
	
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	/***********************************************************************************************************************/
	
	/*Search Phim*/
	
	@RequestMapping(value = { "searchPhim" }, method = RequestMethod.GET, params = "movie")
	public String searchPhim(Model model, @RequestParam("movie") String movie) {		
		List<Movie> listMovie = movieService.getMovieByName(movie);
		if(listMovie.isEmpty()) {
			model.addAttribute("error", true);
			return "redirect:/homePage";
		}else {
			List<Movie> movieShow = listMovie;
			model.addAttribute("movies", movieShow);
			return "movieDetail";
		}
	}
}
