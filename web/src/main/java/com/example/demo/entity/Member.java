package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member{
   @Id
   @Column(name="id")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer id;
 
   @Column(name="name")
   @NotEmpty(message = "名前を入力してください")
   private String name;
 
   @Column(name="age")
   @NotNull(message = "年齢を入力してください")
   private Integer age;
}
