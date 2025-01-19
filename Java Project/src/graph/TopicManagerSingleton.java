package graph;
//package test;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

// Fields:

// Methods:
// - get(): Returns the Singleton instance of TopicManager.

// ___ Inner Class: TopicManager
// Fields:
// - instance (TopicManager): Singleton instance of TopicManager.
// - topics (Map<String, Topic>): A map containing all Topics by their names.

// Methods:
// - getTopic(String name): Retrieves a Topic by name. Creates a new Topic if it doesn't exist.
// - getTopics(): Returns a collection of all existing Topics.
// - clear(): Clears all Topics from the system.


// outer class who will be the only way for creating a new Obj of Topic
public class TopicManagerSingleton {
    // inner static class for creating a map for each topic
    public static class TopicManager {
        private final ConcurrentHashMap<String, Topic> topics = new ConcurrentHashMap<>();

        // method to getTopic by his name (String), if it's not existed, it will create a new Topic Obj, and it'll return his value
        public Topic getTopic(String name) {

            return topics.computeIfAbsent(name, Topic::new);
        }

        // getting all tropics maps
        public Collection<Topic> getTopics() {

            return topics.values();
        }

        // removing all Topics maps
        public void clear() {
            topics.clear();
        }
    }
        private  static  class Holder{
            private static final TopicManager instance = new TopicManager();
        }
        public static TopicManager get(){
          return  Holder.instance;
        }
    }


