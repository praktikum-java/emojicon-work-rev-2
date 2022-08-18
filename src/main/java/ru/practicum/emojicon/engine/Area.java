package ru.practicum.emojicon.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Area implements Boxed {

    private final int left;
    private final int right;
    private final int top;
    private final int bottom;

    public Area(int left, int top, int right, int bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    public Area(Point lt, Point rb) {
        this(lt.getX(), lt.getY(), rb.getX(), rb.getY());
    }

    public List<Point> getCorners() {
        return new ArrayList<>(Arrays.asList(new Point(left, top), new Point(left, bottom), new Point(right, top), new Point(right, bottom)));
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public int getTop() {
        return top;
    }

    @Override
    public int getBottom() {
        return bottom;
    }
}
