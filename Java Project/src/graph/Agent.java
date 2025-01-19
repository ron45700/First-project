package graph;
//package test;

// Methods:
// - getName(): Returns the name of the agent.
//   - Expected to return a descriptive name of the agent (used for debugging or identification).

// - reset(): Resets the internal state of the agent.
//   - For example, in BinOpAgent, it resets input values to 0 and clears input flags.

// - callback(String topic, Message msg): Handles incoming messages for the agent.
//   - This method is called whenever the agent receives a message from a subscribed topic.
//   - It should process the message based on its logic (e.g., storing input values, triggering actions).

// - close(): Cleans up the agent and unsubscribes it from any topics.
//   - For example, removes the agent from the subscription lists of all topics it's listening to.


public interface Agent {
    String getName();
    void reset();
    void callback(String topic, Message msg);
    void close();
}
