package ru.practicum.emojicon.engine;

import com.googlecode.lanterna.TextColor;

public abstract class AbstractFrame implements Frame {
    private final int left;
    private final int top;
    private final int right;
    private final int bottom;

    private int posX;
    private int posY;
    private TextColor fillColor;
    private TextColor color;

    public AbstractFrame(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.posX = 0;
        this.posY = 0;
        this.fillColor = this.color = TextColor.ANSI.BLACK;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public TextColor getFillColor() {
        return fillColor;
    }

    public TextColor getColor() {
        return color;
    }

    protected TextColor getRealFillColor() {
        return getFillColor() != null ? getFillColor() : getTransparentColor();
    }

    //set background color
    public void setFillColor(TextColor fillColor){
        this.fillColor = fillColor;
    }

    //set paint color
    public void setColor(TextColor color){
        this.color = color;
    }
}
