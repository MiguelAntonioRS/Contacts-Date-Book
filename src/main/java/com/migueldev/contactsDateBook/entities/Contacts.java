package com.migueldev.contactsDateBook.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo vacio: Ingrese su nombre")
    private String name;

    @NotEmpty(message = "Campo vacio: Ingrese su email")
    @Email
    private String email;

    @NotBlank(message = "Campo vacio: Ingrese su # de celular")
    private String phone;

    @DateTimeFormat(iso = ISO.DATE)
    @Past
    @NotNull(message = "Ingrese correctamente su fecha de nacimiento")
    private LocalDate bornDate;

    private LocalDateTime registryDate;

    @PrePersist
    public void setRegistryDate() {
        registryDate = LocalDateTime.now();
    }
}
