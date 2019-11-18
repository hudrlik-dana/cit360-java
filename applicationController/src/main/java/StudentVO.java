
// value object VO, whole objected treated as a single value
// data transfer object DTO encapsulates data and transfers between layers
// from persistance database to business or network

public class StudentVO {
    private String id;
    private String name;

    // constructor
    public StudentVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // setters and getters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}