package read.write.splitting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import read.write.splitting.entity.User;
import read.write.splitting.mapper.UserMapper;
import read.write.splitting.service.IUserService;

import java.util.Date;
import java.util.stream.IntStream;

@MapperScan("read.write.splitting.mapper")
@SpringBootApplication
public class SplittingApplication implements CommandLineRunner {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SplittingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setAge(1);
        user.setBirthday(new Date());
        IntStream.rangeClosed(0, 10).forEach(i -> {
            user.setAge(i);
            userService.save(user);
        });
        IntStream.rangeClosed(0, 10).forEach(i -> {
            userMapper.selectList(null);
        });

    }
}
