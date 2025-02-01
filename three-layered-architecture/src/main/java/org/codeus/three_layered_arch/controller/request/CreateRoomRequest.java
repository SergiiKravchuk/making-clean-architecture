package org.codeus.three_layered_arch.controller.request;

import java.util.Set;

public record CreateRoomRequest(String roomName, Long ownerId, Set<Long> clubberIds, String bookId,
                                String meetingUrl, String discussionBoardUrl) {}