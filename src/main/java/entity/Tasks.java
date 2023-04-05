package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Tasks", query = "SELECT e FROM Tasks e WHERE e.item= ?1")
public class Tasks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "item")
    private String item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks tasks = (Tasks) o;

        if (id != tasks.id) return false;
        if (item != null ? !item.equals(tasks.item) : tasks.item != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + " " + item;
    }
}
