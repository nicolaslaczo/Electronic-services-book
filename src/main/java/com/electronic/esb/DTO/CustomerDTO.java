package com.electronic.esb.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer phoneNum;
    private String email;
    private String city;
    private String street;
    private Integer houseNum;
}
