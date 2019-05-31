package work5Point3D;

public class Point3D {
	int x, y, z;

	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	Point3D() {
		this(0, 0, 0);
	}
	
	
	//(1) �ν��Ͻ����� x, y, z�� ���ϵ��� �������̵��Ͻÿ�.

	public boolean equals(Point3D inputP) {
		if( inputP.x == this.x && inputP.y == this.y && inputP.z == this.z) {
			return true;
		}else {
			return false;	
		}	
	}
	
	//(2) �ν��Ͻ����� x, y, z�� ������ ����ϵ��� �������̵��Ͻÿ�.
	@Override
	public String toString() {
		return this.hashCode() + " ["+ "x: "+this.x + " y: " + this.y + " z: " + this.z + "]";
	}


}
