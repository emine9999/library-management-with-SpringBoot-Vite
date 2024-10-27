//package SpringBoot.library_management.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import java.util.List;
//
//@Entity
//@Table(name = "members")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Member {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    private String phone;
//
//    @Column(length = 500)
//    private String address;
//
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Loan> loans;
//
//    @Column(nullable = false)
//    private boolean active = true;
//
//    @Column(name = "membership_number", unique = true)
//    private String membershipNumber;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private java.util.Date registrationDate;
//
//    @PrePersist
//    protected void onCreate() {
//        registrationDate = new java.util.Date();
//    }
//}