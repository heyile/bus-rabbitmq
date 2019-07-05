package com.example.hystrixsingle;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = HystrixDashboardProperties.PREFIX)
public class HystrixDashboardProperties {

    public static final String PREFIX = "hystrix.dashboard";

    private TurbineProperties turbine = new TurbineProperties();

    public TurbineProperties getTurbine() {
        return turbine;
    }

    public void setTurbine(TurbineProperties turbine) {
        this.turbine = turbine;
    }

    public static class TurbineProperties {

        public static final String TURBINE_STREAM = "http://10.67.45.196:8878/turbine.stream";

        private String uri = TURBINE_STREAM;

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
}
