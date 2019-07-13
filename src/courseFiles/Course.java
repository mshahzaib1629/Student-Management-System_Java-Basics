package courseFiles;

import java.io.Serializable;

public class Course implements Serializable{

    Course next;
    String name;
    String id;

    public Course() {
        this(null, null, null);
    }

    public Course(String name, String id, Course next) {
        this.next = next;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + "]";
    }

}
