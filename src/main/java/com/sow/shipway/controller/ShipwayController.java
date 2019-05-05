package com.sow.shipway.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sow.shipway.business.ShipwayBusinessImpl;
import com.sow.shipway.common.Constant;
import com.sow.shipway.common.Response;
import com.sow.shipway.entity.Employee;

@Controller
@RequestMapping("/employee")
public class ShipwayController {

	@Autowired
	private ShipwayBusinessImpl shipwayBusiness;

	/*
	 * @RequestMapping(value = "/testFind", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseBody public ResponseEntity<Object> upload(@RequestParam("id") int
	 * id) { return new ResponseEntity<Object>(shipwayBusiness.findById(id),
	 * HttpStatus.OK); }
	 */
	@RequestMapping(value = "/testFind", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> upload(@RequestParam("id") int id) {
		Response<Object> response = new Response<>();
		Optional<Employee> employee = shipwayBusiness.findById(id);
		if (employee == null) {
			response.setStatus(Constant.RESULT.ERROR);
			response.setMessage("Khong co ket qua!");
		} else {
			response.setData(employee);
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAll() {
		Response<Object> response = new Response<>();
		List<Employee> employee = shipwayBusiness.getAll();
		if (employee == null) {
			response.setStatus(Constant.RESULT.ERROR);
			response.setMessage("Khong co ket qua!");
		} else {
			response.setData(employee);
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/createNew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> createNew(@RequestParam("name") String name,
			@RequestParam("address") String address) {
		Response<Object> response = new Response<>();
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAddress(address);
		boolean createNew = shipwayBusiness.createNew(employee);
		if (!createNew) {
			response.setStatus(Constant.RESULT.ERROR);
			response.setMessage("Lỗi khi thêm mới!");
		} else {
			response.setMessage("Thêm mới thành công!");
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> update(@RequestParam(required = true) int id, @RequestParam("name") String name,
			@RequestParam("address") String address) {
		Response<Object> response = new Response<>();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAddress(address);
		boolean update = shipwayBusiness.createNew(employee);
		if (!update) {
			response.setStatus(Constant.RESULT.ERROR);
			response.setMessage("Lỗi khi cập nhật!");
		} else {
			response.setMessage("Cập nhật thành công!");
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> delete(@RequestParam(required = true) int id) {
		Response<Object> response = new Response<>();
		boolean delete = shipwayBusiness.delete(id);
		if (!delete) {
			response.setStatus(Constant.RESULT.ERROR);
			response.setMessage("Lỗi khi xóa!");
		} else {
			response.setMessage("Xóa thành công!");
		}
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
