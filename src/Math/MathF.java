package Math;

import java.util.ArrayList;
import java.util.Collections;

public class MathF {
	/**
	 * 
	 */
	private int Ds, es, ps, ms, ds;
	private ArrayList<Double> rsT; // ������� ��������������
	private double tKor; // �������� ����������
	private int lB, rB; // Left and Right boundaries to rsT
	/**
	 * ������������������ ������� ��������
	 */
	private ArrayList<Integer> list;
	/**
	 * �����������
	 * @param list ������ �������������� ��������
	 */
	public MathF(ArrayList<Integer> list) {
		this.list = list;
		
	}
	/**
	 * ��������� ��������
	 */
	private void Calculate() {
		lB = -20;
		rB = 20;
		
		rsT = new ArrayList<>();
		
		Ds = Collections.max(list) - Collections.min(list);
		for (Integer i : list) {
			es += Math.pow(i, 2);
			ms += i;
			
		}
		ps = es / list.size();
		ms /= list.size();
		for (Integer i : list) {
			ds += Math.pow(i - ms, 2);
		}
		ds /= list.size();
		
		for(; lB < rB; lB++) {
			rsT.add(autokorFunc(list.size(), Math.abs(lB), list, ms));
		}
		
		tKor = rsT.stream().reduce(.0, (a, b) -> a + b) / rsT.get(0);
	}
	
	private double autokorFunc(int n, int t, ArrayList<Integer> s, int m) {
		double res = 0;
		for (int i = 0; i < n - t - 1; i++) {
			res += (s.get(i + t) - m) * (s.get(i) - m);
		}
		return (1 / (n - t * 1.0)) * res;
	}
	
	/**
	 * ����� �����������
	 * @return ��������������� ������ �����������
	 */
	public String GetResults() {
		Calculate();
				
		return "������������ �������� �������: " + Ds + "\r\n"
			+ "������� �������: " + es + "\r\n"
			+ "������� �������� �������: " + ps + "\r\n"
			+ "������� �������� �������� �������: " + ms + "\r\n"
			+ "��������� �������� �������� �������: " + ds + "\r\n"
			+ "������� �������������� ����������� ������� ��� t [-20; 20]:\r\n\t"
			+ funcValsToString(rsT) + "\r\n"
			+ "�������� ����������: " + tKor;
		
	}
	
	private String funcValsToString(ArrayList<Double> l) {
		String res = "[";
		
		for(int i = 0; i < l.size(); i++)
			res += l.get(i) + ";\r\n\t";
		
		return res + "]";
	}
}
