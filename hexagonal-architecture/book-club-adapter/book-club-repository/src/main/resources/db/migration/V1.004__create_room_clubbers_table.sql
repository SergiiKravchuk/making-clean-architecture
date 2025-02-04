create table if not exists room_clubbers
(
    clubber_id bigint not null,
    room_id    bigint not null,
    primary key (clubber_id, room_id),
    constraint fk_room_clubbers_clubber foreign key (clubber_id) references clubber (id),
    constraint fk_room_clubbers_room foreign key (room_id) references room (id)
);


