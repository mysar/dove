package im.yan.modules.dorm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


@TableName("tb_dorm")
public class DormEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer dormId;
	/**
	 * 宿舍号
	 */
	private String ssh;
	/**
	 * 宿舍类型     1:女生 2男生 3未定
	 */
	private String type;
	/**
	 * 容纳的人数
	 */
	private Integer rnrs;
	/**
	 * 入住人数
	 */
	private Integer rzrs;
	/**
	 * 入住汉族人数
	 */
	private Integer hzrs;
	/**
	 * 学生
	 */
	private String xs="空";

	/**
	 * 设置：
	 */
	public void setDormId(Integer dormId) {
		this.dormId = dormId;
	}
	/**
	 * 获取：
	 */
	public Integer getDormId() {
		return dormId;
	}
	/**
	 * 设置：宿舍号
	 */
	public void setSsh(String ssh) {
		this.ssh = ssh;
	}
	/**
	 * 获取：宿舍号
	 */
	public String getSsh() {
		return ssh;
	}
	/**
	 * 设置：宿舍类型     1:女生 2男生 3未定
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：宿舍类型     1:女生 2男生 3未定
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：容纳的人数
	 */
	public void setRnrs(Integer rnrs) {
		this.rnrs = rnrs;
	}
	/**
	 * 获取：容纳的人数
	 */
	public Integer getRnrs() {
		return rnrs;
	}
	/**
	 * 设置：入住人数
	 */
	public void setRzrs(Integer rzrs) {
		this.rzrs = rzrs;
	}
	/**
	 * 获取：入住人数
	 */
	public Integer getRzrs() {
		return rzrs;
	}
	/**
	 * 设置：入住汉族人数
	 */
	public void setHzrs(Integer hzrs) {
		this.hzrs = hzrs;
	}
	/**
	 * 获取：入住汉族人数
	 */
	public Integer getHzrs() {
		return hzrs;
	}

	public String getXs() {
		return xs;
	}

	public void setXs(String xs) {
		this.xs = xs;
	}
}
