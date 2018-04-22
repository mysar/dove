package im.yan.modules.dorm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("tb_xs")
public class XsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long userId;
	private String xh;
	private String xm;
	/**
	 * 住宿id
	 */
	private String dormId;

	private String sex;
	/**
	 * 是否入住
	 */
	private String sfrz;
	/**
	 * 是否少数民族       1：汉族  0: 其他
	 */
	private String sfssmz;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setXh(String xh) {
		this.xh = xh;
	}
	/**
	 * 获取：
	 */
	public String getXh() {
		return xh;
	}
	/**
	 * 设置：
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * 获取：
	 */
	public String getXm() {
		return xm;
	}
	/**
	 * 设置：住宿id
	 */
	public String getDormId() {
		return dormId;
	}

	public void setDormId(String dormId) {
		this.dormId = dormId;
	}

	/**
	 * 设置：
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：是否入住
	 */
	public void setSfrz(String sfrz) {
		this.sfrz = sfrz;
	}
	/**
	 * 获取：是否入住
	 */
	public String getSfrz() {
		return sfrz;
	}
	/**
	 * 设置：是否少数民族       1：汉族  0: 其他
	 */
	public void setSfssmz(String sfssmz) {
		this.sfssmz = sfssmz;
	}
	/**
	 * 获取：是否少数民族       1：汉族  0: 其他
	 */
	public String getSfssmz() {
		return sfssmz;
	}
}
