package cn.test.web.ws;
public class MessageDuf {
	private String id;
	private String info;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}	
	@Override
	public String toString() {	
		return "{\"id\":\""+this.id+"\",\"info\":\""+this.info+"\"}";
	}
}
