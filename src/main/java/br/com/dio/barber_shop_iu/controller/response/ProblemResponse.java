package br.com.dio.barber_shop_iu.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mapstruct.Builder;

import java.time.OffsetDateTime;

public record ProblemResponse(

        @JsonProperty("status")
        Integer status,
        @JsonProperty("timestamp")
        OffsetDateTime timestamp,
        @JsonProperty("message")
        String message

) {



}
