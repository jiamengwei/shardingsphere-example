package sharding.jdbc.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sharding.jdbc.example.entity.User;
import sharding.jdbc.example.mapper.UserMapper;
import sharding.jdbc.example.service.IUserService;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@MapperScan("sharding.jdbc.example.mapper")
@SpringBootApplication
public class ShardingJdbcExampleApplication  implements CommandLineRunner {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setAge(1);
        user.setBirthday(new Date());
        IntStream.rangeClosed(0,10).forEach(i->{
            user.setAge(i);
            userService.save(user);
        });
        IntStream.rangeClosed(0,10).forEach(i->{
            userMapper.selectList(null);
        });

    }
}
