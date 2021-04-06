package data.sharding;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import data.sharding.entity.PassRecord;
import data.sharding.entity.TConfig;
import data.sharding.entity.TOrder;
import data.sharding.mapper.PassRecordMapper;
import data.sharding.mapper.TOrderMapper;
import data.sharding.service.IPassRecordService;
import data.sharding.service.ITConfigService;
import data.sharding.service.ITOrderService;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.record.Record;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class DataShardingTest {

    @Autowired
    private ITOrderService orderService;

    @Autowired
    private ITConfigService configService;

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private PassRecordMapper passRecordMapper;

    @Autowired
    private IPassRecordService passRecordService;

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

    @Test
    public void shardingByDateTest(){
        passRecordMapper.delete(null);

        List<PassRecord> list = IntStream.rangeClosed(1,120).mapToObj(i->{
            return IntStream.rangeClosed(1,12).mapToObj(m->{
                PassRecord record = new PassRecord();
                LocalDateTime checkTime = LocalDateTime.of(2021, m, 1, 12, 20);
                record.setCheckTime(checkTime);
                record.setName("张三");
                record.setCheckRes(1);
                record.setPassType(2);
                record.setPassRes(1);
                record.setDeviceId(i%4+1);
                return record;
            });
        }).flatMap(Stream::parallel).collect(Collectors.toList());

        passRecordService.saveBatch(list);
    }

}
