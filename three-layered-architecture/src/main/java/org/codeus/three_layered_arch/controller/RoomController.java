package org.codeus.three_layered_arch.controller;

import org.codeus.three_layered_arch.controller.request.CreateRoomRequest;
import org.codeus.three_layered_arch.controller.response.RoomResponse;
import org.codeus.three_layered_arch.dto.RoomBasicData;
import org.codeus.three_layered_arch.service.impl.RoomServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
  private final RoomServiceImpl roomService;

  public RoomController(RoomServiceImpl roomService) {
    this.roomService = roomService;
  }

  @PostMapping
  public ResponseEntity<Long> createRoom(@RequestBody CreateRoomRequest request) {
    RoomBasicData roomBasicData = new RoomBasicData(request.roomName(), request.ownerId(), request.clubberIds(), request.bookId(),
      request.meetingUrl(), request.discussionBoardUrl());

    return ResponseEntity.ok(roomService.createRoom(roomBasicData));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoomResponse> getRoomById(@PathVariable Long id) {
    return roomService.getRoomById(id)
      .map(RoomResponse::from)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<RoomResponse>> getAllRooms() {
    return ResponseEntity.ok(roomService.getAllRooms().stream().map(RoomResponse::from).toList());
  }
}

