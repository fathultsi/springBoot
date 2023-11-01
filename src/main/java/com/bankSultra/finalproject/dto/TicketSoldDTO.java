package com.bankSultra.finalproject.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TicketSoldDTO {

//    @NotEmpty(message = "{title.empty}")
    private Long ticket_id;

//    @NotEmpty(message = "{status.empty}")
//    private Long tripSchedule_id;


}
