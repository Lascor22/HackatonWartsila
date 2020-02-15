package com.blagoy.officemaps.domain;

public class PublicRoom extends ObjectMap {
    private PublicRoomType type;

    public PublicRoomType getType() {
        return type;
    }

    public void setType(PublicRoomType type) {
        this.type = type;
    }
}
