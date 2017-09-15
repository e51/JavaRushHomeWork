package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
    private volatile String name;      //название
    private volatile float distance;   //расстояние
    private volatile int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int result = 0;

//        result = name.compareTo(o.getName());
//        if (result != 0) return result;

        result = Float.compare(distance, o.getDistance());
        if (result != 0) return -result;

        result = Integer.compare(quality, o.getQuality());

        return result;
    }

//    public static void main(String[] args) {
//        Beach o1 = new Beach("name", Float.NaN, 2);
//        Beach o2 = new Beach("name", Float.NaN, 2);
//        System.out.println(o1.compareTo(o2));
//    }
}
