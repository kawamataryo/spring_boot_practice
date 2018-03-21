package com.example.demo.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SearchForm {
  @Min(0)
  @Max(150)
  @NotNull
  private int age;
}
