package Laboratory09.Problem91;

public class MyStringStack {
    MyStringLinkedList str_linked_list;
    public MyStringStack(){
        //instantiate the instance of StringLinkedList in the constructor
        str_linked_list = new MyStringLinkedList();
    }
    public void push(String s){
        str_linked_list.add(s); //adding at the front
    }
    public String pop(){
        //remove the very first element from the list
        String s = str_linked_list.get(0);
        str_linked_list.remove(0);
        return s;
    }
    public String peek(){
        return str_linked_list.get(0);
    }
    public String toString(){
        return str_linked_list.toString();
    }

    public static void main(String[] args){
        MyStringStack stack = new MyStringStack();
        stack.push("Bob");
        stack.push("Harry");
        stack.push("Alice");
        System.out.println(stack.toString());

        System.out.println("Popping..."+stack.pop());
        System.out.println("Peeking..."+stack.peek());
        System.out.println("Popping..."+stack.pop());
        System.out.println(stack.toString());
    }

}
