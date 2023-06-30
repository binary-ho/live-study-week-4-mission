package com.binaryho.livestudyweek4mission.dashbord.service.port;

import com.binaryho.livestudyweek4mission.dashbord.domain.Issue;
import java.io.IOException;
import java.util.List;

public interface IssueFetcher {

    List<Issue> fetchAllIssue(String repositoryUrl) throws IOException;
}
