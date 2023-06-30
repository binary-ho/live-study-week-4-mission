package com.binaryho.livestudyweek4mission.dashbord.controller;

import com.binaryho.livestudyweek4mission.dashbord.controller.response.ParticipationInfoResponse;
import com.binaryho.livestudyweek4mission.dashbord.domain.ParticipationInfo;
import com.binaryho.livestudyweek4mission.dashbord.service.DashboardService;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final DashboardService dashboardService;

    @GetMapping("/{user}/{repository}")
    public ResponseEntity<ParticipationInfoResponse> getGithubRepositoryUserParticipationInfo(
        @PathVariable("user") String user,
        @PathVariable("repository") String repository) throws IOException {

        final String targetUrl = user + "/" + repository;
        System.out.println(targetUrl);
        List<ParticipationInfo> participationRates = dashboardService
            .getParticipationRates(targetUrl);

        return ResponseEntity
            .ok()
            .body(new ParticipationInfoResponse(participationRates));
    }
}
