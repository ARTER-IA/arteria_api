package com.agiletech.arteria_api.doctor.domain.service.communication;

import com.agiletech.arteria_api.doctor.resource.AuthenticateDoctorResource;
import com.agiletech.arteria_api.shared.domain.service.communication.BaseResponse;

public class AuthenticateDoctorResponse extends BaseResponse<AuthenticateDoctorResource> {

    public AuthenticateDoctorResponse(String message){
        super(message);
    }

    public AuthenticateDoctorResponse(AuthenticateDoctorResource resource) {
        super(resource);
    }
}
