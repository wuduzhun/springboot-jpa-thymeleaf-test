package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "username",length = 200,nullable = true)
    private String username;
    @Column(name = "password",length = 200,nullable = true)
    private String password;
    @Column(name = "age",length = 6,nullable = true)
    private Integer age;
}
