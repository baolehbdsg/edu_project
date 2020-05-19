package com.hebin.resourse.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 测试
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:29
 */
@ApiModel
@Data
@TableName("edu_test_entity")
public class TestEntityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "testId",value = "")
	private Long testId;
	/**
	 * 是否删除（逻辑删除）
	 */
	@ApiModelProperty(name = "isDelete",value = "是否删除（逻辑删除）")
	private Integer isDelete;
	/**
	 * 
	 */
	@ApiModelProperty(name = "testTitle",value = "")
	private String testTitle;

}