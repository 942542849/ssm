package tytest2;

public class asad {
	public static void main(String[] args) {
		Util u = new Util();
		/*
		Polynomial p = new Polynomial();
		u.createPolyn(3,p);
		System.out.println(u.polynLength(p));
		u.printPolyn(p);
		u.destroyPolyn(p);
		u.printPolyn(p);
		*/
		Polynomial a = new Polynomial();
		u.createPolyn(3, a);

		Polynomial b = new Polynomial();
		u.createPolyn(3, b);

		// u.addPolyn(a, b);
		// u.subPolyn(a, b);
		u.multiplyPolyn(a, b);
		u.printPolyn(a);
		// u.printPolyn(b);
		
	}
}
