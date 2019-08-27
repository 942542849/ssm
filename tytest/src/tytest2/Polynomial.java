package tytest2;



public class Polynomial {
	Polynomial next;
	 double data; // 系数值
	 int power; // 幂值
	 public Polynomial(){
		 this(0.0, -1);
	 }
	 
	 public Polynomial(double data, int power){
		 this.data = data;
		 this.power = power;
		 this.next = null;
	 }
	 
	 public Polynomial(double data, int power, Polynomial next){
		 this.data = data;
		 this.power = power;
		 this.next = next;
	 }
	 
	 public String toString(){
		 return "data = "+data+"，power = "+power;
	 }
}