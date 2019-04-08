package dao.daoimpl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBUtil;
import util.Pagination;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {


    @Override
    public void addUser(User user) {
        try {
            QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());
            String sql = "insert into user(username,password,school_name,profession)  values(?,?,?,?)";
            Object[] params = new Object[]{
                    user.getUsername(),
                    user.getPassword(),
                    user.getSchoolName(),
                    user.getProfession()
            };
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        User user=null;
        try{
            QueryRunner queryRunner=new QueryRunner(DBUtil.getDataSource());
            String sql="select * from user where username=? and password=?";
            String sqltechnology="select technology from user where username=? and password=?";
            Object[] params=new Object[]{username,password};
            user=queryRunner.query(sql, new BeanHandler<User>(User.class),params);
            Object[] technologyArr=queryRunner.query(sqltechnology,new ArrayHandler(),params);
            List<String> technologyList= Arrays.stream(((String)technologyArr[0]).split(";")).collect(Collectors.toList());
            user.setTechnologyList(technologyList);
            System.out.println(user);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUser(Pagination page) {
        return null;
    }

    @Override
    public void addPersonalInfo(User user) {

    }
    @Override
    public void updateUser(User user) {
        String[] technologyArr=user.getTechnologyList().stream().toArray(String[]::new);
        String technology=String.join(";",technologyArr);
        String sql="update user set school_name=?,profession=?,technology=?";
        Object[] params={user.getSchoolName(),user.getProfession(),technology};
        try{
            QueryRunner queryRunner=new QueryRunner(DBUtil.getDataSource());
            queryRunner.update(sql,params);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
