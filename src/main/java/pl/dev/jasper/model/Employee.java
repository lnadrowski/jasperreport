package pl.dev.jasper.model;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private Integer id;
    private String name;
    private String designation;
    private String department;
}
