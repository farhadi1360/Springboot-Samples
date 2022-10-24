package org.edu.farhadi.simplerelational.database.apis.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.edu.farhadi.simplerelational.database.apis.LogicalDeletedRestController;
import org.edu.farhadi.simplerelational.database.models.StationModel;
import org.edu.farhadi.simplerelational.database.services.LogicalDeletedService;
import org.edu.farhadi.simplerelational.database.services.StationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@Tag(name = "Station Rest Service v1")
@RequestMapping(value = "/api/v1/station")
@Validated
public class StationRestController extends BaseRestControllerImpl<StationModel, Long> implements LogicalDeletedRestController<Long> {

    private StationService stationService;

    public StationRestController(StationService service) {
        super(service, StationModel.class);
        this.stationService = service;
    }

    @GetMapping(value = {"/findAllByLocation/{latitude}/{longitude}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<StationModel>> findAllByLocation(
            @PathVariable("latitude") @Min(value = -90) @Max(value = 90) double latitude
            , @PathVariable("longitude") @Min(value = -180) @Max(value = 180) double longitude
            , @RequestParam(value = "companyId", required = false) Long companyId
    ) {
        return ResponseEntity.ok(stationService.findAllByLocation(companyId, latitude, longitude));
    }

    @Override
    public LogicalDeletedService<Long> getService() {
        return stationService;
    }
}
