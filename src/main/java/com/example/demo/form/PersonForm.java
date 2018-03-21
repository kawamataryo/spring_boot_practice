package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
public class PersonForm {
  @NonNull
  @Size(max = 31)
  private String name;

  @Min(0)
  @Max(150)
  @NonNull
  private Integer age;
}
