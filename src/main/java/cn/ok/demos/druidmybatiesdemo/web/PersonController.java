package cn.ok.demos.druidmybatiesdemo.web;

import cn.ok.demos.druidmybatiesdemo.entity.Person;
import cn.ok.demos.druidmybatiesdemo.mapper.mydb2.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * File Header
 *
 * @author kyou on 2018-12-07 09:43
 */
@RestController
public class PersonController {
    @Autowired
    PersonMapper personMapper;

    @GetMapping("/FindAllPerson")
    public String findAllPerson() {
        return personMapper.findAllPersons().toString();
    }

    @GetMapping("/AddPerson/{cnt}")
    public String addPersons(@PathVariable("cnt") int cnt) {

        Person person = new Person();
        for (int i = 1; i < cnt + 1; i++) {
            person.setId(i);
            person.setAge(18 + i);
            person.setBirthDay(new Date());
            person.setPhone(13691463895L + 1);
            person.setUserName("Person" + i);

            personMapper.save(person);
        }

        return "Done.";
    }
}
