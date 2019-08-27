package tytest2;

// import java.util.InputMismatchException;
import java.util.Scanner;

public class Util 
{
	// Polynomial p;
	Scanner input = new Scanner(System.in);
	public Util()
	{
		// p = new Polynomial(); 
	}
	
	/**
	 * 1. 判断多项式中是否存在该幂数的项数 
	 * @param power 幂数
	 * @param p 链表
	 * @return 是否存在power相同的项数
	 * 
	 * complete
	 */
	private boolean locateElem(int power, Polynomial p)
	{
		Polynomial current = p.next;
		/*         // 不需要判断power是否小于0
 		if(power<0)
			return false;
		*/
		while(current!=null)
		{
			if(current.power == power)
				return true;
			current = current.next;
		}
		return false;
	}
	
	
	/**
	 * 2.做相加的操作
	 * @param data
	 * @param power
	 * @param current
	 * @param previous
	 * @return
	 */
	private boolean addElem(double data, int power, Polynomial current, Polynomial previous)
	{
		if(power == current.power)
		{
			current.data = current.data + data;
			if(0 == current.data && previous != null)
				previous.next = current.next;
			if(0 == current.data && previous == null)
				current = current.next;
			return true;
		}

		return false;
	}
	private void addAllElem(double data, int power, Polynomial p)
	{
		Polynomial current;
		Polynomial previous;
		current = p;
		previous = p;
		while(current!=null && power!=current.power)
		{
			previous = current;
			current = current.next;
		}
		current.data = current.data + data;
		if(0 == current.data && current!=previous) // 当current的next为0的时候和current为头节点
			previous.next = current.next;
		else
			p = current.next;
	}
	
	private boolean subElem(double data, int power, Polynomial current, Polynomial previous)
	{
		if(power == current.power)
		{
			current.data = current.data - data;
			if(0 == current.data && previous != null)
				previous.next = current.next;
			else
				current = current.next;
			return true;
		}

		return false;
	}
	
	// 4. 多项式的相乘操作  这里的p应该存放的是b中的多项式节点
	private void mulElem(double data1, int power1, double data2, int power2, Polynomial p) 
	{
		p.data = data1*data2;
		p.power = power1+power2;
	}
	
	
	/** 5. 在不存在相同幂数的情况下进行插入的操作
	 * 特殊的插入 可以在链表只有头结点的时候在第一个位置进行插入
	 * @param data
	 * @param power
	 * @param p
	 * @return
	 * 
	 * complete
	 */
	private boolean insertElem(double data, int power, Polynomial p)
	{
		Polynomial current;
		Polynomial temp = new Polynomial(data, power, null);
		Polynomial previous;
		current = p;
		// 1.首先判断不存在首元节点的情况
		if(current.next == null)
		{
			current.next = temp;
			return true;
		}
		previous = p;
		current = p.next;	
		while( current!=null && current.power<power)
		{
			previous = current;
			current = current.next;
		}
		previous.next = temp;
		temp.next=current;
		return true;
			
	}
	

	/**
	 * 6. 比较当前两个节点谁的power更大  前者大返回 1； 后者大返回-1；一样大返回0；
	 * 
	 * @param a 链表的一个节点
	 * @param b 链表的一个节点
	 * @return 1、0或者-1
	 * 
	 * complete
	 */
	private int getCurElem(Polynomial a, Polynomial b)
	{
		if( a.power>b.power )
			return 1;
		else if( a.power<b.power )
			return -1;
		else 
			return 0;
		
	}
	
	
	// -----------------------------------

	 

