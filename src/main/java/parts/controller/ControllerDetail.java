package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import parts.services.ServiceClassDetail;

@Controller
public class ControllerDetail {
    private ServiceClassDetail serviceClassDetail;

    @Autowired (required = true)
    @Qualifier (value = "serviceClassDetail")
    public void setServiceClassDetail(ServiceClassDetail serviceClassDetail){
        this.serviceClassDetail = serviceClassDetail;
    }



}
