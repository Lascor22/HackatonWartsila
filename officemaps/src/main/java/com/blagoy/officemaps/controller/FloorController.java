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

    private Point findClosestLeftStairOrLift(ObjectMap room, long number) {
        Floor floor = findByNumber(number);
        double minDist = Double.MAX_VALUE;
        Point roomPoint = room.getPoint();
        Point minPoint = new Point();
        for (ObjectMap objectMap : floor.getObjectMaps()) {
            if (objectMap instanceof Transition) {
                Transition transition = (Transition) objectMap;
                if (transition.getPoint().getX() <= roomPoint.getX() && (transition.getType() == TransitionType.Lift || transition.getType() == TransitionType.Stairs)) {
                    double currentDist = getDist(roomPoint, transition.getPoint());
                    if (minDist > currentDist) {
                        minDist = currentDist;
                        minPoint = transition.getPoint();
                    }
                }
            }
        }
        return minPoint;
    }

    private Point findClosestRightStairOrLift(ObjectMap room, long number) {
        Floor floor = findByNumber(number);
        double minDist = Double.MAX_VALUE;
        Point roomPoint = room.getPoint();
        Point minPoint = new Point();
        for (ObjectMap objectMap : floor.getObjectMaps()) {
            if (objectMap instanceof Transition) {
                Transition transition = (Transition) objectMap;
                if (transition.getPoint().getX() > roomPoint.getX() && (transition.getType() == TransitionType.Lift || transition.getType() == TransitionType.Stairs)) {
                    double currentDist = getDist(roomPoint, transition.getPoint());
                    if (minDist > currentDist) {
                        minDist = currentDist;
                        minPoint = transition.getPoint();
                    }
                }
            }
        }
        return minPoint;
    }

    private double getDist(Point first, Point second) {
        return Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2));
    }

    @GetMapping("floor/directions")
    public ClosestWay getDirections(@RequestParam("firstX") double firstX, @RequestParam("firstY") double firstY,
                                    @RequestParam("secondX") double secondX, @RequestParam("secondY") double secondY,
                                    @RequestParam("number1") long number1, @RequestParam("number2") long number2) {
        ObjectMap firstRoom = getRoom(firstX, firstY, number1);
        ObjectMap secondRoom = getRoom(secondX, secondY, number2);
        if (number1 == number2) {
            Floor firstFloor = findByNumber(number1);
            List<ObjectMap> objectMaps = firstFloor.getObjectMaps();
            Collections.sort(objectMaps);
            List<Point> points = new ArrayList<>();
            int n = objectMaps.size();
            double[] d = new double[n];
            for (int i = 0; i < n; ++i) {
                d[i] = Double.MAX_VALUE;
            }
            int[] p = new int[n];
            boolean[] used = new boolean[n];
            d[(int) firstRoom.getId()] = 0;
            double distance = 0;
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
                    double len = getDist(objectMap1.getPoint(), objectMap.getPoint());
                    if (d[(int) objectMap1.getId()] + len < d[to]) {
                        d[to] = d[(int) objectMap1.getId()] + len;
                        p[to] = (int) objectMap1.getId();
                    }
                }
            }
            while (p[(int) secondRoom.getId()] != 0) {
                ObjectMap parentRoom = objectMapController.findById(secondRoom.getId());
                distance += getDist(secondRoom.getPoint(), parentRoom.getPoint());
                points.add(secondRoom.getPoint());
                secondRoom = parentRoom;
            }
            points.add(firstRoom.getPoint());
            Collections.reverse(points);
            ClosestWay closestWay = new ClosestWay();
            closestWay.setDistance(distance);
            closestWay.setPoints(points);
            return closestWay;
        } else {
            Point leftClosest = findClosestLeftStairOrLift(firstRoom, number1);
            Point rightClosest = findClosestRightStairOrLift(firstRoom, number2);
            double dist1 = getDist(firstRoom.getPoint(), leftClosest) + getDist(leftClosest, secondRoom.getPoint());
            double dist2 = getDist(firstRoom.getPoint(), rightClosest) + getDist(rightClosest, secondRoom.getPoint());
            if (dist1 <= dist2) {
                return getAns(leftClosest, firstX, firstY, secondX, secondY, number1, number2);
            } else {
                return getAns(rightClosest, firstX, firstY, secondX, secondY, number1, number2);
            }
        }
    }

    private ClosestWay getAns(Point point, double firstX, double firstY, double secondX, double secondY, long number1,
                              long number2) {
        ClosestWay ans = new ClosestWay();
        ClosestWay first = getDirections(firstX, firstY, point.getX(), point.getY(), number1, number1);
        ClosestWay second = getDirections(point.getX(), point.getY(), secondX, secondY, number2, number2);
        List<Point> ansPoint = first.getPoints();
        ansPoint.addAll(second.getPoints());
        double ansDistance = first.getDistance() + second.getDistance();
        ans.setPoints(ansPoint);
        ans.setDistance(ansDistance);
        return ans;
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
