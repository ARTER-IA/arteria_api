package com.agiletech.arteria_api.doctor.domain.service.communication;

import com.agiletech.arteria_api.doctor.resource.DoctorResource;
import com.agiletech.arteria_api.shared.domain.service.communication.BaseResponse;

public class RegisterDoctorResponse extends BaseResponse<DoctorResource> {
    public RegisterDoctorResponse(String message){
        super(message);
    }

    public RegisterDoctorResponse(DoctorResource resource){
        super(resource);
    }
}
