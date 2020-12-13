package com.example.NasaBase.api;

import com.example.NasaBase.model.SpaceVehicle;
import com.example.NasaBase.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/warehouse")
@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public void addVehicle(@RequestBody SpaceVehicle vehicle) {
        warehouseService.addVehicle(vehicle);
    }

    @GetMapping
    public List<SpaceVehicle> getAll() {
        return warehouseService.getAll();
    }

    @GetMapping(path = "{id}")
    public SpaceVehicle getVehicleById(@PathVariable("id") UUID id) {
        return warehouseService.getVehicleById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteVehicleById(@PathVariable("id") UUID id) {
        warehouseService.deleteVehicle(id);
    }

    @PutMapping(path = "{id}")
    public void updateVehicleByID(@PathVariable("id") UUID id, @RequestBody SpaceVehicle vehicle) {
        warehouseService.updateVehicle(id, vehicle);
    }
}