	/**
	 *  1. 输入m项的data和power建立一元多项式
	 * @param m
	 * @param p
	 * 
	 * complete
	 */
	public void createPolyn(int m, Polynomial p)
	{
		double data;
		int power;
		// 正序
		for(int i=0; i<m; i++)
		{
	
			System.out.print("请输入第"+(i+1)+"系数：");
			data = input.nextDouble();

			if( 0==data )
			{
				System.out.println("系数不能为0");
				continue;
			}
			System.out.print("请输入第"+(i+1)+"幂数：");
			power = input.nextInt();
			
			if(locateElem(power, p)) // 如果存在power相同的
			{
				addAllElem(data, power, p);
			}
			else
			{
				insertElem(data, power, p);
			}
		
			
		}
	}
	
	
	/**
	 * 2. 销毁一元多项式
	 * @param p
	 * 
	 * complete
	 */
	public void destroyPolyn(Polynomial p)
	{
		p.next = null;
		p = null;
	}
	
	
	/**
	 * 3. 打印输出一元多项式
	 * @param p
	 * 
	 * complete
	 */
	public void printPolyn(Polynomial p)
	{
		Polynomial current;
		current = p.next;
		int count = 0;
		while(current!=null)
		{
			if( current.data>0 )
			{
				if(0 == count)
				{
					System.out.print(current.data+"x^"+current.power);
					count++;
				}
				else
				{
					System.out.print("+"+current.data+"x^"+current.power);
				}
			}	
			if( current.data<0 )
			{
				if(0 == count)
				{
					System.out.print(current.data+"x^"+current.power);
					count++;
				}
				else
				{
					System.out.print(current.data+"x^"+current.power);
				}
			}	
			current = current.next;
		}
		System.out.println();
	}
	
	
	/**
	 * 4. 返回一元多项式的项数 
	 * @param p
	 * @return
	 * 
	 * complete
	 */
	public int polynLength(Polynomial p)
	{
		Polynomial current = p.next;
		int count = 0;
		while(current!=null)
		{
			count++;
			current = current.next;
		}
		return count;
	}
	/*
	 * Polynomial a = ...;
	 * h = a;
	 * 后面修改h  a中会改变
	 * 
	 * Polynomial a = ...;
	 * h = a;
	 * 后面修改a  h中会改变
	 * 
	 * 在计算力不够的时候，牢记引用变量的名字都代表地址，地址直接操作的改变
	 * 会对所有指向这个地址的引用类型的变量都造成修改。
	 * 引用类型变量（名字）的值可以修改（修改装的对象：即地址）
	 * 
	 */
	/**
	 * 
	 * @param a
	 * @param b
	 * 
	 * complete
	 */
	public void addPolyn(Polynomial a, Polynomial b)
	{
		Polynomial currenta = a.next;
		Polynomial currentb = b.next;
		Polynomial previousa = a;  // 保存a的前驱
		/*
		 * 在将当前（currentb）插入到a链表中之后
		 * 当前的currentb中的后继就被链接到了a链表之后了
		 * 所以在操作currentb之前我们需要将currentb的后继存储到一个后继节点对象中去
		 * 在每次循环的时候，再将后继（subsequenctb）赋给currentb
		 * */
		Polynomial subsequentb = currentb.next;
		while(currentb != null)
		{
			if(getCurElem(currenta, currentb)<0) // 如果currenta小于当前的currentb
			{
				// 将currenta移向next
				previousa = currenta;
				currenta = currenta.next;
				/*
				 * 当currenta.next为空的时候，说明currentb比currenta中的所有元素都要大
				 * 将currentb插入到currenta的后面
				 */
				// if(getCurElem(currenta, currentb)>0)  continue;
				// 当currenta.next 为null 但是currenta大于currentb的时候
				
				if(currenta.next == null && getCurElem(currenta, currentb)<0) // 在a的最后一个元素都比b的第一个元素小的时候
				{
					insertElem(currentb.data, currentb.power, currenta);
					currentb = currentb.next;
					currentb = subsequentb; // 插入之后currentb本身没有从链表上断开
					if(currentb!=null)
					{
						subsequentb = currentb.next;
					}
					
						
				}
				// 第一次currenta移向next的操作结束之后，currenta依旧可能比currentb小
			}
			/*
			 * 这里的currenta大于currentb处于刚好的临界条件
			 * 所以必然此刻的currentb处于previousa和currenta之间
			 */
			
			else if(getCurElem(currenta, currentb)>0) // 如果currenta大于当前的currentb
			{
				/*
				 * 将currentb连接到previousa和currenta之间
				 */
				previousa.next = currentb; 
				currentb.next = currenta;  
				
				/*
				 * 因为已经将currentb插入到了previousa和currenta之间了
				 * 所以此刻的previousa不是等于currenta 应该等于此刻的currentb
				 * 
				 * 最后将currentb的指向重新赋值为b的后继 subsequentb
				 */
				previousa = currentb;
				currentb = subsequentb;
				// 做currentb的后继的赋值的操作必须先判断currentb是否为空，为空的话取后继为造成空指针
				if(currentb != null) 
					subsequentb = currentb.next;	
			}
			else
			{
				addElem(currentb.data, currentb.power, currenta, previousa);
				currentb = currentb.next;
			}
		}
		b.next = null;
	}// 5. 将两个一元多项式相加 Pa = Pa + Pb; 并且销毁Pb
	
