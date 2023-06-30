package com.binaryho.livestudyweek4mission.dashbord.domain;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Issue {

    private final List<Comment> comments;
}
