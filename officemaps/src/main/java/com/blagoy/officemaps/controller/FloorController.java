package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.service.FloorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/0")
public class FloorController {


    private final FloorService floorService;
    private final ObjectMapController objectMapController;

    public FloorController(FloorService floorService, ObjectMapController objectMapController) {
        this.floorService = floorService;
        this.objectMapController = objectMapController;
    }

    @GetMapping("floor")
    public List<Floor> findAll() {
        return floorService.findAll();
    }

    @GetMapping("floor/{number}")
    public ObjectMap getRoom(@RequestParam("x") double x, @RequestParam("y") double y, @PathVariable("number") long number) {
        Floor floor = findByNumber(number);
        if (floor == null) {
            return null;
        }
        for (ObjectMap objectMap : floor.getObjectMaps()) {
            if (isCorrect(x, y, objectMap.getPoint(), objectMap.getWidth(), objectMap.getHeight())) {
                return objectMap;
            }
        }
        return null;
    }

    @GetMapping("floor/directions")
    public List<Point> getDirections(double firstX, double firstY, double secondX, double secondY, long number1, long number2) {
        ObjectMap firstRoom = getRoom(firstX, firstY, number1);
        ObjectMap secondRoom = getRoom(secondX, secondY, number2);
        Floor firstFloor = findByNumber(number1);
        List<ObjectMap> objectMaps = firstFloor.getObjectMaps();
        Collections.sort(objectMaps);
        List<Point> answer = new ArrayList<>();
        int n = objectMaps.size();
        double[] d = new double[n];
        for (int i = 0; i < n; ++i) {
            d[i] = Double.MAX_VALUE;
        }
        int[] p = new int[n];
        boolean[] used = new boolean[n];
        d[(int) firstRoom.getId()] = 0;
        for (ObjectMap objectMap1 : objectMaps) {
            int v = -1;
            for (int j = 0; j < n; ++j) {
                if (!used[j] && (v == -1 || d[j] < d[v])) {
                    v = j;
                }
            }
            if (d[v] == Double.MAX_VALUE) {
                break;
            }
            used[v] = true;
            for (ObjectMap objectMap : objectMap1.getNeighbors()) {
                int to = (int) objectMap.getId();
                double len = Math.sqrt(Math.pow(objectMap1.getPoint().getX() - objectMap.getPoint().getX(), 2) + Math.pow(objectMap1.getPoint().getY() - objectMap.getPoint().getY(), 2));
                if (d[(int) objectMap1.getId()] + len < d[to]) {
                    d[to] = d[(int) objectMap1.getId()] + len;
                    p[to] = (int) objectMap1.getId();
                }
            }
        }
        while (p[(int) secondRoom.getId()] != 0) {
            answer.add(secondRoom.getPoint());
            secondRoom = objectMapController.findById(secondRoom.getId());
        }
        answer.add(firstRoom.getPoint());
        Collections.reverse(answer);
        return answer;
    }

    private boolean isCorrect(double x, double y, Point point, double roomW, double roomH) {
        return (x <= point.getX() && x >= point.getX() - roomW && y <= point.getY() && y >= point.getY() - roomH);
    }

    @GetMapping("floor/{id}")
    public Floor findById(@PathVariable("id") long id) {
        return floorService.findById(id);
    }

    @GetMapping("floor/number/{number}")
    public Floor findByNumber(@PathVariable("number") long number) {
        return floorService.findByNumber(number);
    }
}
