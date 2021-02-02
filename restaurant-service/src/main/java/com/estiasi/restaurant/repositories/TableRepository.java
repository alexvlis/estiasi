package com.estiasi.restaurant.repositories;

import com.estiasi.restaurant.model.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<Table, Integer> {

    List<Table> findByCapacity(int capacity);

    List<Table> findByZone(String zone);

    List<Table> findBySmoking(boolean smoking);

    List<Table> findByOutdoor(boolean outdoor);

}
