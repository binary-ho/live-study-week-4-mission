package com.binaryho.livestudyweek4mission.dashbord.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParticipationInfo {

    private final String writer;
    private final Double participationRate;
}
