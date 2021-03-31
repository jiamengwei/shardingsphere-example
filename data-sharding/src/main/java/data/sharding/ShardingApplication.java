package data.sharding;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import data.sharding.entity.TOrder;
import data.sharding.mapper.TOrderMapper;
import data.sharding.service.ITConfigService;
import data.sharding.service.ITOrderItemService;
import data.sharding.service.ITOrderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@MapperScan("data.sharding.mapper")
public class ShardingApplication{
	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
	}
}
