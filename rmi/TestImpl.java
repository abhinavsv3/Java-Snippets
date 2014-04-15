import java.rmi.*;
import java.rmi.server.*;
public class TestImpl extends UnicastRemoteObject implements TestInterface
{
	public TestImpl() throws Exception
	{ }
	public int add(int a,int b)throws Exception
	{
		System.out.println("This");
		return a+b;
	}
	
}
