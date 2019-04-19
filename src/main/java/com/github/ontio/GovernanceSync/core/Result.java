package com.github.ontio.governancesync.core;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @JsonProperty("Action")
    public String action;

    @JsonProperty("Error")
    public Long error;

    @JsonProperty("Desc")
    public String desc;

    @JsonProperty("Version")
    public String version;

    @JsonProperty("Result")
    public Object result;
}
