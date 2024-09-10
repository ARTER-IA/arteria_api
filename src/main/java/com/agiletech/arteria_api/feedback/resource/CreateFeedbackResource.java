package com.agiletech.arteria_api.feedback.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateFeedbackResource {

    @NotNull
    @NotBlank
    private String reasonForRemoval;

    @NotNull
    private Boolean contactUser;
}
