package com.sow.shipway.business;

import java.util.List;
import java.util.Optional;

import com.sow.shipway.entity.Employee;

public interface ShipwayBusiness {
	Optional<Employee> findById(Integer id);

	List<Employee> getAll();

	boolean createNew(Employee employee);

	boolean update(Employee employee);

	boolean delete(int id);
}
