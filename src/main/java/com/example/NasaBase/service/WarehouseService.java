package com.example.NasaBase.service;

import com.example.NasaBase.dao.WarehouseDao;
import com.example.NasaBase.model.SpaceVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseService {

    private final WarehouseDao warehouseDao;

    @Autowired
    public WarehouseService(@Qualifier("fakeDao") WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    public int addVehicle(SpaceVehicle vehicle) {
        return warehouseDao.insertVehicle(vehicle);
    }

    public List<SpaceVehicle> getAll () {
        return Collections.unmodifiableList(warehouseDao.getAll());
    }

    public Optional<SpaceVehicle> getVehicleById(UUID id) {
        return warehouseDao.selectVehicleByID(id);
    }

    public int deleteVehicle(UUID id) {
        return warehouseDao.deleteVehicleById(id);
    }

    public int updateVehicle(UUID id, SpaceVehicle vehicle) {
        return warehouseDao.updateVehicleById(id, vehicle);
    }
}
