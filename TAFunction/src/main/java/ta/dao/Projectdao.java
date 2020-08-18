package ta.dao;

import ta.model.Project;

import java.sql.SQLException;
import java.util.List;

public interface Projectdao {
    public void save(Project p);
    public void update(Project p);
    public void delete(Project p);
    public List<Project> list();

}
