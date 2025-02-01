package org.codeus.three_layered_arch.service.impl;

import lombok.RequiredArgsConstructor;
import org.codeus.three_layered_arch.dto.RoomBasicData;
import org.codeus.three_layered_arch.model.Room;
import org.codeus.three_layered_arch.repository.ClubberRepository;
import org.codeus.three_layered_arch.repository.RoomRepository;
import org.codeus.three_layered_arch.service.BookService;
import org.codeus.three_layered_arch.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomRepository roomRepository;
  private final ClubberRepository clubberRepository;
  private final BookService bookService;//FIXME: using service in another service should be avoided

  public Long createRoom(RoomBasicData roomBasicData) {
    Room room = Room.builder()
      .name(roomBasicData.roomName())
      .owner(clubberRepository.getReferenceById(roomBasicData.ownerId()))
      .book(bookService.getBook(roomBasicData.bookId()))
      .meetingUrl(roomBasicData.meetingUrl())
      .discussionBoardUrl(roomBasicData.discussionBoardUrl())
      .clubbers(roomBasicData.clubberIds().stream().map(clubberRepository::getReferenceById).collect(Collectors.toSet()))
      .build();

    return roomRepository.save(room).getId();
  }

  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findById(id);
  }

  public List<Room> getAllRooms() {
    return roomRepository.findAll();
  }
}
