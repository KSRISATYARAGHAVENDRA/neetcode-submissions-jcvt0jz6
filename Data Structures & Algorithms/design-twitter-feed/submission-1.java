class LinkedList{
    int time;
    int tweet;
    LinkedList next;

    LinkedList(){
    }
    LinkedList(int time , int tweet){
        this.time = time;
        this.tweet = tweet;
    }
}
class Twitter {

    Map<Integer , LinkedList> tweetMap;
    Map<Integer , Set<Integer>>followMap;
    int time;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap() ;
    }
    
    public void postTweet(int userId, int tweetId) {
        LinkedList head = new LinkedList(time++ , tweetId );
        if(tweetMap.containsKey(userId))
            head.next = tweetMap.get(userId);
        tweetMap.put(userId , head);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<LinkedList> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.time,a.time));
        if(tweetMap.containsKey(userId))
            maxHeap.offer(tweetMap.get(userId));

        for(int followeeId : followMap.getOrDefault(userId , new HashSet<>())){
            if(tweetMap.containsKey(followeeId))
            maxHeap.offer(tweetMap.get(followeeId));
        }
        
        List<Integer> res = new ArrayList<>();
        while(!maxHeap.isEmpty() && res.size() < 10){
            LinkedList top = maxHeap.poll();
            
            res.add(top.tweet);

            if(top.next != null){
                maxHeap.offer(top.next);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followMap.putIfAbsent(followerId , new HashSet<>());

            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId , new HashSet<>()).remove(followeeId);
    }
}
