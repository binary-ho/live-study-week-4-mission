package com.binaryho.livestudyweek4mission.dashbord.controller.response;

import com.binaryho.livestudyweek4mission.dashbord.domain.ParticipationInfo;
import java.util.List;
import lombok.Getter;

@Getter
public class ParticipationInfoResponse {

    private final List<ParticipationInfo> participationInfos;

    public ParticipationInfoResponse(List<ParticipationInfo> participationInfos) {
        this.participationInfos = participationInfos;
    }
}

