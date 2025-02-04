package org.codeus.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.codeus.hexagonal.*")
public class HexagonalBookClubApplication {

  public static void main(String[] args) {
    SpringApplication.run(HexagonalBookClubApplication.class, args);
  }

}
