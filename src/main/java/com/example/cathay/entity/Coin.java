package com.example.cathay.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String code;

    @Column
    String name;

    @Column
    Date createTime;
}
