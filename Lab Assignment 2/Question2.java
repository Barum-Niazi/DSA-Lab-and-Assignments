import java.util.Arrays;

class RollerCoasterRide {
    private static final int MAX_CAPACITY = 20;
    private static final int MAX_RIDERS = 100;

    private int[] ridersQueue;
    private int front;
    private int rear;

    private int adultCount;
    private int childCount;

    public RollerCoasterRide() {
        ridersQueue = new int[MAX_RIDERS];
        front = -1;
        rear = -1;
        adultCount = 0;
        childCount = 0;
    }

    public void enqueue(int riderId, boolean isAdult, boolean isVIP) {
        if (isFull()) {
            System.out.println("Riders queue is full. Cannot enqueue more riders.");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        if (isVIP) {
            front = (front - 1 + MAX_RIDERS) % MAX_RIDERS;
            ridersQueue[front] = riderId;
        } else {
            rear = (rear + 1) % MAX_RIDERS;
            ridersQueue[rear] = riderId;
        }

        if (isAdult) {
            adultCount++;
        } else {
            childCount++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Riders queue is empty. No riders to dequeue.");
            return -1;
        }

        int dequeuedRider = ridersQueue[front];
        ridersQueue[front] = 0;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_RIDERS;
        }

        return dequeuedRider;
    }

    public boolean isFull() {
        return (rear + 1) % MAX_RIDERS == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void processRiders() {
        while (!isEmpty()) {
            int ridersCount = Math.min(size(), MAX_CAPACITY);
            int adultRidersCount = 0;
            int childRidersCount = 0;

            for (int i = 0; i < ridersCount; i++) {
                int riderId = dequeue();
                boolean isAdult = determineIsAdult(riderId);
                if (isAdult) {
                    adultRidersCount++;
                } else {
                    childRidersCount++;
                }
            }

            System.out.println("Processing riders: " + Arrays.toString(ridersQueue));
            System.out.println("Ride started with " + ridersCount + " riders.");
            System.out.println("Adult riders: " + adultRidersCount);
            System.out.println("Child riders: " + childRidersCount);
            System.out.println();

            adultCount -= adultRidersCount;
            childCount -= childRidersCount;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        if (front <= rear) {
            return rear - front + 1;
        } else {
            return MAX_RIDERS - front + rear + 1;
        }
    }

    public int getAdultCount() {
        return adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    private boolean determineIsAdult(int riderId) {

        return riderId % 2 == 0;
    }
}

public class Question2 {
    public static void main(String[] args) {
        RollerCoasterRide ride = new RollerCoasterRide();

        ride.enqueue(1, true, true);
        ride.enqueue(2, false, false);
        ride.enqueue(3, true, false);
        ride.enqueue(4, false, true);
        ride.enqueue(5, true, true);

        ride.processRiders();

        System.out.println("Adult count: " + ride.getAdultCount());
        System.out.println("Child count: " + ride.getChildCount());
    }

}
