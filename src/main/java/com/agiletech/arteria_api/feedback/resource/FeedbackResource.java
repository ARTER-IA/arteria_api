package com.agiletech.arteria_api.feedback.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackResource {

    private Long id;
    private String reasonForRemoval;
    private Boolean contactUser;
    private Long doctorId;
}
