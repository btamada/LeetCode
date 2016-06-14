import java.util.*;

/**

 Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

 postTweet(userId, tweetId): Compose a new tweet.
 getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 follow(followerId, followeeId): Follower follows a followee.
 unfollow(followerId, followeeId): Follower unfollows a followee.

 Example:
 Twitter twitter = new Twitter();

 // User 1 posts a new tweet (id = 5).
 twitter.postTweet(1, 5);

 // User 1's news feed should return a list with 1 tweet id -> [5].
 twitter.getNewsFeed(1);

 // User 1 follows user 2.
 twitter.follow(1, 2);

 // User 2 posts a new tweet (id = 6).
 twitter.postTweet(2, 6);

 // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 twitter.getNewsFeed(1);

 // User 1 unfollows user 2.
 twitter.unfollow(1, 2);

 // User 1's news feed should return a list with 1 tweet id -> [5],
 // since user 1 is no longer following user 2.
 twitter.getNewsFeed(1);

 */
public class Twitter {

    private class Post {
        Integer id;
        Integer time;

        Post(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    int timestamp; // unique identifier of posts
    Map<Integer, Set<Integer>> friends;
    Map<Integer, List<Post>> posts;
    /** Initialize your data structure here. */
    public Twitter() {
        timestamp = 0;
        friends = new HashMap<>();
        posts = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (posts.get(userId) == null) {
            posts.put(userId, new ArrayList<Post>());
        }
        posts.get(userId).add(new Post(tweetId, timestamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Post> tmp = new ArrayList<>();
        if (posts.get(userId) != null) {
            tmp.addAll(posts.get(userId));
        }
        if (friends.get(userId) != null) {
            for (Integer id : friends.get(userId)) {
                if (posts.get(id) != null) {
                    tmp.addAll(posts.get(id));
                }
            }
        }
        Collections.sort(tmp, new Comparator<Post>() { // reversely sort based on timestamp
            public int compare(Post p1, Post p2) {
                return p2.time - p1.time;
            }
        });
        if (tmp.size() > 10) {
            tmp = tmp.subList(0, 10);
        }
        List<Integer> result = new ArrayList<>();
        for (Post p : tmp) {
            result.add(p.id);
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;  // cannot befriend oneself
        if (friends.get(followerId) == null) {
            friends.put(followerId, new HashSet<>());
        }
        friends.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (friends.get(followerId) != null) {
            friends.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
