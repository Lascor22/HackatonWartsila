package com.blagoy.officemaps.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ObjectMap {
    @Id
    @GeneratedValue
    private long id;

    private Floor floor;


}
