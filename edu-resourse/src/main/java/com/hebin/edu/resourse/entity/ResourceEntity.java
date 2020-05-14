package com.hebin.edu.resourse.entity;

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
 * @email 649980884@@qq.com
 * @date 2020-05-13 19:52:44
 */
@ApiModel
@Data
@TableName("edu_resource")
public class ResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "resourceId",value = "")
	private Long resourceId;
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

}
