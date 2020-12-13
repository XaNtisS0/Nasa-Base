package com.example.NasaBase.dao;

import com.example.NasaBase.model.SpaceVehicle;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeHallDataAccessService implements WarehouseDao {

    private static List<SpaceVehicle> DB = new ArrayList<>();

    @Override
    public int insertVehicle(UUID id, SpaceVehicle vehicle) {
        DB.add(new SpaceVehicle(id, vehicle.getSize(), vehicle.getPrice()));
        return 0;
    }

    @Override
    public List<SpaceVehicle> getAll() {
        return Collections.unmodifiableList(DB);
    }

    @Override
    public Optional<SpaceVehicle> selectVehicleByID(UUID id) {
        return DB.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteVehicleById(UUID id) {
        Optional<SpaceVehicle> maybeVehicle = selectVehicleByID(id);
        if (maybeVehicle.isEmpty()) {
            return 0;
        }
        DB.remove(maybeVehicle.get());
        return 1;
    }

    @Override
    public int updateVehicleById(UUID id, SpaceVehicle vehicle) {
        return selectVehicleByID(id)
                .map(vehicle1 -> {
                    int indexOfVehicleToUpdate = DB.indexOf(vehicle);
                    if (indexOfVehicleToUpdate >= 0) {
                        DB.set(indexOfVehicleToUpdate, vehicle);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
