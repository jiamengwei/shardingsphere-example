package data.sharding;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import data.sharding.entity.TConfig;
import data.sharding.entity.TOrder;
import data.sharding.mapper.TOrderMapper;
import data.sharding.service.ITConfigService;
import data.sharding.service.ITOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class DataShardingTest {

    @Autowired
    private ITOrderService orderService;

    @Autowired
    private ITConfigService configService;

    @Autowired
    private TOrderMapper orderMapper;

    @Test
    public void OrderTest(){
        UpdateWrapper<TOrder> delWrapper = new UpdateWrapper<>();
        delWrapper.isNotNull("order_id");
        orderService.remove(delWrapper);

        List<TOrder> orderList = IntStream.rangeClosed(1, 10).mapToObj(i -> {
            TOrder order = new TOrder();
            order.setUserId((i%2)+1);
            return order;
        }).collect(Collectors.toList());

        orderService.saveBatch(orderList);
    }


    @Test
    public void bindTableTest(){
        //绑定表测试
        orderMapper.queryOrderJoinItem().stream().forEach(System.out::println);
    }

    @Test
    public void broadcastTableTest(){
        List<TConfig> configList = IntStream.rangeClosed(1, 10).mapToObj(i -> {
            TConfig config = new TConfig();
            config.setName("key:"+i);
            config.setValue("A:"+i);
            return config;
        }).collect(Collectors.toList());

        configService.saveBatch(configList);
    }
}
