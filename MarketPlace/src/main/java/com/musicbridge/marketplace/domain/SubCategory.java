package com.musicbridge.marketplace.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "SubCategory")

public class SubCategory {

    @Id
    Integer id;

    String name;
    
    Integer categoryId;
}
