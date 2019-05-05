package com.sow.shipway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sow.shipway.entity.Employee;

@Repository
public interface ShipwayDAO extends JpaRepository<Employee, Integer> {

}
