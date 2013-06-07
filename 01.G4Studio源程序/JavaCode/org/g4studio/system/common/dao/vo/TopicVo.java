package org.g4studio.system.common.dao.vo;

import java.sql.Timestamp;

import org.g4studio.core.metatype.BaseVo;

/**
 * 项目主页:社区主题VO
 * 
 * @author XiongChun
 * @since 2010-12-25
 */
public class TopicVo extends BaseVo {

	private Integer topicid;
	private String topictype;
	private String locked;
	private String userid;
	private String username;
	private String replyable;
	private Timestamp addtime;
	private Integer sortno;
	private Integer replycount;
	private Integer viewcount;
	private String title;
	private String content;
	private String content2;

	public Integer getTopicid() {
		return topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public String getTopictype() {
		return topictype;
	}

	public void setTopictype(String topictype) {
		this.topictype = topictype;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReplyable() {
		return replyable;
	}

	public void setReplyable(String replyable) {
		this.replyable = replyable;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getSortno() {
		return sortno;
	}

	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}

	public Integer getReplycount() {
		return replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

}
