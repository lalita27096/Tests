package com.team22.backend.Entity;
import lombok.*;
import java.time.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Customer")
public class Customer {
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_seq")
    @Column(name="Customer_ID",unique = true, nullable = false)
  
    private @NonNull Long cusId;
    private @NonNull String customerName;
    private @NonNull String customerIDs;
    private @NonNull String customerAddress;
    private @NonNull String customerPassword;
    private @NonNull String customerPhone;
    private @NonNull String customerGender;
    private @NonNull LocalDate customerBirthday;


}