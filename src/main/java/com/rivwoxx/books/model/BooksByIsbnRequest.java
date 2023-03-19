package com.rivwoxx.books.model;

// import jakarta.validation.Valid;
// import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Size;
//import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@Validated
public class BooksByIsbnRequest {

  @NotNull
  @NotEmpty
  @Size(min = 10,  max = 13, message = "ISBN VALUE MUST BE 10 OR 13 CHARACTERS.")
  private String isbn;
}
