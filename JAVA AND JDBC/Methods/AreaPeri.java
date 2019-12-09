class AreaPeri{
	static double areaCircle(int r){
		double area=3.142*r*r;
		return area;
	}

	static double perimeterCircle(int r){
		double perimeter=2*3.142*r;
		return perimeter;
	}
	static int areaRect(int l, int b){
		int area=l*b;
		return area;
	}
	static int periRect(int l, int b){
		int perimeter=2*(l+b);
		return perimeter;
	}
	static int areaSquare(int l){
		int area=l*l;
		return area;
	}

	static int periSquare(int l){
		int perimeter=4*l;
		return perimeter;
	}
	
	public static void main(String []arr){
		double d=areaCircle(10);
		double e=perimeterCircle(10);
		int a= areaRect(20,30);
		int b= periRect(20,30);
		int c= areaSquare(20);
		int x= periSquare(30);
		System.out.println("area of circle= "+d);
		System.out.println("perimeter of circle= "+e);
		System.out.println("area rectangle= "+a);
		System.out.println("perimeter of rectangle= "+b);
		System.out.println("area square= "+c);
		System.out.println("perimeter square= "+x);
	}
}