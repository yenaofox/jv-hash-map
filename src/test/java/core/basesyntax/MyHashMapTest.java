package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {
    private static final Car firstCar = new Car("Audi", "black");
    private static final Car secondCar = new Car("Bmw", "red");
    private static final Car thirdCar = new Car("Mercedes", "grey");

    private static final Plane firstPlane = new Plane("Mria", "white");
    private static final Plane secondPlane = new Plane("Boing", "white");
    private static final Plane thirdPlane = new Plane("F3T", "grey");

    @Test
    public void getByNonExistedKey() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        Assert.assertNull(myHashMap.getValue(firstCar));
    }

    @Test
    public void putAndGetOk() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstCar, 3);
        myHashMap.put(secondCar, 5);
        myHashMap.put(thirdCar, 1);

        Assert.assertEquals(3, myHashMap.getSize());
        Assert.assertEquals(Integer.valueOf(3), myHashMap.getValue(firstCar));
        Assert.assertEquals(Integer.valueOf(5), myHashMap.getValue(secondCar));
        Assert.assertEquals(Integer.valueOf(1), myHashMap.getValue(thirdCar));
    }

    @Test
    public void putAndGetByNullKey() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(null, 3);
        Assert.assertEquals(Integer.valueOf(3), myHashMap.getValue(null));
        Assert.assertEquals(1, myHashMap.getSize());
        myHashMap.put(null, 5);
        Assert.assertEquals(Integer.valueOf(5), myHashMap.getValue(null));
        Assert.assertEquals(1, myHashMap.getSize());
    }

    @Test
    public void putAndGetWithCollision() {
        MyMap<Plane, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstPlane, 3);
        myHashMap.put(secondPlane, 5);
        myHashMap.put(thirdPlane, 1);

        Assert.assertEquals(3, myHashMap.getSize());
        Assert.assertEquals(Integer.valueOf(3), myHashMap.getValue(firstPlane));
        Assert.assertEquals(Integer.valueOf(5), myHashMap.getValue(secondPlane));
        Assert.assertEquals(Integer.valueOf(1), myHashMap.getValue(thirdPlane));
    }

    @Test
    public void putAndGetTheOverriddenValueByKey() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstCar, 3);
        Assert.assertEquals(1, myHashMap.getSize());
        Assert.assertEquals(Integer.valueOf(3), myHashMap.getValue(firstCar));

        myHashMap.put(firstCar, 5);
        Assert.assertEquals(1, myHashMap.getSize());
        Assert.assertEquals(Integer.valueOf(5), myHashMap.getValue(firstCar));
    }

    @Test
    public void checkTheHashMapIncrease() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            Car car = new Car("model_" + i, "color_" + i);
            myHashMap.put(car, i);
        }
        Assert.assertEquals(1000, myHashMap.getSize());
        Assert.assertEquals(Integer.valueOf(999), myHashMap.getValue(new Car("model_999", "color_999")));
    }

    @Test
    public void getSizeOfEmptyHashMap() {
        MyMap<Car, Integer> myHashMap = new MyHashMap<>();
        Assert.assertEquals(0, myHashMap.getSize());
    }

    @Test
    public void getSizeWithCollision() {
        MyMap<Plane, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(firstPlane, 3);
        myHashMap.put(secondPlane, 5);
        Assert.assertEquals(2, myHashMap.getSize());
    }
}
