package com.hebin.resourse.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author hebin
 * @email 649980884@qq.com
 * @date 2020-05-15 14:40:30
 */
@ApiModel
@Data
@TableName("edu_resource_entity")
public class ResourceEntityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "resourceId",value = "")
	private String resourceId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "resourceName",value = "")
	private String resourceName;
	/**
	 * 
	 */
	@ApiModelProperty(name = "resourceAdd",value = "")
	private String resourceAdd;
	/**
	 * 
	 */
	@ApiModelProperty(name = "isDelete",value = "")
	private Integer isDelete;

	@ApiModelProperty(name = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
