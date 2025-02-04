package org.codeus.hexagonal.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.codeus.hexagonal.domain.usecase.CreateRoomUseCase;
import org.codeus.hexagonal.domain.usecase.GetRoomBatchUseCase;
import org.codeus.hexagonal.domain.usecase.GetRoomUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

  private final CreateRoomUseCase createRoomUseCase;
  private final GetRoomUseCase getRoomUseCase;
  private final GetRoomBatchUseCase getRoomBatchUseCase;

  @PostMapping
  public void mock() {
    //TODO 2: finish endpoints
    createRoomUseCase.createRoom(null);
    getRoomUseCase.getRoom(null);
    getRoomBatchUseCase.getAllRooms(null);
  }

}
