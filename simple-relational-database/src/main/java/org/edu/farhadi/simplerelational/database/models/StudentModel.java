package org.edu.farhadi.simplerelational.database.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class StudentModel extends BaseModel<Long>{
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private int age;
    private String family;
    private String address;

}
