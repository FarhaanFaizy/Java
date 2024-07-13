import java.util.Random;
public class GenRandom extends Thread
{
	Random random=new Random();
	public int n;
	GenRandom(int n)
	{
		this.n=n;
	}
	public void run()
	{
		for(int i=0;i<n;i++)
		{
			int a=random.nextInt();
			System.out.println(a+" Is RAndom");
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(".");
			}
			if(a%2==0)
			{
				Even e=new Even(a);
			}
			else
			{
				Odd o=new Odd(a);
			}
		}
	}
	public static void main(String[] args)
	{
		GenRandom a=new GenRandom(10);
		a.start();
	}
}
class Even extends Thread
{
	Even(int a)
	{
		System.out.println("Even->square->"+a*a);
	}
}
class Odd extends Thread
{
	Odd(int a)
	{
		System.out.println("Odd->cube->"+a*a*a);
	}
}