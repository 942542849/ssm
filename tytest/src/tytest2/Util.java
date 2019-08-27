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
	 * 1. �ж϶���ʽ���Ƿ���ڸ����������� 
	 * @param power ����
	 * @param p ����
	 * @return �Ƿ����power��ͬ������
	 * 
	 * complete
	 */
	private boolean locateElem(int power, Polynomial p)
	{
		Polynomial current = p.next;
		/*         // ����Ҫ�ж�power�Ƿ�С��0
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
	 * 2.����ӵĲ���
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
		if(0 == current.data && current!=previous) // ��current��nextΪ0��ʱ���currentΪͷ�ڵ�
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
	
	// 4. ����ʽ����˲���  �����pӦ�ô�ŵ���b�еĶ���ʽ�ڵ�
	private void mulElem(double data1, int power1, double data2, int power2, Polynomial p) 
	{
		p.data = data1*data2;
		p.power = power1+power2;
	}
	
	
	/** 5. �ڲ�������ͬ����������½��в���Ĳ���
	 * ����Ĳ��� ����������ֻ��ͷ����ʱ���ڵ�һ��λ�ý��в���
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
		// 1.�����жϲ�������Ԫ�ڵ�����
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
	 * 6. �Ƚϵ�ǰ�����ڵ�˭��power����  ǰ�ߴ󷵻� 1�� ���ߴ󷵻�-1��һ���󷵻�0��
	 * 
	 * @param a �����һ���ڵ�
	 * @param b �����һ���ڵ�
	 * @return 1��0����-1
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
	 *  1. ����m���data��power����һԪ����ʽ
	 * @param m
	 * @param p
	 * 
	 * complete
	 */
	public void createPolyn(int m, Polynomial p)
	{
		double data;
		int power;
		// ����
		for(int i=0; i<m; i++)
		{
	
			System.out.print("�������"+(i+1)+"ϵ����");
			data = input.nextDouble();

			if( 0==data )
			{
				System.out.println("ϵ������Ϊ0");
				continue;
			}
			System.out.print("�������"+(i+1)+"������");
			power = input.nextInt();
			
			if(locateElem(power, p)) // �������power��ͬ��
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
	 * 2. ����һԪ����ʽ
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
	 * 3. ��ӡ���һԪ����ʽ
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
	 * 4. ����һԪ����ʽ������ 
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
	 * �����޸�h  a�л�ı�
	 * 
	 * Polynomial a = ...;
	 * h = a;
	 * �����޸�a  h�л�ı�
	 * 
	 * �ڼ�����������ʱ���μ����ñ��������ֶ������ַ����ֱַ�Ӳ����ĸı�
	 * �������ָ�������ַ���������͵ı���������޸ġ�
	 * �������ͱ��������֣���ֵ�����޸ģ��޸�װ�Ķ��󣺼���ַ��
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
		Polynomial previousa = a;  // ����a��ǰ��
		/*
		 * �ڽ���ǰ��currentb�����뵽a������֮��
		 * ��ǰ��currentb�еĺ�̾ͱ����ӵ���a����֮����
		 * �����ڲ���currentb֮ǰ������Ҫ��currentb�ĺ�̴洢��һ����̽ڵ������ȥ
		 * ��ÿ��ѭ����ʱ���ٽ���̣�subsequenctb������currentb
		 * */
		Polynomial subsequentb = currentb.next;
		while(currentb != null)
		{
			if(getCurElem(currenta, currentb)<0) // ���currentaС�ڵ�ǰ��currentb
			{
				// ��currenta����next
				previousa = currenta;
				currenta = currenta.next;
				/*
				 * ��currenta.nextΪ�յ�ʱ��˵��currentb��currenta�е�����Ԫ�ض�Ҫ��
				 * ��currentb���뵽currenta�ĺ���
				 */
				// if(getCurElem(currenta, currentb)>0)  continue;
				// ��currenta.next Ϊnull ����currenta����currentb��ʱ��
				
				if(currenta.next == null && getCurElem(currenta, currentb)<0) // ��a�����һ��Ԫ�ض���b�ĵ�һ��Ԫ��С��ʱ��
				{
					insertElem(currentb.data, currentb.power, currenta);
					currentb = currentb.next;
					currentb = subsequentb; // ����֮��currentb����û�д������϶Ͽ�
					if(currentb!=null)
					{
						subsequentb = currentb.next;
					}
					
						
				}
				// ��һ��currenta����next�Ĳ�������֮��currenta���ɿ��ܱ�currentbС
			}
			/*
			 * �����currenta����currentb���ڸպõ��ٽ�����
			 * ���Ա�Ȼ�˿̵�currentb����previousa��currenta֮��
			 */
			
			else if(getCurElem(currenta, currentb)>0) // ���currenta���ڵ�ǰ��currentb
			{
				/*
				 * ��currentb���ӵ�previousa��currenta֮��
				 */
				previousa.next = currentb; 
				currentb.next = currenta;  
				
				/*
				 * ��Ϊ�Ѿ���currentb���뵽��previousa��currenta֮����
				 * ���Դ˿̵�previousa���ǵ���currenta Ӧ�õ��ڴ˿̵�currentb
				 * 
				 * ���currentb��ָ�����¸�ֵΪb�ĺ�� subsequentb
				 */
				previousa = currentb;
				currentb = subsequentb;
				// ��currentb�ĺ�̵ĸ�ֵ�Ĳ����������ж�currentb�Ƿ�Ϊ�գ�Ϊ�յĻ�ȡ���Ϊ��ɿ�ָ��
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
	}// 5. ������һԪ����ʽ��� Pa = Pa + Pb; ��������Pb
	
	public void subPolyn(Polynomial a, Polynomial b)
	{
		Polynomial currenta = a.next;
		Polynomial currentb = b.next;
		Polynomial previousa = a;  // ����a��ǰ��
		/*
		 * �ڽ���ǰ��currentb�����뵽a������֮��
		 * ��ǰ��currentb�еĺ�̾ͱ����ӵ���a����֮����
		 * �����ڲ���currentb֮ǰ������Ҫ��currentb�ĺ�̴洢��һ����̽ڵ������ȥ
		 * ��ÿ��ѭ����ʱ���ٽ���̣�subsequenctb������currentb
		 * */
		Polynomial subsequentb = currentb.next;
		while(currentb != null)
		{
			if(getCurElem(currenta, currentb)<0) // ���currentaС�ڵ�ǰ��currentb
			{
				// ��currenta����next
				previousa = currenta;
				currenta = currenta.next;
				/*
				 * ��currenta.nextΪ�յ�ʱ��˵��currentb��currenta�е�����Ԫ�ض�Ҫ��
				 * ��currentb���뵽currenta�ĺ���
				 */
				// if(getCurElem(currenta, currentb)>0)  continue;
				// ��currenta.next Ϊnull ����currenta����currentb��ʱ��
				
				if(currenta.next == null && getCurElem(currenta, currentb)<0) // ��a�����һ��Ԫ�ض���b�ĵ�һ��Ԫ��С��ʱ��
				{
					insertElem(-currentb.data, currentb.power, currenta);
					currentb = currentb.next;
					currentb = subsequentb; // ����֮��currentb����û�д������϶Ͽ�
					if(currentb!=null)
					{
						subsequentb = currentb.next;
					}
					
						
				}
				// ��һ��currenta����next�Ĳ�������֮��currenta���ɿ��ܱ�currentbС
			}
			/*
			 * �����currenta����currentb���ڸպõ��ٽ�����
			 * ���Ա�Ȼ�˿̵�currentb����previousa��currenta֮��
			 */
			
			else if(getCurElem(currenta, currentb)>0) // ���currenta���ڵ�ǰ��currentb
			{
				/*
				 * ��currentb���ӵ�previousa��currenta֮��
				 */
				currentb.data = -currentb.data;
				previousa.next = currentb; 
				currentb.next = currenta;  
				
				/*
				 * ��Ϊ�Ѿ���currentb���뵽��previousa��currenta֮����
				 * ���Դ˿̵�previousa���ǵ���currenta Ӧ�õ��ڴ˿̵�currentb
				 * 
				 * ���currentb��ָ�����¸�ֵΪb�ĺ�� subsequentb
				 */
				previousa = currentb;
				currentb = subsequentb;
				// ��currentb�ĺ�̵ĸ�ֵ�Ĳ����������ж�currentb�Ƿ�Ϊ�գ�Ϊ�յĻ�ȡ���Ϊ��ɿ�ָ��
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
		
	}// 6. ������һԪ����ʽ��� Pa = Pa - Pb; ��������Pb
	/*
		Polynomial a �������͵ı����൱��C�����е�ָ�룬a������Ƕ�Ӧ�ĵ�ַ
		a�ĵ�ַ���ܱ��޸ģ�ֻ���޸�a��Ӧ�ĵ�ַ��ֵ�� ���������a�������޸���
		���Ա������·���һ��Polynomial���͵�a��
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
		b.next = null; // bҲ����ֱ�ӱ��޸ģ�bҲ�൱��ָ��
	}// 7. ������һԪ����ʽ��� Pa = Pa * Pb; ��������Pb
}
