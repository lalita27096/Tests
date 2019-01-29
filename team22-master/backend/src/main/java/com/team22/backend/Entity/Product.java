package com.team22.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Product") //ชื่อตาราง
public class Product {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="product_seq",sequenceName="product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seq")
    @Column(name="Products_ID",unique = true, nullable = false)

    private @NonNull Long prodId;
    @Pattern(regexp = "[P]\\d")
    private @NonNull String productIds;
    
    @Size(min=3 ,max=10)
    private @NonNull String productName;

    private @NonNull Integer productQuantity;
    private @NonNull Date productDate;
    private @NonNull Integer productPrice ;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "typeIds", insertable = true)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Status.class)
    @JoinColumn(name = "stateId", insertable = true)
    private Status status;


}