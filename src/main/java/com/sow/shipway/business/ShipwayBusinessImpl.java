package com.sow.shipway.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sow.shipway.dao.ShipwayDAO;
import com.sow.shipway.entity.Employee;

@Service
public class ShipwayBusinessImpl implements ShipwayBusiness {
	@Autowired
	private ShipwayDAO shipwayDAO;

	@Override
	public Optional<Employee> findById(Integer id) {
		// Optional<Employee> ee = shipwayDAO.findById(id);
		return shipwayDAO.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		return shipwayDAO.findAll();
	}

	@Override
	public boolean createNew(Employee employee) {
		try {
			shipwayDAO.save(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Employee employee) {
		try {
			shipwayDAO.save(employee);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			shipwayDAO.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
