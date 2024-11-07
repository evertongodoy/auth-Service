package br.senac.sp.authorization.entrypoint.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    @NotBlank(message = "O número de celular é obrigatório")
    @Pattern(regexp = "^\\+\\d{1,3}\\d{8,13}$", message = "Formato inválido. Ex: +5511999999999")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

}
