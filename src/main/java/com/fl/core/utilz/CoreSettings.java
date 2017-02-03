package com.fl.core.utilz;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@Controller
public class CoreSettings {
    
    @Value("${path.for.upload.photo}")
    private String  pathForPhoto;
    
    @Value("${root.url.photo}")
    private String  rootUrlPhoto;
    
    @Value("${call.method.monitoring:false}")
    private Boolean monitoringEnabled;
    
}