	public void subPolyn(Polynomial a, Polynomial b)
	{
		Polynomial currenta = a.next;
		Polynomial currentb = b.next;
		Polynomial previousa = a;  // 保存a的前驱
		/*
		 * 在将当前（currentb）插入到a链表中之后
		 * 当前的currentb中的后继就被链接到了a链表之后了
		 * 所以在操作currentb之前我们需要将currentb的后继存储到一个后继节点对象中去
		 * 在每次循环的时候，再将后继（subsequenctb）赋给currentb
		 * */
		Polynomial subsequentb = currentb.next;
		while(currentb != null)
		{
			if(getCurElem(currenta, currentb)<0) // 如果currenta小于当前的currentb
			{
				// 将currenta移向next
				previousa = currenta;
				currenta = currenta.next;
				/*
				 * 当currenta.next为空的时候，说明currentb比currenta中的所有元素都要大
				 * 将currentb插入到currenta的后面
				 */
				// if(getCurElem(currenta, currentb)>0)  continue;
				// 当currenta.next 为null 但是currenta大于currentb的时候
				
				if(currenta.next == null && getCurElem(currenta, currentb)<0) // 在a的最后一个元素都比b的第一个元素小的时候
				{
					insertElem(-currentb.data, currentb.power, currenta);
					currentb = currentb.next;
					currentb = subsequentb; // 插入之后currentb本身没有从链表上断开
					if(currentb!=null)
					{
						subsequentb = currentb.next;
					}
					
						
				}
				// 第一次currenta移向next的操作结束之后，currenta依旧可能比currentb小
			}
			/*
			 * 这里的currenta大于currentb处于刚好的临界条件
			 * 所以必然此刻的currentb处于previousa和currenta之间
			 */
			
			else if(getCurElem(currenta, currentb)>0) // 如果currenta大于当前的currentb
			{
				/*
				 * 将currentb连接到previousa和currenta之间
				 */
				currentb.data = -currentb.data;
				previousa.next = currentb; 
				currentb.next = currenta;  
				
				/*
				 * 因为已经将currentb插入到了previousa和currenta之间了
				 * 所以此刻的previousa不是等于currenta 应该等于此刻的currentb
				 * 
				 * 最后将currentb的指向重新赋值为b的后继 subsequentb
				 */
				previousa = currentb;
				currentb = subsequentb;
				// 做currentb的后继的赋值的操作必须先判断currentb是否为空，为空的话取后继为造成空指针
				if(currentb != null) 
					subsequentb = currentb.next;	
			}
			else
			{
				subElem(currentb.data, currentb.power, currenta, previousa);
				currentb = currentb.next;
			}
		}
		b.next = null;
		
	}// 6. 将两个一元多项式相减 Pa = Pa - Pb; 并且销毁Pb
	/*
		Polynomial a 引用类型的变量相当于C语言中的指针，a代表的是对应的地址
		a的地址不能被修改，只能修改a对应的地址的值， 所以下面的a被我们修改了
		所以必须重新返回一个Polynomial类型的a。
	*/
	// public Polynomial multiplyPolyn(Polynomial a, Polynomial b)
	public void multiplyPolyn(Polynomial a, Polynomial b)
	{
		Polynomial currenta = a.next;
		Polynomial currentb = b.next;
		Polynomial current = new Polynomial();
		
		Polynomial subsequentb = currentb.next;
		Polynomial temp = new Polynomial(); 
		temp = current;
		a.next = null;
		while(currenta != null)
		{
			while(currentb != null)
			{
				current.next = new Polynomial();
				mulElem(currenta.data, currenta.power, currentb.data, currentb.power, current.next);
				currentb = currentb.next;
				current = current.next;
			}
			currentb = subsequentb;
			currenta = currenta.next;
			if(currentb != null)
				subsequentb = subsequentb.next;
		}
		/*
		a = temp;	
		temp = null;
		b.next = null;
		return a;
		*/
		
		temp = temp.next;
		a.next = temp;
		b.next = null; // b也不能直接被修改，b也相当于指针
	}// 7. 将两个一元多项式相乘 Pa = Pa * Pb; 并且销毁Pb
}
