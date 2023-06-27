package com.bookpublication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is used to transfer data between the service layer and the controller layer.
 * It is used to transfer data related to the Author entity.
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
}
