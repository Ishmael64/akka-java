package chatRoom;

public final class SessionDenied implements SessionEvent {
    public final String reason;

    public SessionDenied(String reason) {
        this.reason = reason;
    }
}
