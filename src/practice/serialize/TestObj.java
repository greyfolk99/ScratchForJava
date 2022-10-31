package practice.serialize;
import java.io.Serializable;
import java.util.Objects;

public class TestObj implements Serializable{
	/**
	 * serialVersionUID = 직렬화 버전
	 */
	private static final long serialVersionUID = 1L;
	private String data1;
	private String data2;
	public TestObj(String data1, String data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	@Override
	public String toString() {
		return "TestObj [data1=" + data1 + ", data2=" + data2 + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(data1, data2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestObj other = (TestObj) obj;
		return Objects.equals(data1, other.data1) && Objects.equals(data2, other.data2);
	}
	
}
