package javaPrograms.Lombook;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {

  private String name;
  private int age;
  private String address;
}
