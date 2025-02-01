package org.codeus.three_layered_arch.controller.response;

import org.codeus.three_layered_arch.controller.view.BookView;
import org.codeus.three_layered_arch.controller.view.ClubberView;
import org.codeus.three_layered_arch.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public record RoomResponse(Long roomId, String roomName, ClubberView roomOwner,
                           BookView book, int currentChapter, int nextPlannedChapter,
                           String meetingUrl, String discussionBoardUrl,
                           Set<ClubberView> clubbers) {

  public static RoomResponse from(Room room) {
    return new RoomResponse(
      room.getId(),
      room.getName(),
      ClubberView.from(room.getOwner()),
      BookView.from(room.getBook()),
      room.getCurrentChapter(),
      room.getNextPlannedChapter(),
      room.getMeetingUrl(),
      room.getDiscussionBoardUrl(),
      room.getClubbers().stream().map(ClubberView::from).collect(Collectors.toSet())
    );
  }
}
