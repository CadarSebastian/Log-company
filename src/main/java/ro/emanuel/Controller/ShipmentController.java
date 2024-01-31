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

import ro.emanuel.DAO.ShipmentDao;
import ro.emanuel.POJO.Shipment;


@Controller
public class ShipmentController {

	@GetMapping("/shipments/all")
	public ModelAndView list() throws SQLException {
		ArrayList<Shipment> shipments = ShipmentDao.getAllShipments();
		ModelAndView mv = new ModelAndView("allshipments");
		mv.addObject("shipments", shipments);

		return mv;

	}

	@GetMapping("/shipments/{shipmentid}")
	public ModelAndView shipmentPageById(@PathVariable int shipmentid) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("singleshipment");
		// get the watch from db
		Shipment shipment = ShipmentDao.getByShipmentid(shipmentid);

		mav.addObject("shipment", shipment);

		return mav;
	}

	@GetMapping("/shipments/edit/{shipmentid}")
	public ModelAndView shipmentEditGet(Model model, @PathVariable int shipmentid) throws SQLException, IOException {

		Shipment shipment = ShipmentDao.getByShipmentid(shipmentid);
		model.addAttribute("shipment", shipment);

		return new ModelAndView("editshipment","model",model);
	}

	@PostMapping("/shipments/edit")
	public ModelAndView shipmentEditSave(@ModelAttribute("shipment") Shipment s,
			ModelMap model, BindingResult result) {

		try {
			ShipmentDao.update(s);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/shipments/all");
	}

	@GetMapping("/shipments/add")
	public ModelAndView shipmentAddGet(Model model) throws SQLException, IOException {

		Shipment shipment = new Shipment();
		model.addAttribute("shipment", shipment);

		return new ModelAndView("addshipment","model",model);
	}

	@PostMapping("/shipments/add")
	public ModelAndView shipmentAddSave(@ModelAttribute("shipment") Shipment s,
			ModelMap model, BindingResult result) {

		try {
			ShipmentDao.create(s);
		}catch(Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/shipments/all");
	}

	@GetMapping("/shipments/delete/{shipmentid}")
	public ModelAndView shipmentDelete(@PathVariable int shipmentid) throws SQLException, IOException {

		ShipmentDao.delete(shipmentid);

		return new ModelAndView("redirect:/shipments/all");
	}

}

