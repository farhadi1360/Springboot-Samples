package org.edu.farhadi.simplerelational.database.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductModel extends BaseModel<Long> {

    @NotNull
    @NotBlank
    private int code;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    private String owner;
    private boolean deleted;
}
