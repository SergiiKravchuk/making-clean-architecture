package org.codeus.three_layered_arch.controller;

import java.util.Set;

public record CreateRoomRequest(String roomName, Long ownerId, Set<Integer> clubberIds, String bookId,
                                       String meetingUrl, String discussionBoardUrl) {}