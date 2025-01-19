package graph;
//package test;

import java.util.Date;

// Fields:
// - asText (String): the content of the message as text.
// - asDouble (double): the content of the message as a double (or NaN if not applicable).
// - data (byte[]): the content of the message in bytes.
// - date (Date): the timestamp of when the message was created.

// Methods:
// - Message(String newMessage): Constructor that initializes the message with a string.
// - Message(double newMessage): Constructor that initializes the message with a double.
// - Message(byte[] newMessage): Constructor that initializes the message with bytes.


public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    // Main constructor for Message by receiving String, setting all fields
    public Message(String newMessage) {

        if (newMessage == null) { // if the String is null, it will make in time error when it tries to Downcast it
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.data = newMessage.getBytes();
        this.asText = newMessage;
        this.asDouble = parseDoubleSafely(newMessage);
        this.date = new Date();
    }

    // constructor for Message by receiving byte[] Obj
    public Message(byte[] bytes) {
        this(new String(bytes));
    }

    // constructor for Message by receiving double Obj
    public Message(double d){
        this(Double.toString(d));
    }

    private static double parseDoubleSafely(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

}
