package graph;
//package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// outer class who will be the only way for creating a new Obj of Topic
public class TopicManagerSingleton {

    private static final TopicManager instance = new TopicManager();
    //constructor for TopicMangerSingleton
    private TopicManagerSingleton(){};

    //static method for getting a specific Topic map
    public static TopicManager get() {
        return instance;
    }


    // inner static class for creating a map for each topic
    public static class TopicManager{

      private  final  Map<String , Topic> topics;

      // constructor for TopicManager, setting a new HashMap for a new topic
      private TopicManager(){
          this.topics = new HashMap<>();
         // instance = new HashMap<>();
    }

// method to getTopic by his name (String), if it's not existed, it will create a new Topic Obj, and it'll return his value
    public Topic getTopic(String name) {
        return topics.computeIfAbsent(name, Topic::new);
    }
    // ______ EXAMPLE WITHOUT USING ".computeIfAbsent" ______
//        public Topic getTopic(String name) {
//            if (!topics.containsKey(name)) {
//                topics.put(name, new Topic(name));
//            }
//            return topics.get(name);
//        }
//   __________________________________________________________

  // getting all tropics maps
    public Collection<Topic> getTopics() {
        return topics.values();
    }

    // removing all Topics maps
        public void clear() {
            topics.clear();
        }
    }
}

