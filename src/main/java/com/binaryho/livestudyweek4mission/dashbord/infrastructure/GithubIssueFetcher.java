package com.binaryho.livestudyweek4mission.dashbord.infrastructure;

import static org.kohsuke.github.GHIssueState.ALL;

import com.binaryho.livestudyweek4mission.dashbord.domain.Comment;
import com.binaryho.livestudyweek4mission.dashbord.domain.Issue;
import com.binaryho.livestudyweek4mission.dashbord.service.port.IssueFetcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GithubIssueFetcher implements IssueFetcher {

    @Value("${token.github}")
    private String token;

    @Override
    public List<Issue> fetchAllIssue(String repositoryUrl) throws IOException {
//        String token = "";
        GitHub gitHub = new GitHubBuilder().withOAuthToken(token).build();
        GHRepository repo = gitHub.getRepository(repositoryUrl);

        List<Issue> issues = new ArrayList<>();
        for (var issue : repo.getIssues(ALL)) {
//            System.out.println(issue.getHtmlUrl());

            if (isExceptionOccurred(issue) || issue.isPullRequest()) {
                System.out.println("pass");
                continue;
            }
//            System.out.println("commit");
            issues.add(createIssue(issue));
        }
        return issues;
    }

    private Issue createIssue(GHIssue ghIssue) throws IOException {
        List<Comment> comments = new ArrayList<>();
        for (var comment : ghIssue.getComments()) {
//            System.out.println("[COMMENT] " + comment.getHtmlUrl());
            if (isExceptionOccurred(comment)) {
                System.out.println("pass");
                continue;
            }
//            System.out.println("commit");
//            System.out.println(comment.getUser().getLogin());
            comments.add(new Comment(comment.getUser().getLogin()));
        }
        return new Issue(comments);
    }

    private boolean isExceptionOccurred(GHIssueComment comment) {
        try {
            comment.getUser().getLogin();
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    private boolean isExceptionOccurred(GHIssue ghIssue) {
        try {
            ghIssue.getComments();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
