package cn.ok.demos.druidmybatiesdemo.mapper.mydb2;

import cn.ok.demos.druidmybatiesdemo.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * File Header
 *
 * @author kyou on 2018-12-07 09:39
 */
@Mapper
public interface PersonMapper {
    @Insert("INSERT INTO PERSON (id,age,birth_day,user_name,phone) values (#{person.id},#{person.age},#{person.birthDay},#{person.userName},#{person.phone})")
    void save(@Param("person") Person person);

    @Select("SELECT * FROM PERSON")
    List<Person> findAllPersons();
}
