package org.codeus.hexagonal.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

// aka RoomGateway
public interface RoomRepository {

  record DbRoom(Long id, String name, Long ownerId, Set<Long> clubberIds, String bookId) {

    public DbRoom(String roomName, Long ownerId, Set<Long> clubberIds, String bookId) {
      this(null, roomName, ownerId, clubberIds, bookId);
    }
  }

  Long save(DbRoom room);

  Optional<DbRoom> getRoomById(Long id);

  Optional<DbRoom> getRoomByBookIsbn(String isbn);

  List<DbRoom> getAllRooms();
}
