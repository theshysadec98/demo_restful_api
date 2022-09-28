package com.example.demo.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone", nullable = false, length = 100)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Instant dateOfBirth;

    @Column(name = "gender")
    public String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "status", length = 100)
    private String status;

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @CreatedBy
    @Column(name = "create_by", nullable = false)
    private String createBy;

    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updateDate;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;
}
