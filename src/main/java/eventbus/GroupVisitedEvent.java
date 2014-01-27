package eventbus;

public class GroupVisitedEvent {
    
    public final String group_id;
    public final String user_id;
    
    public GroupVisitedEvent(String group_id, String user_id) {
        this.group_id = group_id;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "GroupVisitedEvent{" + "group_id=" + group_id + ", user_id=" + user_id + '}';
    }
    
    
    
}
