//DTO
package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
    @Id
    @Column(name="id")     //ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="created_at", nullable=false)    //作成日時
    private Timestamp creted_at;

    @Column(name="updated_at", nullable=false)     //更新日時
    private Timestamp updated_at;

    @Column(name="content", length=255, nullable=false)
    private String content;


    //getter/setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreted_at() {
        return creted_at;
    }

    public void setCreted_at(Timestamp creted_at) {
        this.creted_at = creted_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
