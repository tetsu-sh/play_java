package com.chimu.tasklist;

import com.chimu.tasklist.HomeRestController.TaskItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskListDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    TaskListDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    public void add(TaskItem taskItem){
        SqlParameterSource param = new BeanPropertySqlParameterSource(taskItem);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName("tasklist");
        insert.execute(param);
    }

    public List<TaskItem> findAll() {
        String query = "SELECT * FROM tasklist";
        List<Map<String, Object>> result = this.jdbcTemplate.queryForList(query);
        List<TaskItem> taskItems = result.stream().map((Map<String, Object> row) -> new TaskItem(
                row.get("id").toString(),
                row.get("task").toString(),
                row.get("deadline").toString(),
                (Boolean) row.get("done")
        )).toList();
        return taskItems;
    }

    public int update(TaskItem taskItem){
        return this.jdbcTemplate.update(
                "UPDATE tasklist SET task= ?,deadline=?,done=? WHERE id=?",
                taskItem.task(),
                taskItem.deadline(),
                taskItem.done(),
                taskItem.id()
        );

    }


    public int delete(String id){
        int number = jdbcTemplate.update("DELETE FROM tasklist WHERE id = ?",id);
        return number;
    }
}
