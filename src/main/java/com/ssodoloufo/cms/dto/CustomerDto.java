package com.ssodoloufo.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
}
