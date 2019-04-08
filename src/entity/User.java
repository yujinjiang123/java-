package entity;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

import java.util.List;


public class User {

    private Integer id;
    private String username;
    private String password;

    private String schoolName;
    private String profession;

    private List<String> technologyList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getTechnologyList() {
        return technologyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", profession='" + profession + '\'' +
                ", technologyList=" + technologyList +
                '}';
    }

    public void setTechnologyList(List<String> technologyList) {
        this.technologyList = technologyList;
    }
}
