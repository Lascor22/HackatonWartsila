package com.blagoy.officemaps.domain;

public class Transition extends ObjectMap {
    private TransitionType type;

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }
}
