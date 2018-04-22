package im.yan.modules.dorm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("tb_xs_pl")
public class DxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long openid;
	private String xh;
	private String ssh;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getOpenid() {
		return openid;
	}

	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getSsh() {
		return ssh;
	}

	public void setSsh(String ssh) {
		this.ssh = ssh;
	}
}
