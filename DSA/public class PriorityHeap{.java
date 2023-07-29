public class PriorityHeap{
    private int MAX = 100;
    private int heap[MAX +1];  // This is because we start filling in our array from index 1 so we need 101 spaces 

    private int n=0;

    public int value(int i){
        if (i<1 or i>n)
            throw IndexOutOfBoundsException;
        return heap[i];
    }
    public boolean isRoot(int i) {return i == 1;}
    public int level(int i) {return log(i);}
    public int parent(int i) {return i/2;}
    public int left(int i) {return 2*i;}
    public int right(int i) {return 2*i + 1;}

    public boolean isEmpty() {
        return n == 0;
    }

    public int root() {
        if (heapEmpty())
            throw HeapEmptyException;
        else return heap[1];     // Remember the root is always stored in index 1
    }

    public int lastLeaf() {
        if (heapEmpty())
            throw HeapEmptyException;
        else return heap[n]
    }
}




//This is how to insert into the Priority Queue (represented as a binary heap tree in an array implementation)

public void insert(int p) {
    if (n == MAXSIZE)
        throw HeapFullException;
    n++;
    heap[n] = p //insert new value as last node of last level
    bubbleUp(n) 
}

private void bubbleUp(int i) {
    if (i == 1) return; //i is the root

    if (heap[i] > heap[parent(i)]) {
        swap heap[i] & heap[parent(i)];
        bubbleUp(parent(i));
    }
}

public void deleteRoot() {
    if (n < 1) {
        throw IndexOutOfBoundsException;
    }

    heap[1] = heap[n];
    n--;
    bubbleDown(1);


}

private void bubbleDown(int i) {
    if (left(i) > n)            //no children - current node is a leaf, cos it has no left children
        return;
    
    else if (right(i) > n) {   //only has left child - because a node in a BHT cant have right child unless it has left child
        if(heap[i] < heap[left(i)]) {
            swap heap[i] and heap[left(i)]; //no need to do anything further because no more nodes
        }
    }

    else if (heap[left(i)] > heap[right(i)] && heap[i] < heap[left(i)]) {
        swap heap[i] and heap[left(i)];
        bubbleDown(left(i));
    }

    else if (heap[right(i)] > heap[left(i)] && heap[i] < heap[right(i)]) {
        swap heap[i] and heap[right(i)];
        bubbleDown(right(i));
    }
}


public void delete(int i) {
    if (n<1) {
        throw EmptyHeapException;
    }

    if (i<1 or i>n) {
        throw IndexOutOfBoundsException;
    }

    heap[i] = heap[n];
    n--;

    bubbleUp(i);
    bubbleDown(i);  //safe to do both cos if it's complete, won't ruin anything
}

//If you wanted to just update the priority of a node in the tree, you would do the following:


public void update(int i, int priority) {
    if (n<1) {
        throw EmptyHeapException;
    }

    if (i<1 or i>n) {
        throw IndexOutOfBoundsException;
    }

    heap[i] = priority;

    bubbleUp(i);
    bubbleDown(i);  //safe to do both cos if it's complete, won't ruin anything
}