package org.codeus.three_layered_arch.service.impl;

import org.codeus.three_layered_arch.dto.RoomDto;
import org.codeus.three_layered_arch.dto.RoomView;
import org.codeus.three_layered_arch.model.Room;
import org.codeus.three_layered_arch.repository.BookRepository;
import org.codeus.three_layered_arch.repository.ClubberRepository;
import org.codeus.three_layered_arch.repository.RoomRepository;
import org.codeus.three_layered_arch.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
  private final RoomRepository roomRepository;
  private final ClubberRepository clubberRepository;
  private final BookRepository bookRepository;

  public RoomServiceImpl(RoomRepository roomRepository, ClubberRepository clubberRepository, BookRepository bookRepository) {
    this.roomRepository = roomRepository;
    this.clubberRepository = clubberRepository;
    this.bookRepository = bookRepository;
  }

  public Long createRoom(RoomDto roomDto) {
    Room room = Room.builder()
      .name(roomDto.roomName())
      .owner(clubberRepository.getReferenceById(roomDto.ownerId()))
      .book(bookRepository.getReferenceById(roomDto.bookId()))
      .meetingUrl(roomDto.discussionBoardUrl())
      .discussionBoardUrl(roomDto.discussionBoardUrl())
      .build();

    return roomRepository.save(room).getId();
  }

  public Optional<RoomView> getRoomById(Long id) {
    return roomRepository.findById(id).map(this::mapRoomView);
  }

  public List<RoomView> getAllRooms() {
    return roomRepository.findAll().stream().map(this::mapRoomView).toList();
  }

  protected RoomView mapRoomView(Room room) {
    return new RoomView(
      room.getId(),
      room.getName(),
      room.getOwner(),
      room.getBook(),
      room.getCurrentChapter(),
      room.getNextPlannedChapter(),
      room.getMeetingUrl(),
      room.getDiscussionBoardUrl(),
      room.getClubbers()
    );
  }
}
