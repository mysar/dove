package im.yan.modules.footer.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-07 17:54:59
 */
@TableName("tab_building")
public class TabBuildingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer openid;
	/**
	 * 
	 */
	private String name;
	/**
	 * 0女生1男生2混合宿舍楼
	 */
	private String mark;
	/**
	 * 
	 */
	private String capacity;
	/**
	 * 备注信息
	 */
	private String remark;

	/**
	 * 设置：
	 */
	public void setOpenid(Integer openid) {
		this.openid = openid;
	}
	/**
	 * 获取：
	 */
	public Integer getOpenid() {
		return openid;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：0女生1男生2混合宿舍楼
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * 获取：0女生1男生2混合宿舍楼
	 */
	public String getMark() {
		return mark;
	}
	/**
	 * 设置：
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	/**
	 * 获取：
	 */
	public String getCapacity() {
		return capacity;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注信息
	 */
	public String getRemark() {
		return remark;
	}
}
