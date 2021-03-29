package com.butterchicken.UberAssistant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RideDto {

    private Integer userId;

    private LatLong source;

    private LatLong destination;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LatLong{

        public Double latitude;

        public Double longitude;

    }

    private Double fare;

    private Date startTime;

    private Date endTime;

    private Integer cabTypeCode;

    private PaymentInfo paymentInfo;

    @Data
    public static class PaymentInfo{

        public Integer paymentTypeCode;

        public String paymentId;

    }

}
