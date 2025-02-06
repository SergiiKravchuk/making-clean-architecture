package org.codeus.hexagonal.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.domain.usecase.CreateRoomUseCase;
import org.codeus.hexagonal.domain.usecase.GetRoomBatchUseCase;
import org.codeus.hexagonal.domain.usecase.GetRoomUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

  private final CreateRoomUseCase createRoomUseCase;
  private final GetRoomUseCase getRoomUseCase;
  private final GetRoomBatchUseCase getRoomBatchUseCase;

  @PostMapping
  //TODO: consider/discuss benefits of using another DTO e.g. public record RoomCreated(Long id) {} (at least, API related annotations can be applied to it)
  public ResponseEntity<RoomCreated> createRoom(@RequestBody CreateRoomUseCase.Request request) {
    return ResponseEntity.ok(new RoomCreated(createRoomUseCase.createRoom(request).roomId()));
  }
  public record RoomCreated(Long id) {}

  @GetMapping("/{roomId}")
  public ResponseEntity<RoomView> getRoom(@PathVariable("roomId") Long roomId) {
    return getRoomUseCase.getRoom(new GetRoomUseCase.Request(roomId))
      .map(RoomView::from)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }
  public record RoomView(Long roomId, String roomName, Long ownerId, Set<Long> clubberIds, String bookIsbn) {
    public static RoomView from(GetRoomUseCase.Response response) {
      return new RoomView(
        response.roomId(),
        response.roomName(),
        response.ownerId(),
        response.clubberIds(),
        response.bookIsbn()
      );
    }
  }


  @GetMapping
  public ResponseEntity<GetRoomBatchUseCase.Response> getAllRooms() {
    return ResponseEntity.ok(getRoomBatchUseCase.getAllRooms(new GetRoomBatchUseCase.Request()));
  }
}
