package com.github.ontio.governancesync.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "config")
public class ParamsConfig {

    @Value("${config.main.node}")
    public String MAIN_NODE;

    @Value("${config.polaris.node}")
    public String TEST_NODE;

    @Value("${config.candidate.info}")
    public String CANDIDATE_INFO;

}
