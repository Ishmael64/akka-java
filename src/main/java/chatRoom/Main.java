package chatRoom;

import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.Behavior;
import akka.actor.typed.Terminated;
import akka.actor.typed.javadsl.Behaviors;

public class Main {
    public static Behavior<Void> create() {
        return Behaviors.setup(
                context -> {
                    ActorRef<RoomCommand> chatRoom = context.spawn(ChatRoom.create(), "chatRoom");
                    ActorRef<SessionEvent> gabbler = context.spawn(Gabbler.create(), "gabber");
                    context.watch(gabbler);
                    chatRoom.tell(new GetSession("ol' Gabbler", gabbler));

                    return Behaviors.receive(Void.class)
                            .onSignal(Terminated.class, sig -> Behaviors.stopped())
                            .build();
                });
    }

    public static void main(String[] args) {
        ActorSystem.create(Main.create(), "ChatRoomDemo");
    }
}
