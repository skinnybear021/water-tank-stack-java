package cce;

/**
 * WaterTankDemo: a stack (LIFO) implemented with an array.
 * Each "bucket" holds some liters of water. The last bucket poured is the first drained.
 */
public class WaterTankDemo {
	///////////////////////////////Fields
	private String name;
	private int[] bucket;
	private int top;

	///////////////////////////////No-Argument constructor
	public WaterTankDemo() {
		this.name = "Standard Tank";
		this.bucket = new int[5];
		this.top = -1;
		System.out.println(name + " created with no-argument constructor");
	}

	///////////////////////////////Parameterized constructor
	public WaterTankDemo(String name, int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be greater than 0.");
		}
		this.name = name;
		this.bucket = new int[capacity];
		this.top = -1;
		System.out.println(name + ": Holds " + capacity + " buckets.");
	}

	///////////////////////////////Push: pour a bucket into the tank
	public void pour(int liters) {
		if (liters <= 0) {
			System.out.println("INVALID! " + name + " cannot be poured with " + liters + "L.");
			return;
		}
		if (top == bucket.length - 1) {
			System.out.println("OVERFLOW! " + name + " is full. " + liters + "L spilled on the floor!");
			return;
		}
		top++;
		bucket[top] = liters;
		System.out.println("Poured " + liters + "L into " + name);
	}

	///////////////////////////////Pop: drain the top bucket (returns -1 if empty)
	public int drain() {
		if (isEmpty()) {
			System.out.println("UNDERFLOW! " + name + " is empty.");
			return -1;
		}
		int liters = bucket[top];
		top--;
		System.out.println("Drained " + liters + "L from " + name);
		return liters;
	}

	///////////////////////////////Peek: view the top bucket (returns -1 if empty)
	public int checkTop() {
		if (isEmpty()) {
			System.out.println(name + " is empty.");
			return -1;
		}
		return bucket[top];
	}

	///////////////////////////////Helper methods
	public boolean isEmpty() {
		return top == -1;
	}

	public int bucketCount() {
		return top + 1;
	}

	public int totalLiters() {
		int total = 0;
		for (int i = 0; i <= top; i++) {
			total += bucket[i];
		}
		return total;
	}

	///////////////////////////////Main
	public static void main(String[] args) {
		///////////////////////////////No-Argument constructor
		WaterTankDemo tank1 = new WaterTankDemo();
		tank1.pour(10);
		tank1.pour(20);
		tank1.pour(30);
		System.out.println("Top bucket: " + tank1.checkTop() + "L");
		tank1.drain();
		System.out.println("Buckets left: " + tank1.bucketCount() + " | Total water: " + tank1.totalLiters() + "L");

		//////////////////////////////Parameterized Constructor
		WaterTankDemo tank2 = new WaterTankDemo("Mini Tank", 3);
		tank2.pour(5);
		tank2.pour(10);
		tank2.pour(15);
		tank2.pour(20);
		tank2.drain();
		tank2.drain();
		tank2.drain();
		tank2.drain();
		System.out.println("Is the tank empty? " + tank2.isEmpty());
	}
}
