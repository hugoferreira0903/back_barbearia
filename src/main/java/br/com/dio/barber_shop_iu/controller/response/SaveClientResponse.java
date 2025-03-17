package br.com.dio.barber_shop_iu.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SaveClientResponse(

        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("email")
        String email,
        @JsonProperty("phone")
        String phone

) {
}
