import java.rmi.*;
public class TestAddServer
{
	public static void  main(String ar[])
	{
		try
		{
			TestImpl t=new TestImpl();
			Naming.rebind("Test6", t);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
