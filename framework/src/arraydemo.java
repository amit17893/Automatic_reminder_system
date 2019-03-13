import java.util.*;
public class arraydemo {
public static void main(String ar[])
{
	List k=new ArrayList();
	k.add("");
	//k.add("amit1");k.add("amit2");
	Iterator i=k.iterator();
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
}
}
