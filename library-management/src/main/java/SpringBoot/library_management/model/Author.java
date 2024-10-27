//package SpringBoot.library_management.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.util.List;
//
//@Entity
//@Table(name = "authors")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Author {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(unique = true)
//    private String email;
//
//    @Column(length = 2000)
//    private String biography;
//
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    private List<Book> books;
//}
