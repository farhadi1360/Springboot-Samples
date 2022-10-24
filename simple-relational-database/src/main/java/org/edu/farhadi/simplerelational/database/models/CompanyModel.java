package org.edu.farhadi.simplerelational.database.models;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
public class CompanyModel extends BaseModel<Long> {

    @NotNull
    @NotBlank
    private String name;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<StationModel> stationList;
//    private Set<ProductEntity> products;
}
