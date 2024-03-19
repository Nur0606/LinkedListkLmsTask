package LinkedList_LMS.model;

public class Actor {
    private String actorFullName;

    private String role;

    public Actor() {
    }

    public Actor(String actorFullName, String role) {
        this.actorFullName = actorFullName;
        this.role = role;
    }

    public String getActorFullName() {
        return actorFullName;
    }

    public void setActorFullName(String actorFullName) {
        this.actorFullName = actorFullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Actor{" +
               "\n  actorFullName='" + actorFullName + '\'' +
               ",\n  role='" + role + '\'' +
               "\n}\n";
    }
}
