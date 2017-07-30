import java.io.*;
import java.util.*;
import java.lang.*;

class stack{
	public static Stack st = new Stack();
	public static int precedenceOf(char ch)
	{
		switch(ch)
		{
			case '+':
			case '-':
			return '1';
			case '*':
			case '/':
			return '2';
			case '^':
			return '3';			
		}
		return -1;
	}
	public static String infixToPostfix(String exp)
	{
		Stack<Character> st1 = new Stack<Character>();
		String result = "";
		for(int i = 0;i < exp.length(); i++)
		{
			char ch = exp.charAt(i);
			if(Character.isLetterOrDigit(ch))
				result += ch;
			else if(ch == '(')
				st1.push(ch);
				else if(ch == ')')
				{
					while(!st1.isEmpty() && st1.peek() != '(')
					{
						result += st1.pop();
					}
					if(!st1.isEmpty() && st1.peek() != '(')
						return "INVALID EXPRESION";
						else	
							st1.pop();
					}
					else
					{

						while(!st1.isEmpty() && precedenceOf(ch) < precedenceOf((Character)st1.peek()))
						{
							if(precedenceOf(ch) == -1 || precedenceOf((Character)st1.peek()) == -1)	
								return "INVALID EXPRESSION";
							result += st1.pop();
						}
						st1.push(ch);
					}
				}
				while(!st1.isEmpty())
				{
					result += st1.pop();
				}
				return result;
			}
			static void insertAtBottom(int x)
			{
					if(st.isEmpty())
						st.push(x);
					else
					{
						int a = (Integer)st.pop();
						insertAtBottom(x);
						st.push(a);
					}
			}
			public static void reverse()
			{
				if(st.size()>0)
				{
					int x = (Integer)st.pop();
					reverse();
					insertAtBottom(x);
				}
			}
			public static void stockSpan(int[] price, int n)
			{
				Stack<Integer> st = new Stack<>();
				int span[] = new int[n];
				st.push(0);
				span[0] = 1;
				for(int i = 1; i < n; i++)
				{
					while(!st.isEmpty() && price[st.peek()] <= price[i])
						st.pop();
					span[i] = (st.isEmpty()) ? i+1 : i-st.peek();
					st.push(i);
				}
				int x = 0;
				while(x < span.length)
				System.out.print(span[x++] + " ");
			}
			public static void towerOfHanoi(int n, char from, char to, char aux)
			{
				if(n == 1)
				{
					System.out.println("Move disk 1 from rod "+from+" to rod "+to);
					return;
				}
				towerOfHanoi(n-1, from, aux, to);
				System.out.println("Move disk "+n+" from rod "+from+" to rod "+to);
				towerOfHanoi(n-1, aux, to, from);
			}
			static void validMaxBracket(String s)
			{
				int result = 0;
				Stack<Integer> st = new Stack<>();
				st.push(-1);
				for(int i = 0; i<s.length(); i++)
				{
					char ch = s.charAt(i);
					if(ch == '(')
					{
						st.push(i);
					}
					else
					{
						st.pop();
						if(!st.isEmpty())
						result = Math.max(result, i-st.peek());
						else
						st.push(i);
					}
				}
				System.out.println("Max length of vaid brackets : "+result);
			}
			public static void main(String args[])
			{
				Scanner sc = new Scanner(System.in);
				int more = 1;
				while(more != 0){
					System.out.println("\nChoices:\n[420]Dummy Stack\n[1]PUSH\n"+
						"[2]POP\n[3]DISPLAY\n[4]PEEK\n[5]INFIX TO POSTFIX\n[6]Reverse stack using recursion"+
						"\n[7]Stock Span\n[8]TOWER OF HANOI\n[9]MAX Valid Length OF BRACKETS");
					int ch = sc.nextInt();
					switch(ch){
						case 420:
						st.push(1);
						st.push(2);
						st.push(3);
						st.push(4);
						st.push(5);
						break;
						case 1 :
						System.out.print("Enter data : ");
						int data = sc.nextInt();
						st.push(data);
						break;
						case 2 :
						System.out.println("Popped data : "+st.pop());
						break;
						case 3 :		
						System.out.println(st);
						break;
						case 4:
						System.out.println("Top : " + st.peek());
						break;
						case 5:
						System.out.println("Enter exp : ");
						String s = sc.next();
						System.out.println(infixToPostfix(s));
						case 6:
						reverse();
						System.out.println(st);
						break;
						case 7:
						System.out.println("[1]Enter stock prices\nOR\n[2]DUMMY stock {100, 60, 70, 30, 120}");
						if(sc.nextInt()==1)
						{
							System.out.println("Enter size of array : \n");
							int n = sc.nextInt();
							int[] price = new int[n];
							for(int i = 0; i < n; i++)
							{
								price[i] = sc.nextInt();	
							}
							stockSpan(price, n);
						}
						else
						{
							int[] price = {100,60,70,30,120};
							stockSpan(price, 5);
						}
						break;
						case 8 :
						System.out.print("Enter number of disks : ");
						towerOfHanoi(sc.nextInt(), 'A', 'C', 'B');
						case 9 :
						System.out.println("Enter a bracket sequence");
						String s1 = sc.next();
						validMaxBracket(s1);
						break;
						default :
						System.out.println("Enter valid choice!");	
					}
					System.out.print("\npress 0 to exit!\n");
					more = sc.nextInt();	
				}
			}
		}