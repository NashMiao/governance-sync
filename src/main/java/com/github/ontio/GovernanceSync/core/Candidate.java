package com.github.ontio.governancesync.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Candidate {
    int SwapState;
    String Introduce;
    String OntAddress;
    String PublicKey;
    Long CreateTime;
    String Region;
    String Balance;
    String Name;
    String Logo;
}
