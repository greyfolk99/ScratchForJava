package practice.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
/**
 * 	Serialization (직렬화)
	 자바 시스템 메모리에 상주해있는 객체나 데이터를 바이트의 형태로 변환하는 것. 
	 반대로 바이트의 형태를 객체나 데이터로 변하는 것은 역직렬화라한다. 
	 비슷하게, 테이블 형태의 데이터를 직렬화하는 것은 CSV, 
	 통신에 사용하기 위해 사용하는 것은 JSON이 있다. 
	 자바에서의 직렬화는 자바 시스템 간의 데이터 교환을 위한 것이다.
	
	Object -> writeObject (인코딩) -> DB / File / Memory -> readObject (디코딩) -> Object

	when? 
	 자바 시스템이 종료되어도 해당 객체 / 데이터가 남아있어야할 때,
	 네트워크로 전송해야할 때 직렬화하여 영속화(Persistence)한다.
	 특히 Class를 그대로 DB에 넣고, 같은 혹은 다른 자바 시스템에서 이 Class를 사용하고싶다면 
	 직렬화하여 바이트의 형태로 DB에 저장한 뒤, 사용할 때는 DB에 있는 바이트의 데이터를 역직렬화하여 사용한다. 
	
	why?
	 사실 여러 일반적인 직렬화 (JSON 같이)을 사용할 수 있겠지만, 
	 자바 직렬화를 쓰는 이유는 이름에서부터 유추할 수 있듯이 자바 시스템에서 최적화 되어있기 때문이다. 
	 특히, 클래스의 객체가 복잡해지는 경우, JSON 등으로 저장하기는 까다롭겠지만 자바 직렬화를 사용한다면 
	 강타입으로도 저장이 가능하기 때문에 매우 편리하다.
	
	why not?
	 유지보수성
	 테스트
	 그 외 다수 (ex. 싱글톤 문제, 역직렬화 폭탄 등)
	 - 싱글톤 (역직렬화를 거치면 싱글톤 객체의 성격이 없어진다.)
	
	결론 : json,xml 같은 크로스 커뮤니케이션이 가능한 포맷을 이용하는걸 권장
 */
public class Main {

	public static void main(String[] args) {
		TestObj inputObj = new TestObj("hi","hello");
		System.out.println(inputObj); // TestObj [data1=hi, data2=hello]
		String result = Base64.getEncoder().encodeToString(toSerialize(inputObj));
		System.out.println(result); // 직렬화된 데이터
		TestObj outputObj = (TestObj) toDeserialize(Base64.getDecoder().decode(result));
		System.out.println(outputObj); // TestObj [data1=hi, data2=hello]
		System.out.println(inputObj.equals(outputObj)); // true
	}
	
	public static <T> byte[] toSerialize(T obj) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                //직렬화(object -> byte[])
				oos.writeObject(obj);
				return baos.toByteArray();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object toDeserialize(byte[] serialized) {
		try(ByteArrayInputStream bais = new ByteArrayInputStream(serialized)) {
            try(ObjectInputStream ois = new ObjectInputStream(bais)) {
                //역직렬화(byte[] -> object)
                return ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	

}
