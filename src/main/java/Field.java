/**
 * Created by watson on 05.02.15.
 */
public class Field {
    private String owner;
    private String name;

    public Field(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public int hashCode() {

        return owner.hashCode() + name.hashCode();
    }


    public boolean equals(Object o) {
        if (!(o instanceof  Field)) {
            return false;
        }
        Field f = (Field) o;
        return (owner.equals(f.owner)) && (name.equals(f.name));
    }

    public String getFullName() {
        return owner + "." + name;
    }
}

