/**
 * 
 */
package com.fullstack.employee.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fullstack.employee.entity.Employee;
import com.fullstack.employee.service.EmployeeService;

/**
 * *@author BUJAIR
 *
 */
@Controller
@EnableAutoConfiguration
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private String[] pathsList = new String[] { "modify", "delete", "save" };

	@RequestMapping("/loadEmployees")
	public ModelAndView listEmployees() {
		ModelAndView mav = new ModelAndView("listEmployees");
		List<Employee> empList = employeeService.listEmployees();
		// System.out.println("******************* emp list : " + empList);
		mav.addObject("empList", empList);
		mav.addObject("empid", empList.get(0).getId());
		return mav;
	}

	/*
	 * @RequestMapping("/{path}/{id}") public ModelAndView
	 * redirectPath(@PathVariable String path) { if (null != path &&
	 * Arrays.asList(pathsList).contains(path)) { return new ModelAndView(path); }
	 * else { return new ModelAndView("techDiff"); } }
	 */

	@RequestMapping(path = "/viewEmp", method = RequestMethod.GET)
	public ModelAndView getEmployeeToEdit(@RequestParam(value = "id") String id,
			@RequestParam(value = "e") String activity) {
		if (Arrays.asList(pathsList).contains(activity)) {
			ModelAndView mav = new ModelAndView("viewEmployee");
			mav.addObject("activity", activity);
			if (activity.equals("save")) {
				return mav;
			}
			Employee emp = getEmployeeFromAll(id);
			if (id != null && null != emp) {

				mav.addObject("employee", emp);
				return mav;
			}
		} else
			return new ModelAndView("techDiff");

		return null;
	}

	private Employee getEmployeeFromAll(String id) {
		Optional<Employee> optional = employeeService.listEmployees().stream()
				.filter(x -> Long.parseLong(id) == x.getId()).findFirst();
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@RequestMapping(path = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:loadEmployees");
	}

	@RequestMapping(path = "/modifyEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("******************* Update employee : " + employee);
		employeeService.updateEmployee(employee);
		return new ModelAndView("redirect:loadEmployees");
	}

}
