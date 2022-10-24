package org.edu.farhadi.simplerelational.database.apis.impl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.edu.farhadi.simplerelational.database.apis.LogicalDeletedRestController;
import org.edu.farhadi.simplerelational.database.models.CompanyModel;
import org.edu.farhadi.simplerelational.database.models.StudentModel;
import org.edu.farhadi.simplerelational.database.services.CompanyService;
import org.edu.farhadi.simplerelational.database.services.LogicalDeletedService;
import org.edu.farhadi.simplerelational.database.validation.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Company Rest Service v1")
@RequestMapping(value = "/api/v1/company")
public class CompanyRestController extends BaseRestControllerImpl<CompanyModel, Long> implements LogicalDeletedRestController<Long> {

    private CompanyService companyService;

    public CompanyRestController(CompanyService service) {
        super(service, CompanyModel.class);
        this.companyService = service;
    }


    @PatchMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<CompanyModel> customUpdate(@Validated(Update.class) @RequestBody CompanyModel model) {
        return ResponseEntity.ok(companyService.save(model));
    }

    @Override
    public LogicalDeletedService<Long> getService() {
        return companyService;
    }
}
