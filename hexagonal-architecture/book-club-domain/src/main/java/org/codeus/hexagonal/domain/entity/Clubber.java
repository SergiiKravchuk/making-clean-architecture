package org.codeus.hexagonal.domain.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clubber {
    private Long id;
    private String name;
    private Role role;
}
