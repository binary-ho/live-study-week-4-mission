package com.binaryho.livestudyweek4mission.datastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ListNode<T> {

    private T data;
    private ListNode next;
    private ListNode prev;
}
