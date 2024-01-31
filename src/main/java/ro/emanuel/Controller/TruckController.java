package ro.emanuel.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.DAO.TruckDao;
import ro.emanuel.POJO.Truck;


@Controller
public class TruckController {

	@GetMapping("/trucks/all")
	public ModelAndView list() throws SQLException {
		ArrayList<Truck> trucks = TruckDao.getAllTrucks();
		ModelAndView mv = new ModelAndView("alltrucks");
		mv.addObject("trucks", trucks);

		return mv;

	}

	@GetMapping("/trucks/{truckid}")
	public ModelAndView truckPageById(@PathVariable int truckid) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("singletruck");
		// get the watch from db
		Truck truck = TruckDao.getByTruckid(truckid);

		mav.addObject("truck", truck);

		return mav;
	}

	@GetMapping("/trucks/edit/{truckid}")
	public ModelAndView truckEditGet(Model model, @PathVariable int truckid) throws SQLException, IOException {

		Truck truck = TruckDao.getByTruckid(truckid);
		model.addAttribute("truck", truck);

		return new ModelAndView("edittruck","model",model);
	}

	@PostMapping("/trucks/edit")
	public ModelAndView truckEditSave(@ModelAttribute("truck") Truck t,
			ModelMap model, BindingResult result) {

		try {
			TruckDao.update(t);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/trucks/all");
	}

	@GetMapping("/trucks/add")
	public ModelAndView truckAddGet(Model model) throws SQLException, IOException {

		Truck truck = new Truck();
		model.addAttribute("truck", truck);

		return new ModelAndView("addtruck","model",model);
	}

	@PostMapping("/trucks/add")
	public ModelAndView truckAddSave(@ModelAttribute("truck") Truck t,
			ModelMap model, BindingResult result) {

		try {
			TruckDao.create(t);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/trucks/all");
	}

	@GetMapping("/trucks/delete/{truckid}")
	public ModelAndView truckDelete(@PathVariable int truckid) throws SQLException, IOException {

		TruckDao.delete(truckid);

		return new ModelAndView("redirect:/trucks/all");
	}

}