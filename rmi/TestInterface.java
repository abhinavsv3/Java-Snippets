import java.rmi.*;
public interface TestInterface extends Remote
{
	public int add(int a,int b) throws Exception;
}