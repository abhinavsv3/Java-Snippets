import java.lang.*;
import java.util.*;
import java.io.*;

class Hamming 
{
   public static void main(String ar[])
   {
		try{
			int k=1;
			int numD;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			numD=Integer.parseInt(br.readLine());
			int y=0;
			while(k-1 < (numD + y))
			{
				y++;k<<=1;
			}
			System.out.println("Y Out" + y);
			
			k>>>=1;
			int[] c = new int[y+numD+1];
			int tot = y+numD;
			System.out.println("Bits : " + y + " k: " + k);
			for(int i=1;i<=tot;i++)
			{
			    if(((i)&(i-1)) != 0){
					System.out.println("Enter the Databit here : " + i);
						c[i] = Integer.parseInt(br.readLine());
				}
				else 
					c[i]=0;
			}
			int l=1,temp=0;
			for(int i=1;i<=tot;i++)
			{
			      l=1;
				for(int j=0;j<y;j++)
				{
					if(((l&i)&((l&i)-1)) == 0)					
						c[l]^= c[i];
					l<<=1;
				}
			}
			l=1;
				for(int j=0;j<y;j++)
				{
					
					System.out.println("C"+l+" : "+c[l]);
					l<<=1;
				}
			
		}
		catch(Exception e)
		{	
			System.out.println(e);
		}		
	}
}

