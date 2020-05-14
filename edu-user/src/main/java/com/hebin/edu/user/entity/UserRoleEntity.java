package com.hebin.edu.user.entity;

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
 * @date 2020-05-13 19:48:49
 */
@ApiModel
@Data
@TableName("edu_user_role")
public class UserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "userRoleId",value = "")
	private Long userRoleId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userRoleUserid",value = "")
	private Long userRoleUserid;
	/**
	 * 
	 */
	@ApiModelProperty(name = "userRoleRole",value = "")
	private Long userRoleRole;

}
