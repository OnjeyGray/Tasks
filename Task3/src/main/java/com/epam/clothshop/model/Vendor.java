package com.epam.clothshop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "vendor_table")
public class Vendor {

    @Id
    @SequenceGenerator(name = "vendor_seq_gen", sequenceName = "vendor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_seq_gen")
    @Column(name = "vendor_id")
    Long id;

    @Column(name = "vendor_name")
    String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vendor_product_table",
            joinColumns = @JoinColumn(name = "vendor_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_fk"))
    List<Product> products = new ArrayList<>();

}
