package helloWorld;

import akka.actor.typed.ActorSystem;

public class Main {

    public static void main(String[] argv) {
        final ActorSystem<HelloWorldMain.SayHello> system =
                ActorSystem.create(HelloWorldMain.create(), "hello");

        system.tell(new HelloWorldMain.SayHello("World"));
        system.tell(new HelloWorldMain.SayHello("Akka"));
    }
}
