package com.example.restApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String usertype;
}
