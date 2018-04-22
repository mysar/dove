package im.yan.modules.footer.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-07 17:54:59
 */
@TableName("tab_class")
public class TabClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer openid;
	/**
	 * 行政班名称
	 */
	private String name;
	/**
	 * 占用教室
	 */
	private String classroom;
	/**
	 * 是否启动
	 */
	private Integer enable;
	/**
	 * 年级信息
	 */
	private String grade;

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
	 * 设置：行政班名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：行政班名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：占用教室
	 */
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	/**
	 * 获取：占用教室
	 */
	public String getClassroom() {
		return classroom;
	}
	/**
	 * 设置：是否启动
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否启动
	 */
	public Integer getEnable() {
		return enable;
	}
	/**
	 * 设置：年级信息
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：年级信息
	 */
	public String getGrade() {
		return grade;
	}
}
