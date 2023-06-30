package com.binaryho.livestudyweek4mission.dashbord.service;

import com.binaryho.livestudyweek4mission.dashbord.domain.Comment;
import com.binaryho.livestudyweek4mission.dashbord.domain.Issue;
import com.binaryho.livestudyweek4mission.dashbord.domain.ParticipationInfo;
import com.binaryho.livestudyweek4mission.dashbord.service.port.IssueFetcher;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private IssueFetcher issueFetcher;

    public DashboardService(IssueFetcher issueFetcher) {
        this.issueFetcher = issueFetcher;
    }

    public List<ParticipationInfo> getParticipationRates(String repositoryUrl) throws IOException {
        List<Issue> issues = issueFetcher.fetchAllIssue(repositoryUrl);
        final int issueCount = issues.size();

        return countUserComment(issues)
            .entrySet().stream()
            .map(entry -> new ParticipationInfo(entry.getKey(), (double) entry.getValue() / issueCount))
            .collect(Collectors.toList());
    }

    private Map<String, Integer> countUserComment(List<Issue> issues) {
        Map<String, Integer> userParticipation = new HashMap<>();

        issues.stream()
            .flatMap(issue -> issue.getComments().stream())
            .map(Comment::getWriter)
            .forEach(writer -> {
                int count = userParticipation.getOrDefault(writer, 0);
                userParticipation.put(writer, count + 1);
            });
        return userParticipation;
    }
}
