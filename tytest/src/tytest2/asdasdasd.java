package tytest2;

public class asdasdasd {
	public static double polynomial1D(double[] para,double x){
        double result=0;
        for(int i=para.length-1;i>=0;i--){
            result=result*x+para[i];
        }
        return result;
    }
	 public static double polynomial2D(double[][] para,double x,double y){
	        double result=0;
	        int nx=para.length;
	        for(int i=nx-1;i>=0;i--){
	            result=result*x+polynomial1D(para[i],y);
	        }
	        return result;
	    }
	 public static double[] polynomial_mul(double[] a,double[] b){
	        int na=a.length;
	        int nb=b.length;
	        double[] r=new double[na+nb-1];//�½�һ���˻�����ʽ�������飬����Ԫ�صĸ�����na+nb-1
	        for(int i=0;i<na+nb-1;i++){
	            r[i]=0.0;//�����ʼ��
	        }
	        for(int j=0;j<na;j++){
	            for(int k=0;k<nb;k++){
	                r[j+k]+=a[j]*b[k];//�����ˣ��ۼ�
	            }
	        }

	        return r;
	    }

	
	    public static void main(String[] args) {
	    	 double b[][]={{1,2,3},{4,5,6}};
		        System.out.println(polynomial2D(b, 1, 2));
		}
	    /**
	     * ���Զ���ʽ�˷�
	     */
	    public static void test3(){
	        double a[]={1,2,3};
	        double b[]={3,2,6};
	        double[] r=polynomial_mul(a, b);
	        for(double d:r){
	            System.out.println(d);
	        }
	    }
	
}
