package com.musicbridge.marketplace.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "Condition")
public class Condition {

    @Id
    Integer id;
    String name;
}
