package br.com.dio.barber_shop_iu.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ScheduleAppointmentMonthResponse(

        @JsonProperty("year")
        int year,
        @JsonProperty("month")
        int month,
        List<ClientScheduleAppointmentResponse> scheduledAppointments

) {
}
