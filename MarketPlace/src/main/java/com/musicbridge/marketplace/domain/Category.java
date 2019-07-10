package com.musicbridge.marketplace.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Category")
@NoArgsConstructor

public class Category {

    @Id
    Integer id;
    String name;
}
