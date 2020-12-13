package com.example.NasaBase.dao;

import com.example.NasaBase.model.SpaceVehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WarehouseDao {
    int insertVehicle(UUID id, SpaceVehicle vehicle);

    default int insertVehicle(SpaceVehicle vehicle) {
        UUID id = UUID.randomUUID();
        return insertVehicle(id, vehicle);
    }

    List<SpaceVehicle> getAll();

    Optional<SpaceVehicle> selectVehicleByID(UUID id);

    int deleteVehicleById(UUID id);

    int updateVehicleById(UUID id, SpaceVehicle vehicle);
}
