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

import ro.emanuel.DAO.DriverDao;
import ro.emanuel.POJO.Driver;


@Controller
public class DriverController {

	@GetMapping("/drivers/all")
	public ModelAndView list() throws SQLException {
		ArrayList<Driver> drivers = DriverDao.getAllDrivers();
		ModelAndView mv = new ModelAndView("alldrivers");
		mv.addObject("drivers", drivers);

		return mv;

	}

	@GetMapping("/drivers/{driverid}")
	public ModelAndView driverPageById(@PathVariable int driverid) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("singledriver");
		// get the watch from db
		Driver driver = DriverDao.getByDriverid(driverid);

		mav.addObject("driver", driver);

		return mav;
	}

	@GetMapping("/drivers/edit/{driverid}")
	public ModelAndView driverEditGet(Model model, @PathVariable int driverid) throws SQLException, IOException {

		Driver driver = DriverDao.getByDriverid(driverid);
		model.addAttribute("driver", driver);

		return new ModelAndView("editdriver","model",model);
	}

	@PostMapping("/drivers/edit")
	public ModelAndView driverEditSave(@ModelAttribute("driver") Driver d,
			ModelMap model, BindingResult result) {

		try {
			DriverDao.update(d);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/drivers/all");
	}

	@GetMapping("/drivers/add")
	public ModelAndView driverAddGet(Model model) throws SQLException, IOException {

		Driver driver = new Driver();
		model.addAttribute("driver", driver);

		return new ModelAndView("adddriver","model",model);
	}

	@PostMapping("/drivers/add")
	public ModelAndView driverAddSave(@ModelAttribute("driver") Driver d,
			ModelMap model, BindingResult result) {

		try {
			DriverDao.create(d);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/drivers/all");
	}

	@GetMapping("/drivers/delete/{driverid}")
	public ModelAndView driverDelete(@PathVariable int driverid) throws SQLException, IOException {

		DriverDao.delete(driverid);

		return new ModelAndView("redirect:/drivers/all");
	}

}

