package ta.model;

import com.google.gson.Gson;
import ta.dao.ProjectDaoImp;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public Project() {
    }

    public Project(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project(String json) {
        Gson gson = new Gson();
        Project project = gson.fromJson(json, Project.class);
        this.id   = project.id;
        this.name = project.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
