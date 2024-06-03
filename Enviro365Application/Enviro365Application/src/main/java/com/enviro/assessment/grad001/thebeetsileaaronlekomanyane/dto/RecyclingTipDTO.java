package com.enviro.assessment.grad001.thebeetsileaaronlekomanyane.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RecyclingTipDTO {
    @NotNull
    private String tip;
}
