package org.codeus.three_layered_arch.dto;

import java.util.Set;

public record RoomDto(String roomName, Long ownerId, Set<Integer> clubberIds, String bookId,
                      String meetingUrl, String discussionBoardUrl) {

}