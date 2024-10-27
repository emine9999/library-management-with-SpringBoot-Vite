// CategoryDTO.java
package SpringBoot.library_management.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}