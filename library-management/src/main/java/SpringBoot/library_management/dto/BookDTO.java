// BookDTO.java
package SpringBoot.library_management.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private Integer quantity;
    private Long categoryId;
}

