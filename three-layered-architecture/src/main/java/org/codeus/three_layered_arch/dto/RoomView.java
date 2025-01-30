package org.codeus.three_layered_arch.dto;

import org.codeus.three_layered_arch.model.Book;
import org.codeus.three_layered_arch.model.Clubber;

import java.util.Set;

public record RoomView(Long roomId, String roomName, Clubber roomOwner,
                       Book book, int currentChapter, int nextPlannedChapter,
                       String meetingUrl, String discussionBoardUrl,
                       Set<Clubber> clubbers) {
}
