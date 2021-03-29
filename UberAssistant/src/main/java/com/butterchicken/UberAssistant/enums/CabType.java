package com.butterchicken.UberAssistant.enums;

import lombok.Getter;

@Getter
public enum CabType {
    GO("Uber Go", 0),
    BLACK("Uber Black", 1);

    private String cabTypeString;
    private Integer cabTypeCode;

    CabType(String cabTypeString, Integer cabTypeCode) {
        this.cabTypeString = cabTypeString;
        this.cabTypeCode = cabTypeCode;
    }
}
