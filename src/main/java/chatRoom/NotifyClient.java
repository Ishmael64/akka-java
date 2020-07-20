package chatRoom;

final class NotifyClient implements SessionCommand {
    final MessagePosted message;

    NotifyClient(MessagePosted message) {
        this.message = message;
    }
}
