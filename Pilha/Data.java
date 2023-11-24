package Pilha;

public class Data {
	
	public static boolean palindromoData(String data) {
		Stack d = new Stack(data.length());
		
		for(int i = 0; i < data.length(); i++) {
			d.push(data.charAt(i));
		}
		
		for(int i = 0; i < data.length(); i++) {
			if(data.charAt(i) != d.pop()) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String data = "12/02/2021";
		
		data = data.replaceAll("/", "");
		System.out.println(palindromoData(data));
	}

}
