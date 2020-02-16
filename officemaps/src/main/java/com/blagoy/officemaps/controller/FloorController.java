package com.blagoy.officemaps.controller;

import com.blagoy.officemaps.domain.*;
import com.blagoy.officemaps.service.FloorService;
import com.blagoy.officemaps.service.ObjectMapService;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/0")
public class FloorController {


    private final FloorService floorService;
    private final ObjectMapService objectMapService;

    public FloorController(FloorService floorService, ObjectMapService objectMapService) {
        this.floorService = floorService;
        this.objectMapService = objectMapService;
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

    private double getDist(ObjectMap first, ObjectMap second) {
        Point firstPoint, secondPoint;
        if (first instanceof Transition) {
            firstPoint = first.getPoint();
        } else {
            firstPoint = getPointFromDoor(first.getDoors().get(0));
        }
        if (second instanceof Transition) {
            secondPoint = second.getPoint();
        } else {
            secondPoint = getPointFromDoor(second.getDoors().get(0));
        }

        if (firstPoint.getX() == secondPoint.getX() && firstPoint.getY() == secondPoint.getY() && first.getId() != second.getId()) {
            return 200.0;
        }
        return Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) + Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
    }

    @GetMapping("floor/directions")
    public ClosestWay getDirections(@RequestParam("firstX") double firstX, @RequestParam("firstY") double firstY,
                                    @RequestParam("secondX") double secondX, @RequestParam("secondY") double secondY,
                                    @RequestParam("number1") long number1, @RequestParam("number2") long number2) {
        ObjectMap firstRoom = getRoom(firstX, firstY, number1);
        ObjectMap secondRoom = getRoom(secondX, secondY, number2);
        Floor firstFloor = findByNumber(number1);
        List<ObjectMap> objectMaps = firstFloor.getObjectMaps();
        if (number1 != number2) {
            objectMaps.addAll(floorService.findByNumber(number2).getObjectMaps());
        }
        Collections.sort(objectMaps);
        List<Point> points = new ArrayList<>();
        HashMap<Long, Double> d = new HashMap<>();
        for (ObjectMap objectMap : objectMaps) {
            d.put(objectMap.getId(), Double.MAX_VALUE);
        }
        HashMap<Long, Long> p = new HashMap<>();
        HashMap<Long, Boolean> used = new HashMap<>();
        d.put(firstRoom.getId(), 0.0);
        double distance = 0;
        for (ObjectMap objectMap1 : objectMaps) {
            long v = -1;
            for (ObjectMap obj : objectMaps) {
                if (!used.get(obj.getId()) && (v == -1 || d.get(obj.getId()) < d.get(v))) {
                    v = obj.getId();
                }
            }
            if (d.get(v) == Double.MAX_VALUE) {
                break;
            }
            used.put(v, true);
            for (ObjectMap objectMap : objectMap1.getNeighbors()) {
                long to = objectMap.getId();
                double len = getDist(objectMap1, objectMap);
                if (d.get(objectMap1.getId()) + len < d.get(to)) {
                    d.put(to, d.get(objectMap1.getId()) + len);
                    p.put(to, objectMap1.getId());
                }
            }
        }
        while (p.containsKey(secondRoom.getId())) {
            ObjectMap parentRoom = objectMapService.findById(secondRoom.getId());
            distance += getDist(secondRoom, parentRoom);
            points.add(secondRoom instanceof Transition? secondRoom.getPoint() : getPointFromDoor(secondRoom.getDoors().get(0)));
            secondRoom = parentRoom;
        }
        points.add(firstRoom instanceof Transition? firstRoom.getPoint() : getPointFromDoor(firstRoom.getDoors().get(0)));
        Collections.reverse(points);
        ClosestWay closestWay = new ClosestWay();
        closestWay.setDistance(distance);
        closestWay.setPoints(points);
        return closestWay;
    }
    private Point getPointFromDoor(Door door) {
        Point point = new Point();
        point.setX((door.getLeftX() + door.getRightX()) / 2);
        point.setY((door.getLeftY() + door.getRightY()) / 2);
        return point;
    }

    public String generateLineFromPoints(List<Point> points, String fileName) throws IOException {
        String line = "<polyline fill=\"none\" stroke=\"red\" stroke-width=\"5px\" points=\"";
        for (Point point : points) {
            line = line.concat(String.valueOf(point.getX()));
            line = line.concat(",");
            line = line.concat(String.valueOf(point.getY()));
            line = line.concat(" ");
        }
        line = line.substring(0, line.length() - 1);
        line = line.concat("\"");
        line = line.concat("/>");
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String strLine;
        String fullText = "";
        while ((strLine = reader.readLine()) != null) {
            fullText = fullText.concat(strLine);
        }
        fullText = fullText.substring(0, fullText.length() - 14); // Nadeus' 14)00)0
        fullText = fullText.concat(line);
        fullText = fullText.concat("\n" +
                "  </g>\n" +
                "</svg>");
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)));
        writer.write(fullText);
        return line;
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
