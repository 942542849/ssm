package al;


	import java.util.*;
	import java.util.List;
	public class Main {
	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	    /**
	     * ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨��
	     **/
	    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
			String a=null;
			int b = 0;
	    	for(int i=0;i<xList.size();i++) {
				Double xi=xList.get(i);
				Double yi=xList.get(i);
				if(x==xi&&y==yi) {
					a="yes";
					b=0;
				}else {
					return "no  1";
				}
				
				
					
				
			}
				
			return a+b;	
	    }


	  


		public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String line = in.nextLine();
	        //(x,y)ΪС�����ڵ�λ��
	        double x = Double.parseDouble(line.split(",")[0]);
	        double y = Double.parseDouble(line.split(",")[1]);

	        line = in.nextLine();
	        //xList��¼�˶����n�����x����,yList��¼�˶����n�����y����
	        List<Double> xList = new ArrayList<>();
	        List<Double> yList = new ArrayList<>();
	        String[] array = line.split(",");
	        for(int i = 0; i < array.length; i++) {
	            xList.add(Double.parseDouble(array[i]));
	            yList.add(Double.parseDouble(array[i+1]));
	            i++;
	        }
	        in.close();
	        System.out.println(measureDistance(xList, yList, x, y));
	    }
	}

