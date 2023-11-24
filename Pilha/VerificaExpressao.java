package Pilha;

public class VerificaExpressao {
	
	public static boolean verifica(String expressao) {	
		StackInt comparadores = new StackInt();
		StackInt chaves = new StackInt();
		StackInt colchetes = new StackInt();
		StackInt parenteses = new StackInt();
		
		char c;
		
		expressao = expressao.replaceAll("\\s+", "");
		
		for(int i = 0; i < expressao.length(); i++) {
			
			c = expressao.charAt(i);
			
			if(c == '(' || c == ')') {
				if(c == '(') {
					parenteses.push(i);
				} else {
					if(parenteses.isEmpty() || (parenteses.top() - i) % 2 == 0) {
						return false;
					} else {
						parenteses.pop();
					}
				}
			} else if(c == '[' || c == ']') {
				if(c == '[') {
					colchetes.push(i);
				} else {
					if(colchetes.isEmpty() || (colchetes.top() - i) % 2 == 0) {
						return false;
					} else {
						colchetes.pop();
					}
				}
			} else if(c == '{' || c == '}') {
				if(c == '{') {
					chaves.push(i);
				} else {
					if(chaves.isEmpty() || (chaves.top() - i) % 2 == 0) {
						return false;
					} else {
						chaves.pop();
					}
				}
			} else if(c == '<' || c == '>') {
				if(c == '<') {
					comparadores.push(i);
				} else {
					if(comparadores.isEmpty() || (comparadores.top() - i) % 2 == 0) {
						return false;
					} else {
						comparadores.pop();
					}
				}
			}
		}
		
		if(parenteses.isEmpty() && colchetes.isEmpty()) {
			if(chaves.isEmpty() && comparadores.isEmpty()) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		String expressao = "{ ( [ { < } > ] ) }";
		System.out.println(verifica(expressao));
	}
}
