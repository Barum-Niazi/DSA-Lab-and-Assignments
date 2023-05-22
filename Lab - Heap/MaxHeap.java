
public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < size && heap[leftChildIndex] > heap[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] > heap[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(8);
        maxHeap.insert(25);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        System.out.println("Extracted max value: " + maxHeap.extractMax());

        System.out.println("Updated Max Heap:");
        maxHeap.printHeap();
    }
}
