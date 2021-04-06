package data.sharding.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-04-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PassRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long corpId;

    /**
     * 通行证姓名
     */
    private String name;

    /**
     * 手机号码 aes加密
     */
    private String visiPhone;

    /**
     * 设备id
     */
    private Integer deviceId;

    /**
     * 设备位置
     */
    private String deviceLocation;

    /**
     * 比对结果（1-确定；2-不确定；3-否定；4-未知）
     */
    private Integer checkRes;

    /**
     * 通行结果（1-放行；2-不放行；3-未知）
     */
    private Integer passRes;

    /**
     * 通行方式（1-刷脸；2-刷卡; 3-二维码；4-身份证；5-云对讲）
     */
    private Integer passType;

    /**
     * 通行方向。0:不区分，1:进入，2:出
     */
    private Integer direction;

    /**
     * 通行比对时间
     */
    private LocalDateTime checkTime;

    /**
     * 时间
     */
    private LocalDateTime createTime;


}
