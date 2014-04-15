import java.rmi.*;
public class TestClient
{
	public static void  main(String ar[])
	{
		try
		{
			TestInterface y=(TestInterface)Naming.lookup("rmi://localhost/Test6");
			System.out.println(y.add(10,20));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}