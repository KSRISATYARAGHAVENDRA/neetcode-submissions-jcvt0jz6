class MedianFinder {

    List<Integer> list;
    
    public MedianFinder() {
        list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        int index = list.size();
        while(!pq.isEmpty()){
            int top = pq.poll();
            if(top > num){
                index = list.indexOf(top);
                break;
            }
        }
        list.add(index , num);
    }
    
    public double findMedian() {
        int median1 = list.get((list.size()+1)/2 - 1);
        int median2 = list.get((list.size()+2)/2 - 1);
        return (median1 + median2) / 2.0 ;
    }
}
