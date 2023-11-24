package Fila;

import java.util.Scanner;

public class ex5 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Queue qpar = new Queue(30);
		Queue qimpar = new Queue(30);
		Stack s = new Stack(30);
		
		int value = 1, count = 0;
		while(value != 0) {
			value = scan.nextInt();
			
			if(value % 2 == 0) {
				qpar.enqueue(value);
			} else {
				qimpar.enqueue(value);
			}
			
			count++;
		}
		
		for(int i = 0; i < count; i+=2) {
			if(!qimpar.isEmpty()) {
				if(qimpar.front() > 0) {
					s.push(qimpar.dequeue());
				}
			}
			if(!qpar.isEmpty()) {
				if(qpar.front() > 0) {
					s.push(qpar.dequeue());
				}
			}
		}
		
		int tam = s.size();
		for(int i = 0; i < tam; i++) {
			System.out.println(s.pop());
		}
		
		scan.close();
	}
	
}
