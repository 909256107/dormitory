package com.itdfq.dormitory.dao;


import com.itdfq.dormitory.model.Student;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 */
public interface StudentDAO {

    @Select("select * from student  ")
    List<Student> findByPage();

    @Select("select * from student where sname like concat('%',#{sname},'%')  ")
    List<Student> findByTJ(Student student);

    @Delete("delete from  student  where sid = #{sid}")
    void delete(int sid);

    @Insert("insert into student(sno,sname,sphone,sclass,daddress,ssushe) values(#{sno},#{sname},#{sphone},#{sclass},#{daddress},#{ssushe})")
    void insert(Student student);

    @Update("update student set sno=#{sno},sname=#{sname},sphone=#{sphone},sclass=#{sclass},daddress=#{daddress},ssushe=#{ssushe} where sid=#{sid}")
    void update(Student student);

    @Delete({"<script>" +
            " delete from student  where sid  in "+
            "<foreach collection='list' item='custId' open='(' close=')' separator=','> #{custId}</foreach> "+
            " </script>"})
    void deleteSelect(List<String> custId);

}