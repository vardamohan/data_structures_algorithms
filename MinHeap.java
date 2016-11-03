import java.util.Arrays;

public class MinHeap {

	private int size = 0;
	private int capacity = 10;

	private int[] items = new int[capacity];

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * 2 + 2;
	}

	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) < size;
	}

	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}

	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) >= 0;
	}

	private int getRightChild(int parentIndex) {
		return items[getRightChildIndex(parentIndex)];
	}

	private int getLeftChild(int parentIndex) {
		return items[getLeftChildIndex(parentIndex)];
	}

	private int getParent(int childIndex) {
		return items[getParentIndex(childIndex)];
	}

	private void swap(int sourceIndex, int destinationIndex) {
		int temp = items[sourceIndex];
		items[sourceIndex] = items[destinationIndex];
		items[destinationIndex] = temp;
	}

	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}

	public int poll() {
		if (size == 0)
			throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerIndex = getLeftChildIndex(index);
			if (hasRightChild(index)
					&& getRightChild(index) < getLeftChild(index)) {
				smallerIndex = getRightChildIndex(index);
			}
			if (items[index] < items[smallerIndex]) {
				break;
			} else {
				swap(smallerIndex, index);
			}
			index = smallerIndex;
		}
	}

	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && getParent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
}
