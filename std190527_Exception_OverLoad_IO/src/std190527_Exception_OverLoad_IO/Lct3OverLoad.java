package std190527_Exception_OverLoad_IO;

public class Lct3OverLoad {
	//	Over Load 
	//	�̰Թ�����?
	//	function�� ��Ī�� ���������� 
	//	�Ű�����(�μ�, ����, Parameter)�� �ڷ����̳� ������ �ٸ� ��
	//	==������
	
	//�����μ� ���� == �μ� 1�� ~ �������� �迭 ���·� ����
	void intdisp(int... n) {
		
	}
	
	static int disp(String str, int... num) {
		int sum = 0 ;
		for(int i = 0 ; i < num.length ; i++) {
			sum+=num[i];
		}
		System.out.println("String : " + str + "\t" + sum);
		return sum;
	}
	
	public static void main(String[] args) {
		disp("ggggg", 30,1,2,3,4);
	}
}
