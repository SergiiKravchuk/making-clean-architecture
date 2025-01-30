package org.codeus.three_layered_arch.controller;

import org.codeus.three_layered_arch.dto.RoomDto;
import org.codeus.three_layered_arch.dto.RoomView;
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
    RoomDto roomDTO = new RoomDto(request.roomName(), request.ownerId(), request.clubberIds(), request.bookId(),
      request.meetingUrl(), request.discussionBoardUrl());

    return ResponseEntity.ok(roomService.createRoom(roomDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RoomView> getRoomById(@PathVariable Long id) {
    return roomService.getRoomById(id)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<RoomView>> getAllRooms() {
    return ResponseEntity.ok(roomService.getAllRooms());
  }
}

