package org.codeus.three_layered_arch.dto;

import java.util.Set;

public record RoomBasicData(String roomName, Long ownerId, Set<Long> clubberIds, String bookId) {

}