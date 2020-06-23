package heap;

public class H_295FindMedianFromDataStream {
    //solution1 brute O(nlogn)
    ArrayList<Integer> array = new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        array.add(num);

    }

    public double findMedian() {
        if(array.size() == 0) return 0;
        Collections.sort(array);
        if((array.size())%2 == 0){

            return ((float)(array.get((array.size()/2) - 1) + array.get(array.size()/2))/2);
        }else{
            return array.get(array.size()/2);
        }
    }

    //solution2 priorityQueue O(logn)
    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        minHeap = new PriorityQueue<Integer>((a,b) -> a - b);

    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        //
        if(maxHeap.size() - 1 > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (float)( maxHeap.peek() + minHeap.peek())/2;
        }else{
            return maxHeap.peek();
        }
    }
}
